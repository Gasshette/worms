package com.worms.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
	/** The movement velocity */
	private Vector2 velocity = new Vector2();
<<<<<<< HEAD
	private float speed = 500, gravity = 400;
=======
	private float speed = 400, gravity = 400;
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9

	// Layers of the map
	private TiledMapTileLayer background;
	private TiledMapTileLayer foreground;
	
	private boolean canJump;
<<<<<<< HEAD
=======
	private boolean shoot = false;
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
	
	public Player(Texture texture, TiledMapTileLayer background, TiledMapTileLayer foreground) {
		super(texture);
		this.background = background;
		this.foreground = foreground;
	}
	
	public void update(float delta) {
		float oldX = this.getX(), oldY = this.getY();
		boolean collisionRight = false, collisionLeft = false, collisionTop = false, collisionBottom = false;
		boolean finish = false;
		
		// Gravite
		this.velocity.y -= this.gravity * delta;

		if (this.velocity.y > this.speed) {
			this.velocity.y = this.speed;
		} else if (this.velocity.y < -this.speed) {
			this.velocity.y = -this.speed;
		}

		/**
		 * GESTION DES MOUVEMENTS 
		 * Modification de la position 
		 * Check si collision
		 * Recuperation du type de collision + traitement
		 */
		// X
		this.setX(this.getX() + this.velocity.x * delta);

		if (this.velocity.x < 0) { // LEFT
			collisionLeft = this.collidesLeft(this.background, "blocked") || this.collidesLeft(this.foreground, "blocked");
		}
		else if (this.velocity.x > 0) { // RIGHT
			collisionRight = this.collidesRight(this.background, "blocked") || this.collidesRight(this.foreground, "blocked");
		}
		

		if (collisionRight || collisionLeft) {
			this.setX(oldX);
			this.velocity.x = 0;
		}
		
		// Y
		this.setY(this.getY() + this.velocity.y * delta);
		
		if (this.velocity.y < 0) { // DOWN
			collisionBottom = this.collidesBottom(this.background, "blocked") || this.collidesBottom(this.foreground, "blocked");
			this.canJump = collisionBottom;
		}
		else if (this.velocity.y > 0) { // UP
			collisionTop = this.collidesTop(this.background, "blocked") || this.collidesTop(this.foreground, "blocked");
		}

		if (collisionTop || collisionBottom) {
			this.setY(oldY);
			this.velocity.y = 0;
		}
		
		Cell currentCell = this.getCell(this.foreground);
		if(currentCell != null && currentCell.getTile() != null) {
			if(currentCell.getTile().getProperties().containsKey("collectible")) {
				currentCell.setTile(null);
			}
		}
<<<<<<< HEAD
		
=======
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
	}

	private boolean isCell(TiledMapTileLayer layer, float x, float y, String property) {
		Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(property);
	}
	
	private Cell getCell(TiledMapTileLayer layer) {
		return layer.getCell((int) (this.getX() / layer.getTileWidth()), (int) (this.getY() / this.background.getTileHeight()));
	}

	public boolean collidesRight(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < this.getHeight(); step += layer.getTileHeight() / 2) {
			if (this.isCell(layer, this.getX() + this.getWidth(), this.getY() + step, property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesLeft(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < this.getHeight(); step += layer.getTileHeight() / 2) {
			if (this.isCell(layer, this.getX(), this.getY() + step, property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesTop(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < this.getWidth(); step += layer.getTileWidth() / 2) {
			if (this.isCell(layer, this.getX() + step, this.getY() + this.getHeight(), property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesBottom(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < this.getWidth(); step += layer.getTileWidth() / 2) {
			if (this.isCell(layer, this.getX() + step, this.getY(), property)) {
				return true;
			}
		}
		
		return false;
	}
	
	@Override
	public void draw(Batch batch) {
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	public Vector2 getVelocity() {
		return this.velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return this.speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return this.gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public TiledMapTileLayer getCollisionLayer() {
		return this.background;
	}

	public void setCollisionLayer(TiledMapTileLayer background) {
		this.background = background;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.Z:
			if (this.canJump) {
				this.velocity.y = this.speed;
				this.canJump = false;
			}
			break;
		case Keys.Q:
			this.velocity.x = -this.speed;
			break;
		case Keys.D:
			this.velocity.x = this.speed;
			break;
<<<<<<< HEAD
=======
		case Keys.ENTER:
			this.shoot = true;
			break;
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch (keycode) {
		case Keys.Q:
		case Keys.D:
			this.velocity.x = 0;
			break;
<<<<<<< HEAD
=======
		case Keys.ENTER:
			this.shoot = false;
			break;
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
		}

		return true;
	}

<<<<<<< HEAD
=======
	public boolean isShoot() {
		return this.shoot;
	}

	public void setShoot(boolean shoot) {
		this.shoot = shoot;
	}

>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
<<<<<<< HEAD
	
	
=======
>>>>>>> 31c95da1709e317d069fe0b2073d947c1831f4c9
}
