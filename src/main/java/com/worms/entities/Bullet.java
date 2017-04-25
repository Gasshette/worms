package com.worms.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Bullet extends Sprite {
	private int speed = 1000;
	private Collision collision;

	public Bullet(Texture texture, float x, float y) {
		super(texture);
		this.setPosition(x, y);
		this.collision = new Collision(this.getX(), this.getY(), texture.getWidth(), texture.getHeight());
	}

	public void update(float deltaTime) {
		this.setPosition(this.getX() + this.speed * deltaTime, this.getY());
		this.collision.move(this.getX(), this.getY());
	}

	public void render(Batch batch) {
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	public Collision getCollision() {
		return this.collision;
	}
}
