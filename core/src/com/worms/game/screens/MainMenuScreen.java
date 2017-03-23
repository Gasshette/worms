package com.worms.game.screens;

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

	private GameWorms g;
	

	public MainMenuScreen(GameWorms g) {
		this.g = g;
		create();
	}

	public void create() {
		g.setSb(new SpriteBatch());
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		// A skin can be loaded via JSON or defined programmatically, either is
		// fine. Using a skin is optional but strongly
		// recommended solely for the convenience of getting a texture, region,
		// etc as a drawable, tinted drawable, etc.
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
		// textButtonStyle.checked = skin.newDrawable("white", Color.BLUE);
		textButtonStyle.over = skin.newDrawable("white", Color.LIGHT_GRAY);

		textButtonStyle.font = skin.getFont("default");

		skin.add("default", textButtonStyle);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter
		// can be used to specify a name other than "default".
		final TextButton playButton = new TextButton("PLAY", textButtonStyle);
		final TextButton connectButton = new TextButton("CONNECT", textButtonStyle);
		final TextButton quitButton = new TextButton("QUIT", textButtonStyle);

		playButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 350);
		connectButton.setPosition(this.stage.getWidth() / 2 - playButton.getWidth() / 2, 225);
		quitButton.setPosition(this.stage.getWidth() / 2 - quitButton.getWidth() / 2, 100);
		quitButton.setHeight(35);

		stage.addActor(playButton);
		stage.addActor(connectButton);
		stage.addActor(quitButton);

		playButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				g.setScreen(new PlayScreen(g));

			}
		});
		
		connectButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
				g.setScreen(new ConnectionScreen(g));

			}
		});
		
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