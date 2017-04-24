package com.worms.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.worms.hud.HudMechant;

public class Mechant extends Sprite implements InputProcessor {

	private float speed = 10;
	private boolean isMovedRight = false;
	private boolean isMovedLeft = false;
	private int movableSpace = 100;

	
	private int enemyToAdd;
	private boolean isAddEnemy = false;
	private HudMechant hud;
	
	public Mechant() {
		super(new Texture(Gdx.files.internal("Base pack/Player/mechant.png")));
	}

	public void update(float delta) {
		int oldX = (int) this.getX();

		if (this.isMovedRight) {
			//this.setX(this.speed + oldX);
		}

		if (this.isMovedLeft) {
			//this.setX(oldX - this.speed);
		}
	}

	@Override
	public void draw(Batch batch) {
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}
	
	public boolean isAddEnemy() {
		return this.isAddEnemy;
	}

	public void setAddEnemy(boolean isAddEnemy) {
		this.isAddEnemy = isAddEnemy;
	}

	public int getEnemyToAdd() {
		return this.enemyToAdd;
	}

	public void setEnemyToAdd(int i) {
		this.enemyToAdd = i;
	}
	
	public void setHud(HudMechant hud) {
		this.hud = hud;
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.NUM_1:
			if(this.hud.flyflyMoins()) {
				this.setAddEnemy(true);
				this.setEnemyToAdd(1);
			}
			break;
		case Keys.NUM_2:
			if(this.hud.slimMoins()) {
				this.setAddEnemy(true);
				this.setEnemyToAdd(2);
			}
			break;
		case Keys.NUM_3:
			if(this.hud.spiderMoins()) {
				this.setAddEnemy(true);
				this.setEnemyToAdd(3);
			}
			break;
		}

		return true;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
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

		this.isMovedRight = false;
		this.isMovedLeft = false;

		if (screenX > 0) {
			if (screenX > (Gdx.graphics.getWidth() - this.movableSpace) && screenX < Gdx.graphics.getWidth()) {
				this.isMovedRight = true;
			} else if (screenX > 0 && screenX < this.movableSpace) {
				this.isMovedLeft = true;
			}
		}

		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
