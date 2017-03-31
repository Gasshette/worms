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
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.worms.game.GameWorms;

public class MainMenuView implements Screen {
	private final GameWorms game;
	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;

	public MainMenuView(GameWorms game) {
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
		this.skin.add("red", textButtonStyle);

		/**
		 * Creation du bouton play
		 */
		final TextButton playButton = new TextButton("PLAY", textButtonStyle);
		playButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 350);
		this.stage.addActor(playButton);
		playButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				MainMenuView.this.game.setScreen(new PlayView(MainMenuView.this.game));
			}
		});

		/**
		 * Creation du bouton connexion
		 */
		final TextButton connectButton = new TextButton("CONNECT", textButtonStyle);
		connectButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 225);
		this.stage.addActor(connectButton);
		connectButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				MainMenuView.this.game.setScreen(new LoginView(MainMenuView.this.game));
			}
		});

		/**
		 * Creation du bouton quitter
		 */
		final TextButton quitButton = new TextButton("QUIT", textButtonStyle);
		quitButton.setPosition(this.stage.getWidth() / 2 - quitButton.getWidth() / 2, 100);
		quitButton.setHeight(35);
		this.stage.addActor(quitButton);
		quitButton.addListener(new ChangeListener() {
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