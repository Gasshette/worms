package com.worms.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.worms.game.GameWorms;

public class MainMenuScreen implements Screen {
	Skin skin;
	Stage stage;

	final GameWorms g;

	public MainMenuScreen(final GameWorms g) {
		this.g = g;
		create();
	}

	public void create() {

		/*
		 * Creates a new SpriteBatch
		 */
		SpriteBatch b = g.getSb();

		/*
		 * Creates a new stage, an object used to display graphic elements such
		 * as buttons and fields
		 */
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		/*
		 * A skin can be loaded via JSON or defined programmatically, Specify a
		 * specific set of buttons or colors Use default skins or
		 */
		skin = new Skin();

		// Generate a 1x1 white texture and store it in the skin named "white".
		Pixmap pixmap = new Pixmap(100, 100, Format.RGBA8888);
		pixmap.setColor(Color.RED);
		pixmap.fill();

		skin.add("white", new Texture(pixmap));

		// Store the default libgdx font under the name "default".
		BitmapFont bfont = new BitmapFont();
		skin.add("default", bfont);

		// Configure a TextButtonStyle and name it "default". Skin resources are
		// stored by type, so this doesn't overwrite the font.
		TextButtonStyle textButtonStyle = new TextButtonStyle();
		textButtonStyle.up = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.down = skin.newDrawable("white", Color.DARK_GRAY);
		textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);
		textButtonStyle.font = skin.getFont("default");
		skin.add("red", textButtonStyle);

		final TextButton playButton = new TextButton("PLAY", textButtonStyle);
		playButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 350);
		stage.addActor(playButton);
		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				g.setScreen(new PlayView(g));

			}
		});
		
		final TextButton connectButton = new TextButton("CONNECT", textButtonStyle);
		connectButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 225);
		stage.addActor(connectButton);
		connectButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				g.setScreen(new ConnectionScreen(g));

			}
		});

		final TextButton quitButton = new TextButton("QUIT", textButtonStyle);
		quitButton.setPosition(this.stage.getWidth() / 2 - quitButton.getWidth() / 2, 100);
		quitButton.setHeight(35);
		stage.addActor(quitButton);
		quitButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				Gdx.app.exit();
			}
		});

	}

	public void render(float delta) {
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
		stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void dispose() {
		stage.dispose();
		skin.dispose();
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
}