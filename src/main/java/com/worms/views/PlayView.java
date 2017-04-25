package com.worms.views;

import java.util.ArrayList;
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
	private ArrayList<Bullet> bullets;
	private ArrayList<Bullet> bulletsToRemove;
	private int decalage = 15;

	// Ennemies
	private HashMap<Integer, Enemy> enemies;
	private ArrayList<Integer> enemiesToRemove;

	// Multi
	private Client client = null;
	private HashMap<String, Player> friendlyPlayers;
	private final float UPDATE_TIME = 1 / 60f;
	private float timer = 0;
	private HashMap<Integer, Texture> hashmapEnemies;
	private HudHero hud;

	public PlayView(GameWorms game) {
		this.game = game;
		// this.client = client;
		this.hud = new HudHero(game.getSb());
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load(this.game.getMap());
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.camera = new OrthographicCamera();

		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.friendlyPlayers = new HashMap<String, Player>();

		this.player = new Player(new Texture(Gdx.files.internal("Base pack/Player/p1_front.png")),
				(TiledMapTileLayer) this.map.getLayers().get("background"),
				(TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.setPosition(2 * 70, 19 * 70);
		this.player.setHud(this.hud);

		this.enemies = new HashMap<Integer, Enemy>();
		this.hashmapEnemies = new HashMap<Integer, Texture>();
		this.hashmapEnemies.put(1, new Texture(Gdx.files.internal("Base pack/Enemies/flyFly1.png")));
		this.hashmapEnemies.put(2, new Texture(Gdx.files.internal("Base pack/Enemies/slimeWalk1.png")));
		this.hashmapEnemies.put(3,
				new Texture(Gdx.files.internal("Extra animations and enemies/Enemy sprites/spider.png")));

		try {
			this.client = new Client(this.map, this.friendPlayer, this.friendlyPlayers, this.enemies,
					this.hashmapEnemies);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.bullets = new ArrayList<Bullet>();
		this.bulletsToRemove = new ArrayList<Bullet>();
		this.enemiesToRemove = new ArrayList<Integer>();

		Gdx.input.setInputProcessor(this.player);
	}

	@Override
	public void render(float delta) {

		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Camera

		this.camera.position.set(this.player.getX() + this.player.getWidth(),
				this.player.getY() + this.player.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		// Rendu
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.draw(this.renderer.getBatch());

		// Shooting
		if (this.player.isShoot() && this.decalage == this.player.getTimerDecalage()) {
			this.bullets.add(new Bullet(new Texture(Gdx.files.internal("Request pack/Tiles/laserGreenBurst.png")),
					this.player.getX(), this.player.getY()));
		}
		this.decalage--;
		this.decalage = (this.decalage == 0) ? this.player.getTimerDecalage() : this.decalage;

		// Affichage des bullets
		for (Bullet bullet : this.bullets) {
			bullet.update(Gdx.graphics.getDeltaTime());

			if (bullet.getRemove()) {
				this.bulletsToRemove.add(bullet);
			}
		}

		// Gestion de la collision bullet / ennemy
		for (Bullet bullet : this.bullets) {
			for (HashMap.Entry<Integer, Enemy> entry : this.enemies.entrySet()) {
				if (bullet.getCollision().collidesWith(entry.getValue().getCollision())) {
					this.bulletsToRemove.add(bullet);
					this.enemiesToRemove.add(entry.getKey());
					System.out.println("collision");
					break;
				}
			}
		}

		// On supprime la balle et l'ennemi et on envoi au client
		this.enemies.keySet().removeAll(this.enemiesToRemove);
		this.bullets.removeAll(this.bulletsToRemove);

		if (this.enemiesToRemove.size() > 0) {
			this.client.emit("killEnemies", this.enemiesToRemove);
			this.enemiesToRemove = new ArrayList<Integer>();
		}

		for (Bullet bullet : this.bullets) {
			bullet.render(this.renderer.getBatch());
		}

		// Display enemies
		this.majEnemiesPosition(Gdx.graphics.getDeltaTime());
		for (HashMap.Entry<Integer, Enemy> entry : this.enemies.entrySet()) {
			// entry.getValue().update(Gdx.graphics.getDeltaTime());
			entry.getValue().draw(this.renderer.getBatch());
		}

		// Display players
		this.majPlayersPosition(Gdx.graphics.getDeltaTime());
		for (HashMap.Entry<String, Player> entry : this.friendlyPlayers.entrySet()) {
			entry.getValue().draw(this.renderer.getBatch());
		}

		this.renderer.getBatch().end();
		this.hud.stage.draw();
		this.hud.update(this.UPDATE_TIME);
		if(this.player.isLife() == false){
			this.game.setScreen(new GameOverView(game,this.player));
		}

	}

	@Override
	public void resize(int width, int height) {
		this.camera.viewportWidth = width;
		this.camera.viewportHeight = height;
	}

	public void majEnemiesPosition(float dt) {
		for (HashMap.Entry<Integer, Enemy> entry : this.enemies.entrySet()) {
			System.out.println(entry.getValue().getX());
			System.out.println(entry.getValue().getY());
			System.out.println(entry.getKey());
		}
		// this.timer += dt;
		// if (this.timer >= this.UPDATE_TIME && this.player != null) {
		// JSONObject data = new JSONObject();
		// try {
		// data.put("x", this.player.getX());
		// data.put("y", this.player.getY());
		//
		// this.client.emit("movePlayers", data);
		// } catch (JSONException e) {
		// e.printStackTrace();
		// }
		// }
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
