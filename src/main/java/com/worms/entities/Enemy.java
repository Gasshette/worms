package com.worms.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

public class Enemy extends Sprite {

	private float speed = 10;
	private String enemyToAdd;
	private boolean isAddEnemy = false;
	private Collision collision;
	
	public Enemy(Texture texture, float x, float y) {
		super(texture);
		this.setPosition(x, y);
		
		this.collision = new Collision(this.getX(), this.getY(), texture.getWidth(), texture.getHeight());
	}

	public void update(float deltaTime) {
		this.setPosition(this.getX() - this.speed * deltaTime, this.getY());
	}

	@Override
	public void draw(Batch batch) {
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	
	public Collision getCollision () {
		return this.collision;
	}
	
	public boolean isAddEnemy() {
		return this.isAddEnemy;
	}

	public void setAddEnemy(boolean isAddEnemy) {
		this.isAddEnemy = isAddEnemy;
	}

	public String getEnemyToAdd() {
		return this.enemyToAdd;
	}

	public void setEnemyToAdd(String enemyToAdd) {
		this.enemyToAdd = enemyToAdd;
	}
}
