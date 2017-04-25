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

public class HudMechant implements Disposable {

	private static Integer nbFlyfly = 15;
	private static Integer nbSlim = 10;
	private static Integer nbSpider = 5;
	private float count = 0;
	private Label flyFlyLabel;
	private Label slimeLabel;
	private Label spiderLabel;
	public Stage stage;
	private Image flyFlyImg = new Image(new Texture("Base pack/Enemies/flyFly1.png"));
	private Image slimImg = new Image(new Texture("Base pack/Enemies/slimeWalk1.png"));
	private Image spiderImg = new Image(new Texture("Extra animations and enemies/Enemy sprites/spider.png"));
	private Viewport viewport;

	public HudMechant(SpriteBatch sb) {
		this.viewport = new FitViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight(), new OrthographicCamera());
		this.stage = new Stage(this.viewport, sb);
		this.slimeLabel = new Label(String.format("%01d", nbSlim), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		this.flyFlyLabel = new Label(String.format("%01d", nbFlyfly), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		this.spiderLabel = new Label(String.format("%01d", nbSpider), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
		
		Table table = new Table();
		table.top();
		table.left();

		table.setFillParent(true);

		Table flyFly = new Table();
		flyFly.add(this.flyFlyImg);
		flyFly.add(this.flyFlyLabel);

		Table slim = new Table();
		slim.add(this.slimImg);
		slim.add(this.slimeLabel);

		Table spider = new Table();
		spider.add(this.spiderImg);
		spider.add(this.spiderLabel);

		table.add(flyFly);
		table.row();
		table.add(slim);
		table.row();
		table.add(spider);

		this.stage.addActor(table);

	}

	public void update(float dt) {
		this.count += dt;
		if (this.count > 1.5) {

		}
	}

	@Override
	public void dispose() {
		this.stage.dispose();

	}

	public boolean flyflyMoins() {
		if (nbFlyfly > 0) {
			nbFlyfly--;
			this.flyFlyLabel.setText(String.format("%01d", nbFlyfly));
			return true;
		}
		return false;
	}

	public boolean slimMoins() {
		if (nbSlim > 0) {
			nbSlim--;
			this.slimeLabel.setText(String.format("%01d", nbSlim));
			return true;
		}
		return false;
	}

	public boolean spiderMoins() {
		if (nbSpider > 0) {
			nbSpider--;
			this.spiderLabel.setText(String.format("%01d", nbSpider));
			return true;
		}
		return false;
	}
}
