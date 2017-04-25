package com.worms.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.worms.views.LoginView;

public class GameWorms extends Game {

	private SpriteBatch sb;
	private BitmapFont font;
	private String map;
	private FreeTypeFontGenerator generator;
	private String pseudo;

	@Override
	public void create() {
		this.generator = new FreeTypeFontGenerator(Gdx.files.internal("font1.ttf"));
		FreeTypeFontParameter parameter = new FreeTypeFontParameter();
		parameter.size = 45;
		
		this.sb = new SpriteBatch();
		this.font = new BitmapFont();
		this.map = "niv01.tmx";

		this.font = this.generator.generateFont(parameter);
		this.setScreen(new LoginView(this));

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
	
	public BitmapFont getFont() {
		return this.font;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
}