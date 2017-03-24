package com.worms.game.screens;

import java.util.HashMap;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.worms.game.GameWorms;
import com.worms.game.entities.Player;
import com.worms.game.network.Client;

public class PlayScreen implements Screen {
	
	private TiledMap map;
	private OrthogonalTiledMapRenderer renderer;
	private OrthographicCamera camera;
	
	private Player player;
	private GameWorms g;
	
	
	/**
	 * 
	 * 
	 * VARIABLE MULTI
	 */
	private Client client = null;
	private HashMap<String, Player> friendlyPlayers;
	private final float UPDATE_TIME = 1 / 60f;
	float timer = 0;
	
	
	
	public PlayScreen(GameWorms g) {
		this.g = g;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		camera.position.set(player.getX() + player.getWidth(), player.getY() + player.getHeight(), 0);
		camera.update();
		
		renderer.setView(camera);
		
		/**
		 * On start le rendu final
		 */
		renderer.getBatch().begin();
		/**
		 * On mets par ordre de couches
		 */
		renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get("background"));
		renderer.renderTileLayer((TiledMapTileLayer) map.getLayers().get("foreground"));
		player.draw(renderer.getBatch());
		
		/**
		 * On end le rendu final
		 */
		renderer.getBatch().end();
		
		
		/**
		 * Sorties de map
		 */
		float t = ((TiledMapTileLayer) map.getLayers().get(1)).getWidth() * ((TiledMapTileLayer) map.getLayers().get(1)).getTileWidth();
		
		System.out.println(t);
		System.out.println("X "+player.getX() + " - Y "+player.getY());
		
		/**
		 * Gere les sorties de map (Gauche, droite, bas)
		 */
		if(player.getX() < 0 || player.getY() < 0 || player.getX() > (t - player.getWidth())) {
			g.setScreen(new MainMenuScreen(g));
		}
		
		
		
		updateServer(Gdx.graphics.getDeltaTime());
		for (HashMap.Entry<String, Player> entry : friendlyPlayers.entrySet()) {
			//System.out.println(entry.getValue().getX());
			entry.getValue().draw(renderer.getBatch());
			//System.out.println(entry.getValue().getX());
		}
	}

	@Override
	public void resize(int width, int height) {
		camera.viewportWidth = width;
		camera.viewportHeight = height;
	}
	
	public void updateServer(float dt) {
		timer += dt;
		if (timer >= UPDATE_TIME && player != null ) {
			JSONObject data = new JSONObject();
			try {
				//data.put("id", this.socket.id());
				data.put("x", player.getX());
				data.put("y", player.getY());
				client.emit("moved", data);
			
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
		
	@Override
	public void show() {
		map = new TmxMapLoader().load("sprites/carte.tmx");
		
		TiledMapTileLayer layer = (TiledMapTileLayer) map.getLayers().get(1);
		
		System.out.println(layer);
		

		renderer = new OrthogonalTiledMapRenderer(map);
		
		camera = new OrthographicCamera();
		
		player = new Player(g, new Sprite(new Texture("sprites/Base pack/Player/p1_front.png")), (TiledMapTileLayer) map.getLayers().get("background"), (TiledMapTileLayer) map.getLayers().get("foreground"));
		
		
		
		/**
		 *  On le place a 2 tuiles du debut (2 * player.getCollisionLayer().getTileWidth())
		 *  On le place 
		 *  	- Nombre de tuiles en hauteur (player.getCollisionLayer().getHeight()) 
		 *  	- Moins la position choisie sur la map (19)
		 *  	- Fois la taille d'une tuille
		 */
		player.setPosition(2 * player.getCollisionLayer().getTileWidth(), (player.getCollisionLayer().getHeight() - 19) * player.getCollisionLayer().getTileHeight());
		
		Gdx.input.setInputProcessor(player);
		
		
		friendlyPlayers = new HashMap<String, Player>();
		try {
			client = new Client(g, (TiledMapTileLayer) map.getLayers().get("background"), (TiledMapTileLayer) map.getLayers().get("foreground"), friendlyPlayers);
			client.configSocketEvents();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void hide() {
		dispose();
	}
	
	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}



	@Override
	public void dispose() {
		map.dispose();
		renderer.dispose();
		player.getTexture().dispose();
		client.close();
	}

}
