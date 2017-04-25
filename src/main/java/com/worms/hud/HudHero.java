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
import com.worms.entities.Player;

public class HudHero implements Disposable {

	// Scene2D.ui Stage and its own Viewport for HUD
	public Stage stage;
	private Viewport viewport;

	// Mario score/time Tracking Variables

	private float timeCount = 0;
	private int nbPiece;
	private int nbGermeBlue = 0;

	// Scene2D widgets
	private Label levelLabel;
	private Image joueur = new Image(new Texture("Base pack/HUD/hud_p1.png"));
	private Image piece = new Image(new Texture("Base pack/HUD/hud_coins.png"));
	private Image gemBlue = new Image(new Texture("Base pack/HUD/hud_gem_blue.png"));
	private Label nbGemBlue;
	private boolean isHalf = false;
	private Table tableVie = new Table();
	private Table table = new Table();
	private Table countPiece = new Table();
	private Table countGermBlue = new Table();
	private Image[] vies = new Image[5];
	private int indexVieMoins = 4;
	private Player player;
	private final float UPDATE_TIME = 1 / 60f;

	public HudHero(SpriteBatch sb) {
		// define our tracking variables
		this.timeCount = 0;
		this.nbPiece = 0;

		// setup the HUD viewport using a new camera seperate from our gamecam
		// define our stage using that viewport and our games spritebatch
		this.viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		this.stage = new Stage(this.viewport, sb);

		// define a table used to organize our hud's labels

		// Top-Align table
		this.table.top();
		// make the table fill the entire stage
		this.table.setFillParent(true);

		// define our labels using the String, and a Label style consisting of a
		// font and color
		this.nbGemBlue = new Label(String.format("%03d", this.nbGermeBlue), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		this.levelLabel = new Label(String.format("%03d", this.nbPiece), new Label.LabelStyle(new BitmapFont(), Color.WHITE));

		this.countPiece.add(this.piece);
		this.countPiece.add(this.levelLabel).expandX().padTop(10);

		this.countGermBlue.add(this.gemBlue);
		this.countGermBlue.add(this.nbGemBlue);
		for (int i = 0; i < 5; i++) {
			Image vie = new Image(new Texture("Base pack/HUD/hud_heartFull.png"));
			this.vies[i] = vie;
			vie = null;
		}

		// add our labels to our table, padding the top, and giving them all
		// equal width with expandX

		this.tableVie.add(this.vies);
		this.table.add(this.joueur).expandX().padTop(10);
		this.table.add(this.countPiece).expandX().padTop(10);

		// add a second row to our table
		this.table.row();
		this.table.add(this.tableVie).expandX();
		this.table.add(this.countGermBlue).expandX();

		// add our table to the stage
		this.stage.addActor(this.table);

	}

	public void update(float dt) {
		if (this.player.isTouch == true) {
			this.timeCount = this.timeCount + this.UPDATE_TIME;

			if (this.timeCount <= 1f) {
			} else {
				this.timeCount = 0;
				this.player.isTouch = false;
			}
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

	public void lifeMoins() {
		if (this.indexVieMoins > -1 && this.player.isTouch == false) {
			if (this.isHalf == false) {
				this.isHalf = true;
				Image demi = new Image(new Texture("Base pack/HUD/hud_heartHalf.png"));
				this.vies[this.indexVieMoins] = demi;
			} else {
				Image vide = new Image(new Texture("Base pack/HUD/hud_heartEmpty.png"));
				this.vies[this.indexVieMoins] = vide;
				this.isHalf = false;
				this.indexVieMoins--;

			}
			this.tableVie.clear();
			this.tableVie.add(this.vies);
			this.player.isTouch = true;
		}

	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public int nbVieRestant() {
		return this.indexVieMoins;
	}

	public int getGold() {
		return this.nbPiece;
	}

	public int getGeme() {
		return this.nbGermeBlue;
	}

}