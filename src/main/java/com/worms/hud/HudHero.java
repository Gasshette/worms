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
	private boolean timeUp;
	private float timeCount;
	private int nbPiece;
	private int nbGermeBlue = 0;

	// Scene2D widgets
	private Label levelLabel;

	private Image joueur = new Image(new Texture("Base pack/HUD/hud_p1.png"));
	private Image piece = new Image(new Texture("Base pack/HUD/hud_coins.png"));
	private Image gemBlue = new Image(new Texture("Base pack/HUD/hud_gem_blue.png"));
	private Label nbGemBlue;

	private Image[] vies = new Image[5];

	public HudHero(SpriteBatch sb) {
		// define our tracking variables
		this.worldTimer = 0;
		this.timeCount = 0;
		this.nbPiece = 0;

		// setup the HUD viewport using a new camera seperate from our gamecam
		// define our stage using that viewport and our games spritebatch
		this.viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		this.stage = new Stage(this.viewport, sb);

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
		this.nbGemBlue = new Label(String.format("%03d", this.nbGermeBlue), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		this.levelLabel = new Label(String.format("%03d", this.nbPiece), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

		countPiece.add(this.piece);
		countPiece.add(this.levelLabel).expandX().padTop(10);

		countGermBlue.add(this.gemBlue);
		countGermBlue.add(this.nbGemBlue);
		for (int i = 0; i < 5; i++) {
			Image vie = new Image(new Texture("Base pack/HUD/hud_heartFull.png"));
			this.vies[i] = vie;
			vie = null;
		}

		// add our labels to our table, padding the top, and giving them all
		// equal width with expandX

		tableVie.add(this.vies);
		table.add(this.joueur).expandX().padTop(10);
		table.add(countPiece).expandX().padTop(10);

		// add a second row to our table
		table.row();
		table.add(tableVie).expandX();
		table.add(countGermBlue).expandX();

		// add our table to the stage
		this.stage.addActor(table);

	}

	public void update(float dt) {
		this.timeCount += dt;
		if (this.timeCount >= 1) {
			if (this.worldTimer > 0) {
				this.worldTimer--;
			} else {
				this.timeUp = true;
			}
			this.nbGermeBlue++;
			this.nbGemBlue.setText(String.format("%03d", this.nbGermeBlue));
			this.timeCount = 0;
		}
	}

	@Override
	public void dispose() {
		this.stage.dispose();
	}

	public void setGold(int gold) {
		this.nbPiece++;
		this.levelLabel.setText(String.format("%03d", this.nbPiece));
	}

	public void setGerm(int germ) {
		this.nbGermeBlue++;
		this.nbGemBlue.setText(String.format("%03d", this.nbGermeBlue));
	}

}
