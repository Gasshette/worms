package com.worms.entities;

public class Collision {
	private float x, y;
	private int width, height;
	
	public Collision(float x, float y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void move(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public float getX() {
		return this.x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return this.y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public boolean collidesWith (Collision rect) {
		return this.x < rect.x + rect.width && this.y < rect.y + rect.height && this.x + this.width > rect.x && this.y + this.height > rect.y;
	}
}
