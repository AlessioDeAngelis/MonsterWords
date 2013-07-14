package com.monsterWords.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.Peripheral;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.monsterWords.controller.RoundController;
import com.monsterWords.model.Round;
import com.monsterWords.model.hero.*;
import com.monsterWords.utils.Constants;
import com.monsterWords.view.RoundView;

public class RoundScreen implements Screen, InputProcessor {

	private Round round;
	private RoundController roundController;
	private RoundView roundView;
	private World box2dWorld;
	private Body body;
	private static final float WORLD_SCALE = Constants.WORLD_SCALE;

	@Override
	public void show() {
		this.round = new Round();
		this.roundController = new RoundController(round);
		this.roundView = new RoundView(this.round);
		Gdx.input.setInputProcessor(this);
		this.roundController.populateWorld();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isPeripheralAvailable(Peripheral.Accelerometer)) {
			// updateHeroAccelerometer();
		}
		roundController.update(delta);
		roundView.render();
	}

	public void updateHeroAccelerometer() {
		Hero hero = this.round.getHero();
		// in landscape mode the axis are inverted
		float translationXFactor = Gdx.input.getAccelerometerY() * hero.getSpeedValue();
		float translationYFactor = Gdx.input.getAccelerometerX() * hero.getSpeedValue() * 4f;
		translationXFactor *= Gdx.graphics.getDeltaTime();// if you don't want
															// continuous
															// movement
		translationYFactor *= Gdx.graphics.getDeltaTime();// if you don't want
															// continuous
															// movement

		float newX = hero.getX() + translationXFactor;
		if (newX >= 0) {
			hero.setX(newX);
		} else if (newX + hero.getWidth() > Gdx.graphics.getWidth()) {
			newX = Gdx.graphics.getWidth() - hero.getWidth();
			hero.setX(newX);
		}

		float newY = hero.getY() - translationYFactor;
		if (newY >= 0) {
			hero.setY(newY);
		} else if (newY + hero.getHeight() > Gdx.graphics.getHeight()) {
			newY = Gdx.graphics.getHeight() - hero.getHeight();
			hero.setY(newY);
		}
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}

	@Override
	public boolean keyDown(int keycode) {
		Hero hero = this.round.getHero();
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
		Hero hero = this.round.getHero();
		float speed = hero.getSpeedValue();
		if (Math.abs(screenX - hero.getX()) > Math.abs(screenY) - hero.getOriginY()) {
			if (screenX < hero.getX()) {
				hero.setState(new MoveLeft());
				hero.translateX(-speed);
			} else {
				hero.setState(new MoveRight());
				hero.translateX(speed);
			}
		} else {
			if (screenY > hero.getY()) {
				hero.setState(new MoveDown());
				hero.translateY(-speed);
			} else {
				hero.setState(new MoveUp());
				hero.translateY(speed);
			}
		}
		
//		if (Math.abs(screenX - hero.getX()) > Math.abs(screenY) - hero.getOriginY()) {
			if (screenX < hero.getX()) {
//				hero.setState(new MoveLeft());
				hero.translateX(-speed);
			} else {
//				hero.setState(new MoveRight());
				hero.translateX(speed);
			}
//		} else {
			if (screenY > hero.getY()) {
//				hero.setState(new MoveDown());
				hero.translateY(speed);
			} else {
//				hero.setState(new MoveUp());
				hero.translateY(-speed);
//			}
		}
		
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		Hero hero = this.round.getHero();
		float speed = hero.getSpeedValue();
		if (Math.abs(screenX - hero.getX()) > Math.abs(screenY) - hero.getOriginY()) {
			if (screenX < hero.getX()) {
				hero.setState(new MoveLeft());
				hero.translateX(-speed);
			} else {
				hero.setState(new MoveRight());
				hero.translateX(speed);
			}
		} else {
			if (screenY > hero.getY()) {
				hero.setState(new MoveDown());
				hero.translateY(-speed);
			} else {
				hero.setState(new MoveUp());
				hero.translateY(speed);
			}
		}
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
