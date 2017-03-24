package network;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

import Personnage.Perso;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

public class Client {
	private Socket socket;
	private Texture texture;
	private HashMap<String, Perso> friendlyPlayers;
	private Texture friendPlayer;

	public Client(Texture friendPlayer, HashMap<String, Perso> friendlyPlayers) throws Exception {
		connectSocket();

		this.friendPlayer = friendPlayer;
		this.friendlyPlayers = friendlyPlayers;

	}

	private void connectSocket() throws Exception {
		socket = IO.socket("http://localhost:8080");
		socket.connect();
	}

	public void configSocketEvents() {

		socket.on(Socket.EVENT_CONNECT, new Listener() {

			public void call(Object... arg0) {
				System.out.println("Socket IO Connected");

			}
		}).on("socketID", new Listener() {

			public void call(Object... arg0) {
				JSONObject data = (JSONObject) arg0[0];
				try {
					String id = data.getString("id");
					System.out.println("mon id " + id);

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).on("newPlayer", new Listener() {

			public void call(Object... arg0) {
				JSONObject data = (JSONObject) arg0[0];
				try {
					String id = data.getString("id");
					System.out.println("nouveau joueur : " + id);
					friendlyPlayers.put(id, new Perso(friendPlayer));
				} catch (JSONException e) {
					// TODO Auto-generated catch block
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
						System.out.println(playerId);
						double x = datas.getJSONObject(i).getDouble("x");
						double y = datas.getJSONObject(i).getDouble("y");
						System.out.println(playerId + " " + x + " " + y);
						if (friendlyPlayers.get(playerId) != null) {
							Perso a = friendlyPlayers.get(playerId);
							a.setPosition(x, y);
							System.out.println(a.getX());
							friendlyPlayers.put(playerId, a);
							// friendlyPlayers.get(playerId).setPosition(x, y);

						}
					}

				} catch (JSONException e) {
					// TODO Auto-generated catch block

				}

			}
		}).on("getPlayers", new Listener() {

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];

				try {
					for (int i = 0; i < objects.length(); i++) {
						String id = objects.getJSONObject(i).getString("id");
						Perso coopPlayer = new Perso(friendPlayer);
						Vector2 position = new Vector2();
						position.x = ((Double) objects.getJSONObject(i).getDouble("x")).floatValue();
						position.y = ((Double) objects.getJSONObject(i).getDouble("y")).floatValue();
						coopPlayer.setPosition(position.x, position.y);

						friendlyPlayers.put(id, coopPlayer);

					}
				} catch (JSONException e) {

				}

			}
		});
	}

	public void close() {
		this.socket.close();
	}
	
	public void emit(String event, Object...args ){
		this.socket.emit(event, args);
	}
}
