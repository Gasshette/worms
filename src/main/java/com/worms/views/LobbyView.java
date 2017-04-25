package com.worms.views;

import java.util.HashMap;
import java.util.Map.Entry;

import org.json.JSONException;
import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.worms.game.GameWorms;
import com.worms.network.Client;

public class LobbyView implements Screen {

	private final GameWorms game;

	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;

	private TextButtonStyle textButtonStyle;

	private TextButton backButton;
	private TextButton readyButton;

	private LabelStyle labelStyle;
	private Label p1Pseudo;
	private Label p2Pseudo;
	private Label p3Pseudo;
	private Label p4Pseudo;
	private TextureRegionDrawable alien1Draw;
	private TextureRegionDrawable alien2Draw;
	private TextureRegionDrawable alien3Draw;
	private HashMap<Integer, Label> dispPlayers;
	private HashMap<Integer, Label> dispPseudos;


	private Texture alien1Tex;
	private Texture alien2Tex;
	private Texture alien3Tex;
	private Texture leftArrowTex;
	private ImageButton leftArrow;
	private Texture rightArrowTex;
	private ImageButton rightArrow;
	private static int choice = 0;
	private boolean isReady = false;

	private Client client = null;

	private static HashMap<Integer, TextureRegionDrawable> charSelect;
	private HashMap<String, JSONObject> lobbyPlayers;


	private static Image selection;

	public LobbyView(GameWorms game) {
		this.game = game;
		this.stage = new Stage();
		this.skin = new Skin();
		this.bfont = game.getFont();

		this.pixmap = new Pixmap(100, 100, Format.RGBA8888);
		this.pixmap.setColor(Color.WHITE);
		this.pixmap.fill();

		this.skin.add("pixmap", new Texture(this.pixmap));
		this.skin.add("default", this.bfont);

		Gdx.input.setInputProcessor(this.stage);

		this.create();
		this.lobbyPlayers = new HashMap<String, JSONObject>();
		try {
			this.client = new Client(lobbyPlayers);
			this.client.configSocketEvents();

			JSONObject player = new JSONObject();
			try {
				player.put("pseudo", game.getPseudo());

			} catch (JSONException e) {
				e.printStackTrace();
			}

			this.client.emit("newPlayer", player);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void create() {

		this.labelStyle = new LabelStyle(this.bfont, Color.BLACK);
		this.labelStyle.background = this.skin.newDrawable("pixmap", Color.WHITE);

		p1Pseudo = new Label("empty", labelStyle);
		p1Pseudo.setPosition(this.stage.getWidth() * 0.125F - (p1Pseudo.getWidth() / 2), 350);
		this.stage.addActor(p1Pseudo);

		p2Pseudo = new Label("empty", labelStyle);
		p2Pseudo.setPosition(this.stage.getWidth() * 0.375F - (p2Pseudo.getWidth() / 2), 350);
		this.stage.addActor(p2Pseudo);

		p3Pseudo = new Label("empty", labelStyle);
		p3Pseudo.setPosition(this.stage.getWidth() * 0.625F - (p3Pseudo.getWidth() / 2), 350);
		this.stage.addActor(p3Pseudo);

		p4Pseudo = new Label("empty", labelStyle);
		p4Pseudo.setPosition(this.stage.getWidth() * 0.875F - (p4Pseudo.getWidth() / 2), 350);
		this.stage.addActor(p4Pseudo);

		this.dispPseudos = new HashMap<>();
		this.dispPseudos.put(1, p1Pseudo);
		this.dispPseudos.put(2, p2Pseudo);
		this.dispPseudos.put(3, p3Pseudo);
		this.dispPseudos.put(4, p4Pseudo);

		this.textButtonStyle = new TextButtonStyle();
		this.textButtonStyle.up = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.down = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.checked = this.skin.newDrawable("pixmap", Color.BLUE);
		this.textButtonStyle.over = this.skin.newDrawable("pixmap", Color.LIGHT_GRAY);
		this.textButtonStyle.font = this.skin.getFont("default");
		this.skin.add("default", this.textButtonStyle);

		alien1Tex = new Texture(Gdx.files.internal("Base pack/Player/p1_hurt.png"));
		alien2Tex = new Texture(Gdx.files.internal("Base pack/Player/p2_stand.png"));
		alien3Tex = new Texture(Gdx.files.internal("Base pack/Player/p3_jump.png"));
		leftArrowTex = new Texture(Gdx.files.internal("Base pack/HUD/left-off.png"));
		rightArrowTex = new Texture(Gdx.files.internal("Base pack/HUD/right-off.png"));
		this.alien1Draw = new TextureRegionDrawable(new TextureRegion(alien1Tex));
		this.alien2Draw = new TextureRegionDrawable(new TextureRegion(alien2Tex));
		this.alien3Draw = new TextureRegionDrawable(new TextureRegion(alien3Tex));
		TextureRegionDrawable leftArrowDraw = new TextureRegionDrawable(new TextureRegion(leftArrowTex));
		TextureRegionDrawable rightArrowDraw = new TextureRegionDrawable(new TextureRegion(rightArrowTex));

		selection = new Image(alien1Draw);
		selection.setPosition(this.stage.getWidth() / 2 - selection.getWidth() / 2, 600);

		this.leftArrow = new ImageButton(leftArrowDraw);
		this.leftArrow.setPosition(selection.getX() - this.leftArrow.getWidth(), 600);
		this.rightArrow = new ImageButton(rightArrowDraw);
		this.rightArrow.setPosition(selection.getX() + this.rightArrow.getWidth(), 600);

		charSelect = new HashMap<>();
		charSelect.put(0, alien1Draw);
		charSelect.put(1, alien2Draw);
		charSelect.put(2, alien3Draw);

		System.out.println(charSelect);
		this.stage.addActor(selection);
		this.stage.addActor(this.leftArrow);
		this.stage.addActor(this.rightArrow);

		/*
		 * left arrow
		 */

		this.leftArrow.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("perso " + choice);
				LobbyView.switchChar(true);
			}
		});

		/*
		 * right arrow
		 */
		this.rightArrow.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println("perso " + choice);
				LobbyView.switchChar(false);
			}
		});
		/*
		 * Creation du bouton READY
		 */
		this.readyButton = new TextButton("READY", this.textButtonStyle);
		this.readyButton.setPosition(this.stage.getWidth() / 2 - this.readyButton.getWidth() / 2, 100);
		this.stage.addActor(this.readyButton);

		this.readyButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {

				LobbyView.this.isReady = !LobbyView.this.isReady;

				LobbyView.this.client.emit("updateReady", LobbyView.this.isReady);
//				boolean isMechant = false;
//				if(isMechant) {
//					LobbyView.this.game.setScreen(new MechantView(LobbyView.this.game));
//				} else {
//					LobbyView.this.game.setScreen(new PlayView(LobbyView.this.game));
//				}
			}
		});

		/*
		 * Creation du bouton de retour
		 */
		this.backButton = new TextButton("BACK", this.textButtonStyle);
		this.backButton.setPosition(50, 50);
		this.backButton.setHeight(35);
		this.stage.addActor(this.backButton);

		this.backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				LobbyView.this.game.setScreen(new LoginView(LobbyView.this.game));
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		this.stage.draw();
		Integer index = 1;
		for (Entry<String, JSONObject> entry : this.lobbyPlayers.entrySet()) {
			try {
				System.out.println(index);
				this.dispPseudos.get(index).setText(entry.getValue().getString("pseudo"));
			} catch (JSONException e) {
				e.printStackTrace();
			}
			;
			index++;
		}
	}

	public static void switchChar(boolean left) {
		if (!left) {
			if (charSelect.size() > choice + 1) {
				choice++;
			} else {
				choice = 0;
			}
		} else {
			choice--;
			if (choice < 0) {
				choice = 2;
			}
		}
		selection.setDrawable(charSelect.get(choice));

	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void show() {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		this.stage.dispose();
		this.skin.dispose();
	}
}