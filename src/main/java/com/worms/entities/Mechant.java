package com.worms.entities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class Mechant extends Sprite implements InputProcessor {

	private float speed = 10;
	boolean isMovedRight = false;
	boolean isMoved = false;

	public Mechant() {
		super(new Texture(Gdx.files.internal("Base pack/Player/mechant.png")));

	}

	public void update(float delta) {
		int oldX = (int) this.getX();
		if (isMoved == false) {
			if (isMovedRight) {
				this.setX(speed + oldX);
			} else {
				this.setX(oldX - speed);
			}
		}

	}

	@Override
	public void draw(Batch batch) {
		this.update(Gdx.graphics.getDeltaTime());
		super.draw(batch);
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode) {
		case Keys.NUM_1:
			System.out.println("Ennemie1");
			break;
		case Keys.NUM_2:
			System.out.println("Ennemie2");
			break;

		case Keys.NUM_3:
			System.out.println("Ennemie3");
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

		if (screenX > 0) {
			if (screenX > (Gdx.graphics.getWidth() - 300) && screenX < Gdx.graphics.getWidth()) {
				isMovedRight = true;
				isMoved = false;
			}
			if (screenX > 0 && screenX < (Gdx.graphics.getWidth() - 700)) {
				isMovedRight = false;
				isMoved = false;
			}
			if (screenX > (Gdx.graphics.getWidth() - 700) && screenX < (Gdx.graphics.getWidth() - 300)) {
				isMoved = true;
			}
		}

		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}

}
