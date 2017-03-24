package core;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;

import Personnage.Perso;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;
import network.Client;

public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch sb;
	TiledMap tiledMap;
	TiledMapRenderer tiledMapRenderer;
	Perso player = null;
	HashMap<String, Perso> friendlyPlayers;
	Texture friendPlayer;
	Texture texture;
	Texture img;
	float vitesse = 5;
	Client c = null;
	private final float UPDATE_TIME = 1 / 60f;
	float timer = 0;;

	@Override
	public void create() {
		sb = new SpriteBatch();
		tiledMap = new TmxMapLoader().load("mapTest.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);
		texture = new Texture(Gdx.files.internal("Base pack/Player/p1_front.png"));
		friendlyPlayers = new HashMap<String, Perso>();
		player = new Perso(texture);
		friendPlayer = new Texture(Gdx.files.internal("Base pack/Player/p2_front.png"));
		try {

			c = new Client(friendPlayer, friendlyPlayers);
			c.configSocketEvents();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Gdx.input.setInputProcessor(this);
	}

	public void updateServer(float dt) {
		timer += dt;
		if (timer >= UPDATE_TIME && player != null && player.hasMoved()) {
			JSONObject data = new JSONObject();
			try {
				// data.put("id", this.socket.id());
				data.put("x", player.getX());
				data.put("y", player.getY());
				this.c.emit("moved", data);

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	@Override
	public void resize(int width, int height) {
	}

	public void handleInput(float dt) {
		if (player != null) {
			if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

				player.setPosition(player.getX() - vitesse, player.getY());
			}

			if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {

				player.setPosition(player.getX() + vitesse, player.getY());
			}

			if (Gdx.input.isKeyPressed(Input.Keys.UP)) {

				player.setPosition(player.getX(), player.getY() + vitesse);
			}

			if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {

				player.setPosition(player.getX(), player.getY() - vitesse);
			}

		}
	}

	@Override
	public void render() {
		handleInput(Gdx.graphics.getDeltaTime());
		updateServer(Gdx.graphics.getDeltaTime());
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		tiledMapRenderer.render();
		sb.begin();
		if (player != null) {
			player.draw(sb);
		}

		for (HashMap.Entry<String, Perso> entry : friendlyPlayers.entrySet()) {
			// System.out.println(entry.getValue().getX());
			entry.getValue().draw(sb);
			// System.out.println(entry.getValue().getX());
		}
		sb.end();
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		super.dispose();
		c.close();

	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
