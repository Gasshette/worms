package com.worms.game.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.worms.game.GameWorms;
import com.worms.game.screens.MainMenuScreen;

public class Player extends Sprite implements InputProcessor {

	/** The movement velocity */
	private Vector2 velocity = new Vector2();

	private float speed = 300 * 2, gravity = 600 * 1.0f;

	private TiledMapTileLayer background;
	private TiledMapTileLayer foreground;
	private GameWorms g;
	private boolean canJump;

	public Player(GameWorms g, Sprite sprite, TiledMapTileLayer background, TiledMapTileLayer foreground) {
		super(sprite);
		this.g = g;
		this.background = background;
		this.foreground = foreground;
	}

	@Override
	public void draw(Batch batch) {
		update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	public void update(float delta) {
		float oldX = getX(), oldY = getY();
		boolean collisionRight = false, collisionLeft = false, collisionTop = false, collisionBottom = false;
		boolean finish = false;

		// Gravite
		velocity.y -= gravity * delta;

		if (velocity.y > speed)
			velocity.y = speed;
		else if (velocity.y < -speed)
			velocity.y = -speed;

		/**
		 * GESTION DES MOUVEMENTS 
		 * Modification de la position 
		 * Check si collision
		 * Recuperation du type de collision + traitement
		 */
		// X
		setX(getX() + velocity.x * delta);

		if (velocity.x < 0) { // LEFT
			collisionLeft = collidesLeft(this.background, "blocked");
			finish = collidesLeft(this.foreground, "finish");
		}
		else if (velocity.x > 0) { // RIGHT
			collisionRight = collidesRight(this.background, "blocked");
			if(!finish) {
				finish = collidesRight(this.foreground, "finish");
			}
		}
		

		if (collisionRight || collisionLeft) {
			setX(oldX);
			velocity.x = 0;
		}
		
		// Y
		setY(getY() + velocity.y * delta);
		
		if (velocity.y < 0) { // DOWN
			collisionBottom = collidesBottom(this.background, "blocked");
			canJump = collisionBottom;
			if(!finish) {
				finish = collidesBottom(this.foreground, "finish");
			}
		}
		else if (velocity.y > 0) { // UP
			collisionTop = collidesTop(this.background, "blocked");
			if(!finish) {
				finish = collidesTop(this.foreground, "finish");
			}
		}

		if (collisionTop || collisionBottom) {
			setY(oldY);
			velocity.y = 0;
		}
		
		/**
		 * Fin du niveau
		 */
		if(finish) {
			g.setScreen(new MainMenuScreen(g));
		}
	}

	private boolean isCell(TiledMapTileLayer layer, float x, float y, String property) {
		Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(property);
	}

	public boolean collidesRight(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < getHeight(); step += layer.getTileHeight() / 2) {
			if (isCell(layer, getX() + getWidth(), getY() + step, property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesLeft(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < getHeight(); step += layer.getTileHeight() / 2) {
			if (isCell(layer, getX(), getY() + step, property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesTop(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < getWidth(); step += layer.getTileWidth() / 2) {
			if (isCell(layer, getX() + step, getY() + getHeight(), property)) {
				return true;
			}
		}
		
		return false;
	}

	public boolean collidesBottom(TiledMapTileLayer layer, String property) {
		for (float step = 0; step < getWidth(); step += layer.getTileWidth() / 2) {
			if (isCell(layer, getX() + step, getY(), property)) {
				return true;
			}
		}
		
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
		return background;
	}

	public void setCollisionLayer(TiledMapTileLayer background) {
		this.background = background;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.Z:
			if (canJump) {
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
		switch (keycode) {
		case Keys.Q:
		case Keys.D:
			this.velocity.x = 0;
			break;
		}

		return true;
	}

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

}
