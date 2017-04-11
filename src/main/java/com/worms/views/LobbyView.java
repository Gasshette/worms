package com.worms.views;

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
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton.ImageButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.worms.game.GameWorms;

public class LobbyView implements Screen {

	@SuppressWarnings("unused")
	private final GameWorms game;

	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;
	private Pixmap pixmap;

	private TextButtonStyle textButtonStyle;
	private ImageButtonStyle imageButtonStyle;
	private ImageButton typeA;
	private ImageButton typeB;
	private ImageButton typeC;
	private ButtonGroup<ImageButton> radio;

	private TextButton backButton;
	private TextButton readyButton;

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
	}

	public void create() {

		this.imageButtonStyle = new ImageButtonStyle();
		this.imageButtonStyle.up = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.imageButtonStyle.down = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.imageButtonStyle.checked = this.skin.newDrawable("pixmap", Color.BLUE);
		this.imageButtonStyle.over = this.skin.newDrawable("pixmap", Color.LIGHT_GRAY);
		this.skin.add("default", this.imageButtonStyle);

		this.textButtonStyle = new TextButtonStyle();
		this.textButtonStyle.up = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.down = this.skin.newDrawable("pixmap", Color.DARK_GRAY);
		this.textButtonStyle.checked = this.skin.newDrawable("pixmap", Color.BLUE);
		this.textButtonStyle.over = this.skin.newDrawable("pixmap", Color.LIGHT_GRAY);
		this.textButtonStyle.font = this.skin.getFont("default");
		this.skin.add("default", this.textButtonStyle);

		Texture textureCharSelect;
		TextureRegionDrawable myTexRegionDrawable;
		/*
		 * character 1
		 */
		textureCharSelect = new Texture(Gdx.files.internal("Base pack/Player/p1_hurt.png"));
		myTexRegionDrawable = new TextureRegionDrawable(new TextureRegion(textureCharSelect));
		this.typeA = new ImageButton(myTexRegionDrawable);
		this.typeA.setStyle(imageButtonStyle);
		this.typeA.setPosition(200, 200);
		this.stage.addActor(typeA);

		/*
		 * character 2
		 */
		textureCharSelect = new Texture(Gdx.files.internal("Base pack/Player/p2_duck.png"));
		myTexRegionDrawable = new TextureRegionDrawable(new TextureRegion(textureCharSelect));
		this.typeB = new ImageButton(myTexRegionDrawable);
		this.typeB.setStyle(imageButtonStyle);
		this.typeB.setPosition(300, 200);
		this.stage.addActor(typeB);

		/*
		 * character 3
		 */
		textureCharSelect = new Texture(Gdx.files.internal("Base pack/Player/p3_jump.png"));
		myTexRegionDrawable = new TextureRegionDrawable(new TextureRegion(textureCharSelect));
		this.typeC = new ImageButton(myTexRegionDrawable);
		this.typeC.setStyle(imageButtonStyle);
		this.typeC.setPosition(400, 200);
		this.stage.addActor(typeC);

		/*
		 * Configuration du style d'un bouton
		 */
		this.radio = new ButtonGroup<>();
		radio.add(typeA);
		radio.add(typeB);
		radio.add(typeC);

		/*
		 * Creation du bouton READY
		 */
		this.readyButton = new TextButton("READY", textButtonStyle);
		this.readyButton.setPosition(this.stage.getWidth() / 2 - readyButton.getWidth() / 2, 100);
		this.stage.addActor(readyButton);

		this.readyButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				System.out.println();
			}
		});

		/*
		 * Creation du bouton de retour
		 */
		this.backButton = new TextButton("BACK", textButtonStyle);
		this.backButton.setPosition(50, 50);
		this.backButton.setHeight(35);
		this.stage.addActor(backButton);

		this.backButton.addListener(new ChangeListener() {
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