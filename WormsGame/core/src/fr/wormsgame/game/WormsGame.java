package fr.wormsgame.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.Input;

import fr.wormsgame.game.objects.BaseMonster;

public class WormsGame extends ApplicationAdapter {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private BaseMonster baseMonster;
	private Sprite sprite;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 800, 600);
		
		batch = new SpriteBatch();
		
		baseMonster = new BaseMonster();
		baseMonster.setPosition(400.0f, 100.0f);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 1, 1, 1);				//make the BG white
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined);
		batch.begin();
		baseMonster.draw(batch);
		batch.end();
		
		//Updates
		baseMonster.update(Gdx.graphics.getDeltaTime());
		Rectangle temp = new Rectangle(0, 0, 800, 10);
		if(baseMonster.hits(temp) != -1){
			baseMonster.action(1, 0.0f, 10.0f);
		}
		
		
		//Controls
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			baseMonster.moveLeft(Gdx.graphics.getDeltaTime());
		}
		
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			baseMonster.moveRight(Gdx.graphics.getDeltaTime());
		}
		
		if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
			baseMonster.jump();
		}
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
