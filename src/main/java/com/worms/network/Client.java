package com.worms.network;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.worms.entities.Player;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

public class Client {
	private Socket socket;
	private HashMap<String, Player> friendlyPlayers;
	private Texture friendPlayer;
	private TiledMap map = new TmxMapLoader().load("carte.tmx");

	public Client(Texture friendPlayer, HashMap<String, Player> friendlyPlayers) throws Exception {
		connectSocket();

		this.friendPlayer = friendPlayer;
		this.friendlyPlayers = friendlyPlayers;

	}

	private void connectSocket() throws Exception {
		socket = IO.socket("http://92.222.82.5:8080");
		socket.connect();
	}

	public void configSocketEvents() {

		socket.on(Socket.EVENT_CONNECT, new Listener() {

			public void call(Object... arg0) {
				System.out.println("Socket IO Connected");

			}
		}).on("newPlayer", new Listener() {

			public void call(Object... arg0) {
				JSONObject data = (JSONObject) arg0[0];
				
				try {
					String id = data.getString("id");
					friendlyPlayers.put(id, new Player(friendPlayer, (TiledMapTileLayer) map.getLayers().get("background"), (TiledMapTileLayer) map.getLayers().get("foreground")));
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		}).on("playerDisconnected", new Listener() {

			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];
				
				try {
					String id = data.getString("id");
					friendlyPlayers.remove(id);
				} catch (JSONException e) {
					Gdx.app.log("SocketIO", "Error getting disconnected PlayerID");
				}
				
			}
			
		}).on("moved", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray datas = (JSONArray) args[0];

				try {
					for (int i = 0; i < datas.length(); i++) {
						String playerId = datas.getJSONObject(i).getString("id");
						double x = datas.getJSONObject(i).getDouble("x");
						double y = datas.getJSONObject(i).getDouble("y");
						
						if (friendlyPlayers.get(playerId) != null) {
							Player player = friendlyPlayers.get(playerId);
							player.setX((float) x);
							player.setY((float) y);

							friendlyPlayers.put(playerId, player);
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
		}).on("getPlayers", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						String id = objects.getJSONObject(i).getString("id");
						double x = objects.getJSONObject(i).getDouble("x");
						double y = objects.getJSONObject(i).getDouble("y");
						
						Player player = new Player(friendPlayer, (TiledMapTileLayer) map.getLayers().get("background"), (TiledMapTileLayer) map.getLayers().get("foreground"));
						player.setX((float) x);
						player.setY((float) y);
						
						friendlyPlayers.put(id, player);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
			
		});
	}

	public void close() {
		this.socket.close();
	}

	public void emit(String event, Object... args) {
		this.socket.emit(event, args);
	}
}
