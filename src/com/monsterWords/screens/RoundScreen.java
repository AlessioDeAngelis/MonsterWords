package com.monsterWords.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.monsterWords.controller.RoundController;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Round;
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
		roundController.update(delta);
		roundView.render();
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		Hero hero = this.round.getHero();
		Body bodyHero = hero.getBody();
		bodyHero.setAwake(true);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		Hero hero = this.round.getHero();
		Body bodyHero = hero.getBody();
		bodyHero.setAwake(false);
		return true;
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
