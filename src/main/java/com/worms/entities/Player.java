package com.worms.entities;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.maps.MapProperties;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer;
import com.badlogic.gdx.maps.tiled.TiledMapTileLayer.Cell;
import com.badlogic.gdx.math.Vector2;
import com.worms.hud.HudHero;

public class Player extends Sprite implements InputProcessor {
	/** The movement velocity */
	private Vector2 velocity = new Vector2();
	private float speed = 500, gravity = 500;

	// Layers of the map
	private TiledMapTileLayer background;
	private TiledMapTileLayer foreground;

	private boolean canJump;
	private boolean shoot = false;
	private final int timerDecalage = 15;
	private float pv = 100f;
	public boolean isTouch = false;
	private boolean isLife = true;
	private float timeCount = 0;

	private HudHero hud;

	public Player(Texture texture, TiledMapTileLayer background, TiledMapTileLayer foreground) {
		super(texture);
		this.background = background;
		this.foreground = foreground;
	}

	public void update(float delta) {

		float oldX = this.getX(), oldY = this.getY();
		boolean collisionRight = false, collisionLeft = false, collisionTop = false, collisionBottom = false;
		boolean enemy = false;

		// Gravite
		this.velocity.y -= this.gravity * delta;

		if (this.velocity.y > this.speed) {
			this.velocity.y = this.speed;
		} else if (this.velocity.y < -this.speed) {
			this.velocity.y = -this.speed;
		}

		// Movment code
		this.setX(this.getX() + this.velocity.x * delta);

		if (this.velocity.x < 0) { // LEFT
			collisionLeft = this.collidesLeft(this.background, "blocked")
					|| this.collidesLeft(this.foreground, "blocked");
			enemy = this.collidesLeft(this.foreground, "enemy");
		} else if (this.velocity.x > 0) { // RIGHT
			collisionRight = this.collidesRight(this.background, "blocked")
					|| this.collidesRight(this.foreground, "blocked");

			if (!enemy) {
				enemy = this.collidesRight(this.foreground, "enemy");
			}
		}

		if (collisionRight || collisionLeft) {
			this.setX(oldX);
			this.velocity.x = 0;
		}

		this.setY(this.getY() + this.velocity.y * delta);

		if (this.velocity.y < 0) { // DOWN
			collisionBottom = this.collidesBottom(this.background, "blocked")
					|| this.collidesBottom(this.foreground, "blocked");
			this.canJump = collisionBottom;

			if (!enemy) {
				enemy = this.collidesBottom(this.foreground, "enemy");
			}
		} else if (this.velocity.y > 0) { // UP
			collisionTop = this.collidesTop(this.background, "blocked") || this.collidesTop(this.foreground, "blocked");

			if (!enemy) {
				enemy = this.collidesTop(this.foreground, "enemy");
			}
		}

		if (collisionTop || collisionBottom) {
			this.setY(oldY);
			this.velocity.y = 0;
		}

		// PV code
		if (enemy) {
			System.out.println("Perte de pv");
			this.pv -= 0.2f;
			System.out.println("Point de vie !! PV : " + this.pv);
		}

		// Loot code
		Cell currentCell = this.getCell(this.foreground);
		if (currentCell != null && currentCell.getTile() != null) {
			if (currentCell.getTile().getProperties().containsKey("collectible")) {
				this.collectible(currentCell);

			}
		}
		if (this.background.getCell((int) (this.getX() / this.background.getTileWidth()),
				(int) (this.getY() / this.background.getTileHeight())) == null) {
			isLife = false;
		}

	}

	private boolean isCell(TiledMapTileLayer layer, float x, float y, String property) {
		Cell cell = layer.getCell((int) (x / layer.getTileWidth()), (int) (y / layer.getTileHeight()));
		return cell != null && cell.getTile() != null && cell.getTile().getProperties().containsKey(property);
	}

	private Cell getCell(TiledMapTileLayer layer) {
		return layer.getCell((int) (this.getX() / layer.getTileWidth()),
				(int) (this.getY() / this.background.getTileHeight()));
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

	private void isStillLife() {
		if (this.hud.nbVieRestant() <= -1) {
			this.isLife = false;
		}
	}

	public void collectible(Cell currentCell) {
		MapProperties mapPropety = currentCell.getTile().getProperties();
		if (mapPropety.containsKey("collectible")) {
			for (Iterator<Object> iter = mapPropety.getValues(); iter.hasNext();) {
				String valueProperties = iter.next().toString();
				if (valueProperties.equals("gold") == true) {
					this.hud.setGold(1);
					currentCell.setTile(null);
					break;
				}
				if (valueProperties.equals("germ") == true) {
					this.hud.setGerm(1);
					currentCell.setTile(null);
					break;
				}

				if (valueProperties.equals("finish") == true) {
					System.exit(0);
					break;
				}
				if (valueProperties.equals("trap") == true) {

					this.hud.lifeMoins();

				}
			}

		}
		this.isStillLife();
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
		case Keys.ENTER:
			this.shoot = true;
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
		case Keys.ENTER:
			this.shoot = false;
			break;
		}

		return true;
	}

	public boolean isShoot() {
		return this.shoot;
	}

	public void setShoot(boolean shoot) {
		this.shoot = shoot;
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

	public int getTimerDecalage() {
		return this.timerDecalage;
	}

	public void setHud(HudHero hud) {
		this.hud = hud;
		this.hud.setPlayer(this);
	}

	public HudHero getHud() {
		return this.hud;
	}

	public boolean isLife() {
		return isLife;
	}

}
