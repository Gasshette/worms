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

	/**
	 * Shoot
	 */
	private ArrayList<Bullet> bullets;
	private ArrayList<Bullet> bulletsToRemove;
	private int decalage = 15; // A mettre dans personnage
	private final int timerDecalage = 15; // A mettre dans personnage
	/**
	 * 
	 * 
	 * VARIABLE MULTI
	 */
	private Client client = null;
	private HashMap<String, Player> mates;
	private final float UPDATE_TIME = 1 / 60f;
	float timer = 0;

	public PlayView(GameWorms game, Client client) {
		this.game = game;
		this.client = client;
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load("carte.tmx");
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.camera = new OrthographicCamera();

		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.mates = new HashMap<String, Player>();

		this.player = new Player(new Texture(Gdx.files.internal("Base pack/Player/p1_front.png")),
				(TiledMapTileLayer) this.map.getLayers().get("background"),
				(TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.setPosition(2 * 70, 19 * 70);

		try {
			this.client = new Client(this.map, this.friendPlayer, this.mates);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.bullets = new ArrayList<Bullet>();
		this.bulletsToRemove = new ArrayList<Bullet>();

		Gdx.input.setInputProcessor(this.player);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/**
		 * Gestion de la camera
		 */
		this.camera.position.set(this.player.getX() + this.player.getWidth(),
				this.player.getY() + this.player.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		/**
		 * Gestion du rendu
		 */
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.draw(this.renderer.getBatch());

		// this.renderer.getBatch().end();
		// this.updateServer(Gdx.graphics.getDeltaTime());

		if (this.player.isShoot() && this.decalage == this.timerDecalage) {
			this.bullets.add(new Bullet(new Texture(Gdx.files.internal("Request pack/Tiles/laserGreenBurst.png")),
					this.player.getX(), this.player.getY()));
		}

		this.decalage--;
		this.decalage = (this.decalage == 0) ? this.timerDecalage : this.decalage;

		for (Bullet bullet : this.bullets) {
			bullet.update(Gdx.graphics.getDeltaTime());

			if (bullet.getRemove()) {
				this.bulletsToRemove.add(bullet);
			}
		}
		this.bullets.removeAll(this.bulletsToRemove);

		for (Bullet bullet : this.bullets) {
			bullet.render(this.renderer.getBatch());
		}
		this.renderer.getBatch().end();

		this.updateServer(Gdx.graphics.getDeltaTime());

		/**
		 * Affichage des autres joueurs
		 */
		for (HashMap.Entry<String, Player> entry : this.mates.entrySet()) {
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
