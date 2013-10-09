package com.monsterWords.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.math.Vector2;
import com.monsterWords.model.hero.Hero;
import com.monsterWords.model.hero.HeroState;
import com.monsterWords.model.hero.MoveDown;
import com.monsterWords.model.hero.MoveLeft;
import com.monsterWords.model.hero.MoveRight;
import com.monsterWords.model.hero.MoveUp;
import com.monsterWords.utils.Constants;

public class HeroController implements InputProcessor {
	private Hero hero;
	private Vector2 touchPoint;
	private float startingOrientation;
	private HeroState[] heroStates;

	public HeroController(Hero hero) {
		this.hero = hero;
		Gdx.input.setInputProcessor(this);
		this.touchPoint = new Vector2();
		this.startingOrientation = Gdx.input.getRoll();
		MoveRight moveRight = new MoveRight();
		MoveLeft moveLeft = new MoveLeft();
		MoveUp moveUp = new MoveUp();
		MoveDown moveDown = new MoveDown();
		this.heroStates = new HeroState[] { moveRight, moveLeft, moveUp, moveDown };
	}

	public Hero getHero() {
		return this.hero;
	}

	public void update(float dt) {
		if (Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)) {
			updateHeroAccelerometer();
		}
		hero.update(dt);
	}

	@Override
	public boolean keyDown(int keycode) {
		float speed = hero.getSpeedValue();
		if (keycode == Keys.LEFT) {
			hero.setState(new MoveLeft());
			hero.translateX(-speed);
		}
		if (keycode == Keys.RIGHT) {
			hero.setState(new MoveRight());
			hero.translateX(speed);
		}
		if (keycode == Keys.UP) {
			hero.setState(new MoveUp());
			hero.translateY(speed);
		}
		if (keycode == Keys.DOWN) {
			hero.setState(new MoveDown());
			hero.translateY(-speed);
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
//		float speed = hero.getSpeedValue();
//		if (Math.abs(screenX - hero.getX()) > Math.abs(screenY) - hero.getOriginY()) {
//			if (screenX < hero.getX()) {
//				hero.setState(new MoveLeft());
//				hero.translateX(-speed);
//			} else {
//				hero.setState(new MoveRight());
//				hero.translateX(speed);
//			}
//		} else {
//			if (screenY > hero.getY()) {
//				hero.setState(new MoveDown());
//				hero.translateY(-speed);
//			} else {
//				hero.setState(new MoveUp());
//				hero.translateY(speed);
//			}
//		}
//
//
//		if (screenX < hero.getX()) {
//			hero.translateX(-speed);
//		} else {
//			hero.translateX(speed);
//		}
//		// } else {
//		if (screenY < hero.getY()) {
//			// hero.setState(new MoveDown());
//			hero.translateY(speed);
//		} else {
//			// hero.setState(new MoveUp());
//			hero.translateY(-speed);
//			// }
//		}

		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
//		float speed = hero.getSpeedValue();
//		if (Math.abs(screenX - hero.getX()) > Math.abs(screenY) - hero.getOriginY()) {
//			if (screenX < hero.getX()) {
//				hero.setState(new MoveLeft());
//				hero.translateX(-speed);
//			} else {
//				hero.setState(new MoveRight());
//				hero.translateX(speed);
//			}
//		} else {
//			if (screenY > hero.getY()) {
//				hero.setState(new MoveDown());
//				hero.translateY(-speed);
//			} else {
//				hero.setState(new MoveUp());
//				hero.translateY(speed);
//			}
//		}
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

	public void updateHeroAccelerometer() {
		// in landscape mode the axis are inverted
		float translationXFactor = Gdx.input.getAccelerometerY() * hero.getSpeedValue() * 4f;
		float translationYFactor = Gdx.input.getAccelerometerX() * hero.getSpeedValue() * 4f;
		translationXFactor *= Gdx.graphics.getDeltaTime();// if you don't want
															// continuous
															// movement
		translationYFactor *= Gdx.graphics.getDeltaTime();// if you don't want
															// continuous
															// movement
		System.out.println("X: " + translationXFactor + "Y: " + translationYFactor);

		float newX = hero.getX() + translationXFactor;
		if (newX < 0) {
			hero.setX(newX);
		} else if (newX + hero.getWidth() > Gdx.graphics.getWidth()-30) {
			newX = Gdx.graphics.getWidth() - hero.getWidth() - 30;
			newX = hero.getX();
			hero.setX(newX);
		}else{
			hero.setX(newX);
		}


		float newY = hero.getY() - translationYFactor;
		if (newY < 0) {
			hero.setY(newY);
		} else if (newY + hero.getHeight() > Gdx.graphics.getHeight()-Constants.TOP_BAR_TICKNESS*2) {
			newY = Gdx.graphics.getHeight() - hero.getHeight() -Constants.TOP_BAR_TICKNESS*2;
			hero.setY(newY);
		}else{
			hero.setY(newY);
		}

		/**
		 * To check which direction the hero is facing
		 * */
		if (Math.abs(translationXFactor) > Math.abs(translationYFactor)) {
			if (translationXFactor > 0) {
				hero.setState(this.heroStates[0]);// moveRight
			} else {
				hero.setState(this.heroStates[1]);// moveLeft
			}
		} else {
			if (translationYFactor < 0) {
				hero.setState(this.heroStates[2]);// moveUp
			} else {
				hero.setState(this.heroStates[3]);// moveDown
			}
		}
	}

}
