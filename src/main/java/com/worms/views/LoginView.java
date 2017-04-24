package com.worms.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.worms.game.GameWorms;

public class LoginView implements Screen {

	private final GameWorms game;

	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;

	private TextButtonStyle textButtonStyle;
	private TextFieldStyle textFieldStyle;

	private TextField login;
	private TextField pwd;
	private TextButton exitButton;
	private TextButton connectButton;
	private TextButton playButton;

	public LoginView(GameWorms game) {
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
	}

	public void create() {
		/*
		 * Configuration du style d'un bouton
		 */
		this.textButtonStyle = new TextButtonStyle();
		this.textButtonStyle.up = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.down = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.checked = this.skin.newDrawable("pixmap", Color.BLUE);
		this.textButtonStyle.over = this.skin.newDrawable("pixmap", Color.LIGHT_GRAY);
		this.textButtonStyle.font = this.skin.getFont("default");
		this.skin.add("default", this.textButtonStyle);

		/*
		 * Configuration du style d'une zone de texte
		 */
		this.textFieldStyle = new TextFieldStyle(this.bfont, Color.BLACK, null, null, null);
		this.textFieldStyle.focusedBackground = this.skin.newDrawable("pixmap", Color.WHITE);
		this.textFieldStyle.messageFontColor = Color.BLACK;
		this.textFieldStyle.background = this.skin.newDrawable("pixmap", Color.WHITE);

		// LOGIN textfield
		this.login = new TextField("", textFieldStyle);
		this.login.setWidth(400);
		this.login.setPosition(this.stage.getWidth() / 2 - login.getWidth() / 2, 400);
		this.login.setMessageText("Username");
		this.stage.addActor(login);

		// PWD textfield
		this.pwd = new TextField("", textFieldStyle);
		this.pwd.setWidth(400);
		this.pwd.setPosition(this.stage.getWidth() / 2 - login.getWidth() / 2, 250);
		this.pwd.setMessageText("Password");
		this.stage.addActor(pwd);

		/*
		 * Creation du bouton de connexion
		 */
		this.connectButton = new TextButton("CONNECT", textButtonStyle);
		this.connectButton.setPosition(this.stage.getWidth() / 2 - connectButton.getWidth() / 2, 100);
		this.stage.addActor(connectButton);

		this.connectButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				LoginView.this.game.setScreen(new MainMenuView(game));
			}
		});
		
		/*
		 * temp btn to play game
		 */
		this.playButton = new TextButton("SOLO", textButtonStyle);
		this.playButton.setPosition(this.stage.getWidth() - playButton.getWidth() - 50, 50);
		this.stage.addActor(playButton);

		this.playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				LoginView.this.game.setScreen(new LobbyView(LoginView.this.game));
			}
		});
		/*
		 * Creation du bouton de retour
		 */
		this.exitButton = new TextButton("BACK", textButtonStyle);
		this.exitButton.setPosition(50, 50);
		this.exitButton.setHeight(35);
		this.stage.addActor(exitButton);

		this.exitButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		this.stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		this.stage.draw();
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