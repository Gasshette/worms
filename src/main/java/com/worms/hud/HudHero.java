package com.worms.hud;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class HudHero implements Disposable {

	// Scene2D.ui Stage and its own Viewport for HUD
	public Stage stage;
	private Viewport viewport;

	// Mario score/time Tracking Variables
	private Integer worldTimer;
	private boolean timeUp; // true when the world timer reaches 0
	private float timeCount;
	private static Integer score;
	private static Integer nbPiece;
	private static Integer nbGermeBlue = 0;

	// Scene2D widgets
	private Label countdownLabel;
	private static Label scoreLabel;
	private Label timeLabel;
	private Label levelLabel;

	private Image joueur = new Image(new Texture("Base pack/HUD/hud_p1.png"));
	private Image piece = new Image(new Texture("Base pack/HUD/hud_coins.png"));
	private Image gemBlue = new Image(new Texture("Base pack/HUD/hud_gem_blue.png"));
	private Label nbGemBlue;

	private Image[] vies = new Image[5];

	public HudHero(SpriteBatch sb) {
		// define our tracking variables
		worldTimer = 0;
		timeCount = 0;
		score = 5;
		nbPiece = 0;

		// setup the HUD viewport using a new camera seperate from our gamecam
		// define our stage using that viewport and our games spritebatch
		viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		stage = new Stage(viewport, sb);

		// define a table used to organize our hud's labels
		Table table = new Table();
		Table tableVie = new Table();
		Table countPiece = new Table();
		Table countGermBlue = new Table();
		// Top-Align table
		table.top();
		// make the table fill the entire stage
		table.setFillParent(true);

		// define our labels using the String, and a Label style consisting of a
		// font and color
		nbGemBlue = new Label(String.format("%03d", nbGermeBlue), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		scoreLabel = new Label(String.format("%01d", score), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		timeLabel = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		levelLabel = new Label(String.format("%03d", nbPiece), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

		countPiece.add(piece);
		countPiece.add(levelLabel).expandX().padTop(10);

		countGermBlue.add(gemBlue);
		countGermBlue.add(nbGemBlue);
		for (int i = 0; i < 5; i++) {
			Image vie = new Image(new Texture("Base pack/HUD/hud_heartFull.png"));
			vies[i] = vie;
			vie = null;
		}

		// add our labels to our table, padding the top, and giving them all
		// equal width with expandX

		tableVie.add(vies);
		table.add(joueur).expandX().padTop(10);
		table.add(countPiece).expandX().padTop(10);

		// add a second row to our table
		table.row();
		table.add(tableVie).expandX();
		table.add(countGermBlue).expandX();

		// add our table to the stage
		stage.addActor(table);

	}

	public void update(float dt) {
		timeCount += dt;
		if (timeCount >= 1) {
			if (worldTimer > 0) {
				worldTimer--;
			} else {
				timeUp = true;
			}
			nbGermeBlue++;
			nbGemBlue.setText(String.format("%03d", nbGermeBlue));
			timeCount = 0;
		}
	}

	public static void addScore(int value) {
		score += value;
		scoreLabel.setText(String.format("%06d", score));
	}

	@Override
	public void dispose() {
		stage.dispose();
	}



}
