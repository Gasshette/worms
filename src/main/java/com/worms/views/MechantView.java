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
import com.worms.entities.Enemy;
import com.worms.entities.Mechant;
import com.worms.entities.Player;
import com.worms.game.GameWorms;
import com.worms.hud.HudMechant;
import com.worms.network.Client;

public class MechantView implements Screen {
	private final GameWorms game;
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	private HudMechant hud;

	// Solo
	private Mechant mechant;

	// Multi
	private Client client = null;

	private Texture friendPlayer;
	private HashMap<String, Player> friendlyPlayers;

	private HashMap<Integer, Enemy> enemies;
	private HashMap<Integer, Texture> hashmapEnemies;

	public MechantView(GameWorms game) {
		this.game = game;
		this.hud = new HudMechant(this.game.getSb());
	}

	@Override
	public void show() {
		this.map = new TmxMapLoader().load(this.game.getMap());
		this.renderer = new OrthogonalTiledMapRenderer(this.map);

		this.camera = new OrthographicCamera();
		this.camera.zoom = 2f;

		this.friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		this.friendlyPlayers = new HashMap<String, Player>();

		this.enemies = new HashMap<Integer, Enemy>();
		this.hashmapEnemies = new HashMap<Integer, Texture>();
		this.hashmapEnemies.put(1, new Texture(Gdx.files.internal("Base pack/Enemies/flyFly1.png")));
		this.hashmapEnemies.put(2, new Texture(Gdx.files.internal("Base pack/Enemies/slimeWalk1.png")));
		this.hashmapEnemies.put(3, new Texture(Gdx.files.internal("Extra animations and enemies/Enemy sprites/spider.png")));

		this.mechant = new Mechant();
		this.mechant.setPosition(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		this.mechant.setHud(this.hud);

		try {
			this.client = new Client(this.map, this.friendPlayer, this.friendlyPlayers, this.enemies, this.hashmapEnemies);
			this.client.configSocketEvents();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Gdx.input.setInputProcessor(this.mechant);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Gestion de la camera
		this.camera.position.set(this.mechant.getX() + this.mechant.getWidth(), this.mechant.getY() + this.mechant.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		this.game.getSb().setProjectionMatrix(this.hud.stage.getCamera().combined);

		// Gestion du rendu
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.mechant.draw(this.renderer.getBatch());

		// Add enemy
		if (this.mechant.isAddEnemy()) {
			int spawnY, spawnX;

			// Get the player the X position of the 1st player
			float maxPositionPlayer = 0;
			for (HashMap.Entry<String, Player> entry : this.friendlyPlayers.entrySet()) {
				if (entry.getValue().getX() > maxPositionPlayer) {
					maxPositionPlayer = entry.getValue().getX();
				}
			}
			spawnX = (int) ((int) maxPositionPlayer == 0 ? Gdx.graphics.getWidth() * 2 : (maxPositionPlayer + 500));

			switch (this.mechant.getEnemyToAdd()) {
			case 1:
				spawnY = (int) (Math.floor(Math.random() * (Gdx.graphics.getHeight() * 2 - 500)) + 500);
				while (spawnY < 500 || spawnY > Gdx.graphics.getHeight() * 2) {
					spawnY = (int) (Math.floor(Math.random() * (Gdx.graphics.getHeight() * 2 - 500)) + 500);
				}
				break;
			case 2:
			case 3:
				spawnY = (int) (6 * ((TiledMapTileLayer) this.map.getLayers().get("background")).getTileHeight());
				break;
			default:
				spawnY = (int) (Math.floor(Math.random() * (Gdx.graphics.getHeight() * 2 - 500)) + 500);
				break;
			}

			JSONObject enemy = new JSONObject();
			try {
				enemy.put("x", spawnX);
				enemy.put("y", spawnY);
				enemy.put("texture", this.mechant.getEnemyToAdd());
			} catch (JSONException e) {
				e.printStackTrace();
			}

			this.client.emit("newEnemy", enemy);
			this.mechant.setAddEnemy(false);
		}

		// Display enemies
		for (HashMap.Entry<Integer, Enemy> entry : this.enemies.entrySet()) {
			entry.getValue().update(Gdx.graphics.getDeltaTime());
			entry.getValue().draw(this.renderer.getBatch());
		}

		// Display players
		for (HashMap.Entry<String, Player> entry : this.friendlyPlayers.entrySet()) {
			entry.getValue().draw(this.renderer.getBatch());
		}

		this.renderer.getBatch().end();

		// Display HUD
		this.hud.stage.draw();
		/**
		 * Gestion de la camera
		 */
		this.camera.position.set(this.mechant.getX() + this.mechant.getWidth(), this.mechant.getY() + this.mechant.getHeight(), 0);
		this.camera.update();
		this.renderer.setView(this.camera);

		/**
		 * Gestion du rendu
		 */
		this.renderer.getBatch().begin();
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("background"));
		this.renderer.renderTileLayer((TiledMapTileLayer) this.map.getLayers().get("foreground"));
		this.mechant.draw(this.renderer.getBatch());
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
		this.mechant.getTexture().dispose();
		this.client.close();
	}

}
