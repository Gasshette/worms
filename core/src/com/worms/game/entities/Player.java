package com.worms.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;

public class Player extends Sprite implements InputProcessor {
	
	/** The movement velocity */
	private Vector2 velocity = new Vector2();
	
	private float speed = 300 * 2, gravity = 600 * 1.0f;
	
	private TiledMapTileLayer collisionLayer;
	
	private boolean canJump;
	
	public Player(Sprite sprite, TiledMapTileLayer collisionLayer) {
		super(sprite);
		this.collisionLayer = collisionLayer;
	}
	
	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	
//	public void update(float delta) {
//		// Applique la gravite
//		this.velocity.y -= gravity * delta;
//		
//		// Clamp velocity
//		if(this.velocity.y > speed) {
//			this.velocity.y = speed;
//		} else if(this.velocity.y < -speed) {
//			this.velocity.y = -speed;
//		}
//		
//		// On sauvegarde les old positions en cas de colisions
//		float oldX = getX(), oldY = getY(), tileWidth = this.collisionLayer.getTileWidth(), tileHeight = this.collisionLayer.getTileHeight();
//		boolean collisionX = false, collisionY = false, finish = false;
//		
//		// move on x
//		setX(getX() + this.velocity.x * delta);
//		
//		if(this.velocity.x < 0) {
//			// top left			
//			collisionX = this.collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() / getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//			
//			// middle left
//			if(!collisionX) {
//				collisionX = this.collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//			// bottom left
//			if(!collisionX) {
//				collisionX = this.collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY()  / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//
//		} else if(this.velocity.x > 0) {
//			// top right
//			collisionX = this.collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//
//			// middle right
//			if(!collisionX) {
//				collisionX = this.collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) ((getY() + getWidth() / 2) / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//			// bottom right
//			if(!collisionX) {
//				collisionX = this.collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//		}
//		
//		/**
//		 * En cas de collision
//		 * On remet le personnage à sa place initiale
//		 * On remet sa vitesse a 0
//		 */
//		if(collisionX) {
//			setX(oldX);
//			this.velocity.x = 0;
//		}
//		
//		
//		// move on y
//		setY(getY() + this.velocity.y * delta);
//		
//
//		if(this.velocity.y < 0) { // going down
//			// bottom left			
//			collisionY = this.collisionLayer.getCell((int) (getX() / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//			
//			//bottom middle
//			if(!collisionY) {
//				collisionY = this.collisionLayer.getCell((int) ((getX() + getWidth() / 2) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//			// bottom right
//			if(!collisionY) {
//				collisionY = this.collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) (getY() / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//			this.canJump = collisionY;
//		} else if(this.velocity.y > 0) { // going up
//			// top left
//			collisionY = this.collisionLayer.getCell((int) (getX() / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//
//			// top middle
//			if(!collisionY) {
//				collisionY = this.collisionLayer.getCell((int) ((getX() + getWidth() / 2) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//			
//			// top right
//			if(!collisionY) {
//				collisionY = this.collisionLayer.getCell((int) ((getX() + getWidth()) / tileWidth), (int) ((getY() + getHeight()) / tileHeight)).getTile().getProperties().containsKey("blocked");
//			}
//		}
//		
//		/**
//		 * En cas de collision
//		 * On remet le personnage à sa place initiale
//		 * On remet sa vitesse a 0
//		 */
//		if(collisionY) {
//			setY(oldY);
//			this.velocity.y = 0;
//		}
//				
//	}
	
	

	public void update(float delta) {
		// apply gravity
		velocity.y -= gravity * delta;

		// clamp velocity
		if(velocity.y > speed)
			velocity.y = speed;
		else if(velocity.y < -speed)
			velocity.y = -speed;

		// save old position
		float oldX = getX(), oldY = getY();
		boolean collisionX = false, collisionY = false;

		// move on x
		setX(getX() + velocity.x * delta);

		if(velocity.x < 0) // going left
			collisionX = collidesLeft();
		else if(velocity.x > 0) // going right
			collisionX = collidesRight();

		// react to x collision
		if(collisionX) {
			setX(oldX);
			velocity.x = 0;
		}

		// move on y
		setY(getY() + velocity.y * delta);

		if(velocity.y < 0) // going down
			canJump = collisionY = collidesBottom();
		else if(velocity.y > 0) // going up
			collisionY = collidesTop();

		// react to y collision
		if(collisionY) {
			setY(oldY);
			velocity.y = 0;
		}

	}

	private boolean isCellBlocked(float x, float y) {
		Cell cell = collisionLayer.getCell((int) (x / collisionLayer.getTileWidth()), (int) (y / collisionLayer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey("blocked");
	}

	public boolean collidesRight() {
		for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
			if(isCellBlocked(getX() + getWidth(), getY() + step))
				return true;
		return false;
	}

	public boolean collidesLeft() {
		for(float step = 0; step < getHeight(); step += collisionLayer.getTileHeight() / 2)
			if(isCellBlocked(getX(), getY() + step))
				return true;
		return false;
	}

	public boolean collidesTop() {
		for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
			if(isCellBlocked(getX() + step, getY() + getHeight()))
				return true;
		return false;

	}

	public boolean collidesBottom() {
		for(float step = 0; step < getWidth(); step += collisionLayer.getTileWidth() / 2)
			if(isCellBlocked(getX() + step, getY()))
				return true;
		return false;
	}

	public Vector2 getVelocity() {
		return velocity;
	}

	public void setVelocity(Vector2 velocity) {
		this.velocity = velocity;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getGravity() {
		return gravity;
	}

	public void setGravity(float gravity) {
		this.gravity = gravity;
	}

	public TiledMapTileLayer getCollisionLayer() {
		return collisionLayer;
	}

	public void setCollisionLayer(TiledMapTileLayer collisionLayer) {
		this.collisionLayer = collisionLayer;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch(keycode) {
			case Keys.Z:
				if(canJump) {
					this.velocity.y = speed;
					canJump = false;
				}
				break;
			case Keys.Q:
				this.velocity.x = -speed;
				break;
			case Keys.D:
				this.velocity.x = speed;
				break;
		}
		
		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
			case Keys.Q:
			case Keys.D:
				this.velocity.x = 0;
				break;
		}
		
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
}
