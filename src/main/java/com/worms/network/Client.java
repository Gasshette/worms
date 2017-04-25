package com.worms.network;

import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.worms.entities.Bullet;
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
	private HashMap<Integer, Bullet> bullets;
	private HashMap<Integer, Texture> hashmapBullets;
	private Texture friendPlayer;
	private TiledMap map;

	public Client( HashMap<String, JSONObject> lobbyPlayers) throws Exception {
		this.connectSocket();
		this.lobbyPlayers = lobbyPlayers;
	}

	
	public Client(TiledMap map, Texture friendPlayer, HashMap<String, Player> friendlyPlayers, 
			HashMap<Integer, Enemy> enemies, HashMap<Integer, Texture> hashmapEnemies, 
			HashMap<Integer, Bullet> bullets, HashMap<Integer, Texture> hashmapBullets
			) throws Exception {
		this.connectSocket();

		this.map = map;
		this.friendPlayer = friendPlayer;
		this.friendlyPlayers = friendlyPlayers;
		this.enemies = enemies;
		this.hashmapEnemies = hashmapEnemies;
		this.bullets = bullets;
		this.hashmapBullets = hashmapBullets;
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
		})
		.on("moveEnemies", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						double x = objects.getJSONObject(i).getDouble("x");
						double y = objects.getJSONObject(i).getDouble("y");

						int id = objects.getJSONObject(i).getInt("id");

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

			}

		}).on("deleteEnemy", new Listener() {

			@Override
			public void call(Object... args) {
				int id = (int) args[0];
				Client.this.enemies.remove(id);
				
				for (HashMap.Entry<Integer, Enemy> entry : Client.this.enemies.entrySet()) {
					if(entry.getKey() == id) {
						Client.this.enemies.remove(entry.getKey());
					}
				}
			}

		}).on("newBullet", new Listener() {

			@Override
			public void call(Object... args) {
				JSONObject data = (JSONObject) args[0];
				Texture texture = null;

				try {
					int id = data.getInt("id");
					double x = data.getDouble("x");
					double y = data.getDouble("y");
					int idTexture = data.getInt("texture");
					
					for (HashMap.Entry<Integer, Texture> entry : Client.this.hashmapBullets.entrySet()) {
						if (entry.getKey() == idTexture) {
							texture = entry.getValue();
						}
					}

					Bullet bullet = new Bullet(texture, (float) x, (float) y);
					Client.this.bullets.put(id, bullet);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		})
		.on("moveBullets", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						double x = objects.getJSONObject(i).getDouble("x");
						int id = objects.getJSONObject(i).getInt("id");

						if (Client.this.bullets.get(id) != null) {
							Bullet bullet = Client.this.bullets.get(id);
							bullet.setX((float) x);

							Client.this.bullets.put(id, bullet);
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}

		}).on("deleteBullet", new Listener() {

			@Override
			public void call(Object... args) {
				int id = (int) args[0];
				Client.this.bullets.remove(id);
				
				for (HashMap.Entry<Integer, Bullet> bullet : Client.this.bullets.entrySet()) {
					if(bullet.getKey() == id) {
						Client.this.bullets.remove(bullet.getKey());
					}
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
