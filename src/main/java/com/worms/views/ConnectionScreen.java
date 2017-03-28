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
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.worms.game.GameWorms;

public class ConnectionScreen implements Screen {
	Skin skin;
	Stage stage;

	final GameWorms g;

	public ConnectionScreen(final GameWorms g) {
		this.g = g;
		create();
	}

	public void create() {
		SpriteBatch b = g.getSb();
		
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);

		// A skin can be loaded via JSON or defined programmatically, either is
		// fine. Using a skin is optional but strongly
		// recommended solely for the convenience of getting a texture, region,
		// etc as a drawable, tinted drawable, etc.

		//TODO 
		//TextureAtlas atlas = new TextureAtlas("kenney-atlas/skin/ui-orange.atlas");
		
		
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
		skin.add("default", textButtonStyle);

		TextFieldStyle textFieldStyle = new TextFieldStyle(bfont, Color.BLUE, null, null, null);
		
		//URL textfield
		final TextField url = new TextField("",textFieldStyle);
		url.setWidth(300);
		url.setPosition(this.stage.getWidth() / 2 - url.getWidth(), 400);
		stage.addActor(url);

		// Create a button with the "default" TextButtonStyle. A 3rd parameter
		// can be used to specify a name other than "default".
		
		//Connect button
		final TextButton connectButton = new TextButton("CONNECT", textButtonStyle);
		connectButton.setPosition(this.stage.getWidth() / 2 - connectButton.getWidth() / 2, 100);
		stage.addActor(connectButton);
		connectButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
			}
		});
		
		//Back button
		final TextButton backButton = new TextButton("BACK", textButtonStyle);
		backButton.setPosition(50, 50);
		backButton.setHeight(35);
		stage.addActor(backButton);
		backButton.addListener(new ChangeListener() {
			public void changed(ChangeEvent event, Actor actor) {
			g.setScreen(new MainMenuScreen(g));
			}
		});
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 1, 1, 1);
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