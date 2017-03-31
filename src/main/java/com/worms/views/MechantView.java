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
import com.worms.entities.Mechant;
import com.worms.entities.Player;
import com.worms.game.GameWorms;
import com.worms.network.Client;

public class MechantView implements Screen {
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private Mechant player;
	private final GameWorms game;
	private Texture friendPlayer;

	/**
	 * 
	 * 
	 * VARIABLE MULTI
	 */
	private Client client = null;
	private HashMap<String, Player> friendlyPlayers;
	private final float UPDATE_TIME = 1 / 60f;
	float timer = 0;

	public MechantView(GameWorms game) {
		this.game = game;
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load("carte.tmx");
		this.renderer = new OrthogonalTiledMapRenderer(this.map);
		this.camera = new OrthographicCamera();
		this.camera.zoom = 2f;
		this.camera.position.y = 1200;
		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.friendlyPlayers = new HashMap<String, Player>();

		try {
			this.client = new Client(this.map, this.friendPlayer, this.friendlyPlayers);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		this.player = new Mechant();
		this.player.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		Gdx.input.setInputProcessor(this.player);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		/**
		 * Gestion de la camera
		 */
		this.camera.position.set(this.player.getX() + this.player.getWidth(), this.player.getY() + this.player.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		/**
		 * Gestion du rendu
		 */
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.player.draw(this.renderer.getBatch());
		this.renderer.getBatch().end();

		/**
		 * Affichage des autres joueurs
		 */
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
