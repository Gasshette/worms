package com.worms.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.worms.views.MainMenuView;

public class GameWorms extends Game {

	private SpriteBatch sb;
	private BitmapFont font;
	private String map;

	@Override
	public void create() {
		this.sb = new SpriteBatch();
		this.font = new BitmapFont();
		this.map = "carte.tmx";
		this.setScreen(new MainMenuView(this));
	}

	@Override
	public void dispose() {
		super.dispose();

		this.sb.dispose();
		this.font.dispose();
	}

	public String getMap() {
		return this.map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public SpriteBatch getSb() {
		return this.sb;
	}
}