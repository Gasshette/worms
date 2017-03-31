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

	public LoginView(GameWorms game) {
		this.game = game;
		this.stage = new Stage();
		this.skin = new Skin();
		this.bfont = new BitmapFont();

		this.pixmap = new Pixmap(100, 100, Format.RGBA8888);
		this.pixmap.setColor(Color.RED);
		this.pixmap.fill();

		this.skin.add("white", new Texture(this.pixmap));
		this.skin.add("default", this.bfont);

		Gdx.input.setInputProcessor(this.stage);

		this.create();
	}

	public void create() {
		/**
		 * Configuration du style d'un bouton
		 */
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = this.skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = this.skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = this.skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = this.skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = this.skin.getFont("default");
		this.skin.add("default", textButtonStyle);

		/**
		 * Configuration du style d'une zone de texte
		 */
		TextFieldStyle textFieldStyle = new TextFieldStyle(this.bfont, Color.BLUE, null, null, null);

		// URL textfield
		final TextField url = new TextField("TEXTE NIMPORTE QUOI", textFieldStyle);
		url.setWidth(300);
		url.setPosition(this.stage.getWidth() / 2 - url.getWidth(), 400);
		this.stage.addActor(url);

		/**
		 * Creation du bouton de connexion
		 */
		final TextButton connectButton = new TextButton("CONNECT", textButtonStyle);
		connectButton.setPosition(this.stage.getWidth() / 2 - connectButton.getWidth() / 2, 100);
		this.stage.addActor(connectButton);

		connectButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
			}
		});

		/**
		 * Creation du bouton de retour
		 */
		final TextButton backButton = new TextButton("BACK", textButtonStyle);
		backButton.setPosition(50, 50);
		backButton.setHeight(35);
		this.stage.addActor(backButton);

		backButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				LoginView.this.game.setScreen(new MainMenuView(LoginView.this.game));
			}
		});
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
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