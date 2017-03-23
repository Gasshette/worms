package com.worms.game.network;

import java.net.URISyntaxException;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.math.Vector2;
import com.worms.game.GameWorms;
import com.worms.game.entities.Player;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

public class Client {
	private Socket socket;
	private TiledMapTileLayer background;
	private TiledMapTileLayer foreground;
	private GameWorms g;

	private HashMap<String,Player> friendlyPlayers;

	public Client(GameWorms g, TiledMapTileLayer background, TiledMapTileLayer foreground, HashMap<String,Player> friendlyPlayers) throws Exception{
		connectSocket();
		this.friendlyPlayers = friendlyPlayers;
		this.g = g;
		this.background = background;
		this.foreground = foreground;
		
	}
	
	private void connectSocket() throws Exception{ //configuration du l'ip et du port
		socket = IO.socket("http://10.3.104.58:8080"); 
		socket.connect();
		//configSocketEvents();
	}
	
	public void configSocketEvents() { //Récuperation des evenements du serveur

		socket.on(Socket.EVENT_CONNECT, new Listener() {

			public void call(Object... arg0) {
				System.out.println("Socket IO Connected");
			

			}
		}).on("socketID", new Listener() { //à notre connexion au serveur

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
		}).on("newPlayer", new Listener() { //connexion d'un nouveau joueur

			public void call(Object... arg0) {
				JSONObject data = (JSONObject) arg0[0];
				try {
					String id = data.getString("id");
					System.out.println("nouveau joueur : " + id);
					friendlyPlayers.put(id, new Player(g, new Sprite(new Texture("sprites/Base pack/Player/p1_front.png")), background, foreground));
					

				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		}).on("playerDisconnected", new Listener() { //deconnexion d'un joueur autre que nous

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
		}).on("moved", new Listener() { // changement de position d'un autre joueur

			@Override
			public void call(Object... args) {
				JSONArray datas = (JSONArray)args[0];
				
				try {
					
					for(int i=0; i<datas.length();i++){
						String playerId = datas.getJSONObject(i).getString("id");
						System.out.println(playerId);
						double x = datas.getJSONObject(i).getDouble("x");
						double y = datas.getJSONObject(i).getDouble("y");
						System.out.println(playerId+" "+x+" "+y);
						if (friendlyPlayers.get(playerId) != null) {
							Player a = friendlyPlayers.get(playerId);
							a.setY((float) y);
							a.setX((float) x);
							System.out.println(a.toString());
							friendlyPlayers.put(playerId, a);
							//friendlyPlayers.get(playerId).setPosition(x, y);
							

						}
					}
					
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					
				}

			}
		}).on("getPlayers", new Listener() { //Liste des joueurs au début

			@Override
			public void call(Object... args) {
				JSONArray objects = (JSONArray) args[0];
				
				try {
					for (int i = 0; i < objects.length(); i++) {
						String id = objects.getJSONObject(i).getString("id");
						Player coopPlayer = new Player(g, new Sprite(new Texture("sprites/Base pack/Player/p1_front.png")), background, foreground);
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
	public void close(){ //fermerture de la socket
		this.socket.close();
	}
	
	public void emit(String event, Object...args){ //envoie de la socket
		this.socket.emit(event, args);
	
	}

}