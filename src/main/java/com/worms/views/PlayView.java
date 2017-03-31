package com.worms.views;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

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
	private float spawn;
	private float spawnTimerMin = 0.3f;
	private float spawnTimerMax = 0.6f;
	private Random random;
	private ArrayList<Enemy> enemies;
	private ArrayList<Enemy> enemiesToRemove;

	// Multi
	private Client client = null;
	private HashMap<String, Player> friendlyPlayers;
	private final float UPDATE_TIME = 1 / 60f;
	float timer = 0;

	public PlayView(GameWorms game) {
		this.game = game;
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load("carte.tmx");
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.camera = new OrthographicCamera();

		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.friendlyPlayers = new HashMap<String, Player>();

		this.player = new Player(new Texture(Gdx.files.internal("Base pack/Player/p1_front.png")), (TiledMapTileLayer) this.map.getLayers().get("background"), (TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.setPosition(2 * 70, 19 * 70);

		try {
			this.client = new Client(this.map, this.friendPlayer, this.friendlyPlayers);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.bullets = new ArrayList<Bullet>();
		this.bulletsToRemove = new ArrayList<Bullet>();

		this.enemies = new ArrayList<Enemy>();
		this.enemiesToRemove = new ArrayList<Enemy>();

		this.random = new Random();
		this.resetSpawnB();

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
			this.bullets.add(new Bullet(new Texture(Gdx.files.internal("Request pack/Tiles/laserGreenBurst.png")), this.player.getX(), this.player.getY()));
		}
		this.decalage--;
		this.decalage = (this.decalage == 0) ? this.player.getTimerDecalage() : this.decalage;

		// Ennemies
		this.spawn -= Gdx.graphics.getDeltaTime();
		if (this.spawn < 0) {
			Enemy newEnemy;
			int spawnY = (int) (Math.floor(Math.random() * (Gdx.graphics.getHeight() * 2 - 500)) + 500);
			int spawnX = (int) (this.player.getX() + Gdx.graphics.getWidth());
			this.resetSpawnB();

			while (spawnY < 500 || spawnY > Gdx.graphics.getHeight() * 2) {
				spawnY = (int) (Math.floor(Math.random() * (Gdx.graphics.getHeight() * 2 - 500)) + 500);
			}

			newEnemy = new Enemy(new Texture(Gdx.files.internal("Base pack/Enemies/flyFly1.png")), spawnX, spawnY);
			this.enemies.add(newEnemy);
		}

		// Affichage des ennemies
		for (Enemy enemy : this.enemies) {
			enemy.update(Gdx.graphics.getDeltaTime());

			if (enemy.getRemove()) {
				this.enemiesToRemove.add(enemy);
			}
		}

		// Affichage des bullets
		for (Bullet bullet : this.bullets) {
			bullet.update(Gdx.graphics.getDeltaTime());

			if (bullet.getRemove()) {
				this.bulletsToRemove.add(bullet);
			}
		}

		// Gestion de la collision bullet / ennemy
		for (Bullet bullet : this.bullets) {
			for (Enemy enemy : this.enemies) {
				if (bullet.getCollision().collidesWith(enemy.getCollision())) {
					this.bulletsToRemove.add(bullet);
					this.enemiesToRemove.add(enemy);
				}
			}
		}

		this.enemies.removeAll(this.enemiesToRemove);
		this.bullets.removeAll(this.bulletsToRemove);

		for (Bullet bullet : this.bullets) {
			bullet.render(this.renderer.getBatch());
		}

		for (Enemy enemy : this.enemies) {
			enemy.render(this.renderer.getBatch());
		}

		this.renderer.getBatch().end();

		// Multi
		this.updateServer(Gdx.graphics.getDeltaTime());
		for (HashMap.Entry<String, Player> entry : this.friendlyPlayers.entrySet()) {
			this.renderer.getBatch().begin();
			entry.getValue().draw(this.renderer.getBatch());
			this.renderer.getBatch().end();
		}
	}

	@Override
	public void resize(int width, int height) {
		this.camera.viewportWidth = width;
		this.camera.viewportHeight = height;
	}

	public void updateServer(float dt) {
		this.timer += dt;
		if (this.timer >= this.UPDATE_TIME && this.player != null) {
			JSONObject data = new JSONObject();
			try {
				data.put("x", this.player.getX());
				data.put("y", this.player.getY());
				this.client.emit("moved", data);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void resetSpawnB() {
		this.spawn = this.random.nextFloat() * (this.spawnTimerMax - this.spawnTimerMin) + this.spawnTimerMin;
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
	}

}
