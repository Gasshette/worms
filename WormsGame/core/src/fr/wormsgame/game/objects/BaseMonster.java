package fr.wormsgame.game.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class BaseMonster {
	Rectangle bottom, left, top, right;
	Sprite sprite;
	Texture texture;
	int action;
	float velocityY;
	
	public BaseMonster(){
		super();
		
		bottom = new Rectangle(0f, 0f, 128f, 128f);
		texture = new Texture(Gdx.files.internal("badlogic.jpg"));
		sprite = new Sprite(texture, 0, 0, 128, 128);
		this.setPosition(0, 0);
		
		velocityY = 0;
		
		
	}
	
	public int hits(Rectangle r){
		if(bottom.overlaps(r)){
			return 1;
		}
		return -1;
	}
	
	//collision action
	public void action(int type, float x, float y){
		if(type == 1){
			setPosition(bottom.x, y);
			System.out.println("bottom.x = " + bottom.x);
			
		}
	}
	
	public void update( float delta){
		velocityY -= 10 * delta;					//make it fall forever
		bottom.y += velocityY;
		sprite.setPosition(bottom.x, bottom.y);
	}
	
	//set the position of the sprite
	public void setPosition(float x, float y){
		bottom.x = x;
		bottom.y = y;
		sprite.setPosition(x, y);
	}
	
	public void moveLeft(float delta){
		bottom.x -= 100 * delta;
		sprite.setPosition(bottom.x, bottom.y);
	}
	
	public void moveRight(float delta){
		bottom.x += 100 * delta;
		sprite.setPosition(bottom.x, bottom.y);
	}
	
	public void draw(SpriteBatch  batch){
		sprite.draw(batch);
	}
	
	public void jump(){
		velocityY = 10;
	}
}
