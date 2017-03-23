package com.worms.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.worms.game.network.Client;
import com.worms.game.screens.MainMenuScreen;

public class GameWorms extends Game {
	
	private SpriteBatch sb;
	BitmapFont font;
	
	@Override
	public void create() {
		setSb(new SpriteBatch());
		font = new BitmapFont();
	
		this.setScreen(new MainMenuScreen(this));
	}
	
	@Override
	public void dispose() {
		super.dispose();
		getSb().dispose();
		font.dispose();
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
		return sb;
	}

	public void setSb(SpriteBatch sb) {
		this.sb = sb;
	}

}