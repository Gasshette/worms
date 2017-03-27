package com.worms.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.worms.views.PlayView;

public class GameWorms extends Game {

	private SpriteBatch sb;
	private BitmapFont font;

	@Override
	public void create() {
		this.sb = new SpriteBatch();
		this.font = new BitmapFont();
		this.setScreen(new PlayView(this));
	}

	@Override
	public void dispose() {
		super.dispose();

		this.sb.dispose();
		this.font.dispose();
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
}