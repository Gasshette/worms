package com.worms.network;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.worms.entities.Enemy;
import com.worms.entities.Player;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

public class Client {
	private Socket socket;
	private HashMap<String, Player> friendlyPlayers;
	private HashMap<String, JSONObject> lobbyPlayers;
	private HashMap<Integer, Enemy> enemies;
	private HashMap<Integer, Texture> hashmapEnemies;
	private Texture friendPlayer;
	private TiledMap map;

	public Client( HashMap<String, JSONObject> lobbyPlayers) throws Exception {
		this.connectSocket();
		this.lobbyPlayers = lobbyPlayers;
	}

	public Client(TiledMap map, Texture friendPlayer, HashMap<String, Player> friendlyPlayers,
			HashMap<Integer, Enemy> enemies, HashMap<Integer, Texture> hashmapEnemies) throws Exception {
		this.connectSocket();

		this.map = map;
		this.friendPlayer = friendPlayer;
		this.friendlyPlayers = friendlyPlayers;
		this.enemies = enemies;
		this.hashmapEnemies = hashmapEnemies;
	}

	private void connectSocket() throws Exception {
		this.socket = IO.socket("http://localhost:8080");
		this.socket.connect();
	}

	public void configSocketEvents() {

		this.socket.on(Socket.EVENT_CONNECT, new Listener() {

			@Override
			public void call(Object... arg0) {
				System.out.println("Socket IO Connected");
			}

		}).on("newPlayer", new Listener() {

			@Override
			public void call(Object... arg0) {
				JSONObject data = (JSONObject) arg0[0];

				try {
					String id = data.getString("id");
					Client.this.friendlyPlayers.put(id,
							new Player(Client.this.friendPlayer,
									(TiledMapTileLayer) Client.this.map.getLayers().get("background"),
									(TiledMapTileLayer) Client.this.map.getLayers().get("foreground")));
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
					Client.this.friendlyPlayers.remove(id);
				} catch (JSONException e) {
					Gdx.app.log("SocketIO", "Error getting disconnected PlayerID");
				}
			}

		}).on("movePlayers", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray datas = (JSONArray) args[0];

				try {
					for (int i = 0; i < datas.length(); i++) {
						String playerId = datas.getJSONObject(i).getString("id");
						double x = datas.getJSONObject(i).getDouble("x");
						double y = datas.getJSONObject(i).getDouble("y");

						if (Client.this.friendlyPlayers.get(playerId) != null) {
							Player player = Client.this.friendlyPlayers.get(playerId);
							player.setX((float) x);
							player.setY((float) y);

							Client.this.friendlyPlayers.put(playerId, player);
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

						Player player = new Player(Client.this.friendPlayer,
								(TiledMapTileLayer) Client.this.map.getLayers().get("background"),
								(TiledMapTileLayer) Client.this.map.getLayers().get("foreground"));
						player.setX((float) x);
						player.setY((float) y);

						Client.this.friendlyPlayers.put(id, player);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		}).on("getLobbyPlayers", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						String id = objects.getJSONObject(i).getString("id");
						String pseudo = objects.getJSONObject(i).getString("pseudo");
						int idTexture = objects.getJSONObject(i).getInt("idTexture");
						boolean isReady = objects.getJSONObject(i).getBoolean("isReady");

						JSONObject player = new JSONObject();
						try {
							player.put("id", id);
							player.put("pseudo", pseudo);
							player.put("idTexture", idTexture);
							player.put("isReady", isReady);
							
						} catch (JSONException e) {
							e.printStackTrace();
						}						
						
						Client.this.lobbyPlayers.put(id, player);
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}

		})
//		.on("updateReady", new Listener() {
//
//			@Override
//			public void call(Object... args) {
//				JSONArray datas = (JSONArray) args[0];
//
//				try {
//					for (int i = 0; i < datas.length(); i++) {
//						String id = datas.getJSONObject(i).getString("id");
//						double x = datas.getJSONObject(i).getDouble("x");
//						double y = datas.getJSONObject(i).getDouble("y");
//
//						if (Client.this.lobbyPlayers.get(id) != null) {
//							Player player = Client.this.friendlyPlayers.get(id);
//							player.setX((float) x);
//							player.setY((float) y);
//							
//							Client.this.lobbyPlayers.get(id).
//
//							Client.this.lobbyPlayers.put(id, player);
//						}
//					}
//				} catch (JSONException e) {
//					e.printStackTrace();
//				}
//			}
//
//		})
		.on("newEnemy", new Listener() {

			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];

				Texture texture = null;
				try {
					int id = data.getInt("id");
					double x = data.getDouble("x");
					double y = data.getDouble("y");
					int idTexture = data.getInt("texture");

					for (HashMap.Entry<Integer, Texture> entry : Client.this.hashmapEnemies.entrySet()) {
						if (entry.getKey() == idTexture) {
							texture = entry.getValue();
						}
					}

					Enemy enemy = new Enemy(texture, (float) x, (float) y);
					Client.this.enemies.put(id, enemy);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}).on("getEnemies", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						int texture = objects.getJSONObject(i).getInt("texture");

						double x = objects.getJSONObject(i).getDouble("x");
						double y = objects.getJSONObject(i).getDouble("y");

						int id = objects.getJSONObject(i).getInt("id");

						System.out.println("Texture : " + texture);
						System.out.println("X : " + x);
						System.out.println("Y : " + y);
						System.out.println("id : " + id);
						System.out.println("------");

						if (Client.this.enemies.get(id) != null) {
							Enemy enemy = Client.this.enemies.get(id);
							enemy.setX((float) x);
							enemy.setY((float) y);

							Client.this.enemies.put(id, enemy);
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

				// try {
				// for (int i = 0; i < objects.length(); i++) {
				// String playerId = objects.getJSONObject(i).getString("id");
				// double x = objects.getJSONObject(i).getDouble("x");
				// double y = objects.getJSONObject(i).getDouble("y");
				//
				// if (Client.this.friendlyPlayers.get(playerId) != null) {
				// Player player = Client.this.friendlyPlayers.get(playerId);
				// player.setX((float) x);
				// player.setY((float) y);
				//
				// Client.this.friendlyPlayers.put(playerId, player);
				// }
				// }
				// } catch (JSONException e) {
				// e.printStackTrace();
				// }
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
