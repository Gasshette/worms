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
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.worms.game.GameWorms;

public class GameOverView implements Screen {

	private final GameWorms game;

	private Skin skin;
	private Stage stage;
	private BitmapFont bfont;

	private Pixmap pixmap;

	private TextButtonStyle textButtonStyle;
	private LabelStyle labelStyle;

	private Label coinsResult;
	private Label gemsResult;
	private Label gameOver;
	private TextButton toMenuButton;

	public GameOverView(GameWorms game) {
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
		this.labelStyle = new LabelStyle(this.bfont, Color.WHITE);
		this.labelStyle.background = this.skin.newDrawable("pixmap", Color.BLUE);
		
		gameOver = new Label("", labelStyle);
		gameOver.setPosition(this.stage.getWidth() / 2 - (gameOver.getWidth() / 2 + 50), this.stage.getHeight() / 2 + 100);
		gameOver.setText("GAME OVER");
		this.stage.addActor(gameOver);

		coinsResult = new Label("", labelStyle);
		coinsResult.setWidth(400);
		coinsResult.setPosition(this.stage.getWidth() / 2 - coinsResult.getWidth() / 2,
				this.stage.getHeight() / 2 - 100);
		coinsResult.setText("Coins : {coins here}");
		this.stage.addActor(coinsResult);

		gemsResult = new Label("", labelStyle);
		gemsResult.setWidth(400);
		gemsResult.setPosition(this.stage.getWidth() / 2 - gemsResult.getWidth() / 2, this.stage.getHeight() / 2 - 150);
		gemsResult.setText("Gems : {gems here}");
		this.stage.addActor(gemsResult);

		/*
		 * Creation du bouton de retour
		 */
		this.toMenuButton = new TextButton("Back to main menu", textButtonStyle);
		this.toMenuButton.setHeight(30);
		this.toMenuButton.setWidth(300);
		this.toMenuButton.setPosition(this.stage.getWidth() / 2 - toMenuButton.getWidth() / 2,
				this.stage.getHeight() / 2 - 250);
		this.stage.addActor(toMenuButton);

		this.toMenuButton.addListener(new ChangeListener() {
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				GameOverView.this.game.setScreen(new MainMenuView(game));
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