package com.worms.views;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.worms.entities.Bullet;
import com.worms.entities.Enemy;
import com.worms.entities.Player;
import com.worms.game.GameWorms;
import com.worms.hud.HudHero;
import com.worms.network.Client;

public class PlayView implements Screen {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Player player;
	private final GameWorms game;
	private Texture friendPlayer;

	// Shooting
	private HashMap<Integer, Texture> hashmapBullets = new HashMap<Integer, Texture>();
	private HashMap<Integer, Bullet> bullets;
	private int bulletRemove;
	private int decalage = 15;

	// Ennemies
	private HashMap<Integer, Texture> hashmapEnemies = new HashMap<Integer, Texture>();
	private HashMap<Integer, Enemy> enemies;
	private int enemyRemove;

	// Multi
	private Client client = null;
	private HashMap<String, Player> friendlyPlayers;
	private final float UPDATE_TIME = 1 / 60f;
	private float timer = 0;
	private HudHero hud;

	public PlayView(GameWorms game) {
		this.game = game;
		// this.client = client;
		this.hud = new HudHero(this.game.getSb());
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load(this.game.getMap());
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.camera = new OrthographicCamera();

		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.friendlyPlayers = new HashMap<String, Player>();

		this.player = new Player(new Texture(Gdx.files.internal("Base pack/Player/p1_front.png")), (TiledMapTileLayer) this.map.getLayers().get("background"), (TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.setPosition(2 * 70, 19 * 70);
		this.player.setHud(this.hud);
		this.enemies = new HashMap<Integer, Enemy>();
		this.hashmapEnemies.put(1, new Texture(Gdx.files.internal("Base pack/Enemies/flyFly1.png")));
		this.hashmapEnemies.put(2, new Texture(Gdx.files.internal("Base pack/Enemies/slimeWalk1.png")));
		this.hashmapEnemies.put(3, new Texture(Gdx.files.internal("Extra animations and enemies/Enemy sprites/spider.png")));

		this.bullets = new HashMap<Integer, Bullet>();
		this.hashmapBullets.put(1, new Texture(Gdx.files.internal("Request pack/Tiles/laserPurple.png")));
		this.hashmapBullets.put(2, new Texture(Gdx.files.internal("Request pack/Tiles/laserPurple.png")));
		this.hashmapBullets.put(3, new Texture(Gdx.files.internal("Request pack/Tiles/laserPurple.png")));

		try {
			this.client = new Client(this.map, this.friendPlayer, this.friendlyPlayers, this.enemies, this.hashmapEnemies, this.bullets, this.hashmapBullets);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Gdx.input.setInputProcessor(this.player);
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Camera

		this.camera.position.set(this.player.getX() + this.player.getWidth(), this.player.getY() + this.player.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		// Rendu
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.draw(this.renderer.getBatch());

		// Shooting
		if (this.player.isShoot() && this.decalage == this.player.getTimerDecalage()) {
			JSONObject bullet = new JSONObject();
			try {
				bullet.put("x", this.player.getX());
				bullet.put("y", this.player.getY());
				bullet.put("texture", 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			this.client.emit("newBullet", bullet);
		}
		this.decalage--;
		this.decalage = (this.decalage == 0) ? this.player.getTimerDecalage() : this.decalage;

		// Gestion de la collision bullet / ennemy
		for (HashMap.Entry<Integer, Bullet> bullet : this.bullets.entrySet()) {
			for (HashMap.Entry<Integer, Enemy> enemy : this.enemies.entrySet()) {
				if (bullet.getValue().getCollision().collidesWith(enemy.getValue().getCollision())) {
					this.bulletRemove = bullet.getKey();
					this.enemyRemove = enemy.getKey();
					break;
				}
			}
		}

		// BEGIN DELETE BLOC
		// enemy
		if (this.enemyRemove > 0) {
			this.client.emit("deleteEnemy", this.enemyRemove);
			this.enemyRemove = 0;
		}

		// bullet
		if (this.bulletRemove > 0) {
			this.client.emit("deleteBullet", this.bulletRemove);
			this.bulletRemove = 0;
		}
		// END DELETE BLOC

		// BEGIN DISPLAY BLOC
		// players
		this.majPlayersPosition(Gdx.graphics.getDeltaTime());
		for (HashMap.Entry<String, Player> player : this.friendlyPlayers.entrySet()) {
			player.getValue().draw(this.renderer.getBatch());
		}

		// enemies
		for (HashMap.Entry<Integer, Enemy> enemy : this.enemies.entrySet()) {
			enemy.getValue().draw(this.renderer.getBatch());
		}

		// bullets
		for (HashMap.Entry<Integer, Bullet> bullet : this.bullets.entrySet()) {
			bullet.getValue().render(this.renderer.getBatch());
		}
		// END DISPLAY BLOC

		this.renderer.getBatch().end();
		this.hud.stage.draw();
		this.hud.update(this.UPDATE_TIME);
		
		if (this.player.isLife() == false) {
			this.game.setScreen(new GameOverView(this.game, this.player));
		}
	}

	@Override
	public void resize(int width, int height) {
		this.camera.viewportWidth = width;
		this.camera.viewportHeight = height;
	}


	public void majPlayersPosition(float dt) {
		this.timer += dt;
		if (this.timer >= this.UPDATE_TIME && this.player != null) {
			JSONObject data = new JSONObject();
			try {
				data.put("x", this.player.getX());
				data.put("y", this.player.getY());

				this.client.emit("movePlayers", data);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void hide() {
		this.dispose();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		this.map.dispose();
		this.renderer.dispose();
		this.player.getTexture().dispose();
		this.client.close();
		this.hud.dispose();
	}

}
