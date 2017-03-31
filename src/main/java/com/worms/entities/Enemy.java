package com.worms.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy extends Sprite {

	private int speed = 100;
	private float x, y;
	private boolean remove = false;
	private Texture texture;
	private Collision collision;

	public Enemy(Texture texture, float x, float y) {
		super(texture);

		this.texture = texture;
		this.x = x;
		this.y = y;
		
		this.collision = new Collision(this.x, this.y, 72, 36);
	}

	public void update(float deltaTime) {
		this.x -= this.speed * deltaTime;

//		if (this.x > Gdx.graphics.getWidth()) {
//			this.remove = true;
//		}	
		this.collision.move(this.x, this.y);
	}
	
	public Collision getCollision() {
		return this.collision;
	}

	public void setCollision(Collision collision) {
		this.collision = collision;
	}
	
	public void render(Batch batch) {
		batch.draw(this.texture, this.x, this.y);
	}

	public boolean getRemove() {
		return this.remove;
	}
	
}
