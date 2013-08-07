package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.factories.GameButtonFactory;
import com.monsterWords.model.button.GameButton;
import com.monsterWords.view.ChooseGameView;

public class ChooseGameScreen implements Screen, InputProcessor {

	private Game game;
	private Array<GameButton> buttons;
	private ChooseGameView chooseGameView;

	public ChooseGameScreen(Game game) {
		super();
		this.game = game;
		this.buttons = new Array<GameButton>();
		initializeButtons();
		this.chooseGameView = new ChooseGameView(buttons);
		Gdx.input.setInputProcessor(this);
	}

	private void initializeButtons() {
		GameButton gameButton = GameButtonFactory.getInstance().createGameButton("italianFlag", 450, 300, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("englishFlag", 600, 300, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("norwegianFlag", (600+450)/2, 200, game);
		this.buttons.add(gameButton);
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		this.chooseGameView.render(delta);
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		
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
		this.chooseGameView.dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
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
		for (GameButton gameButton : buttons) {
			boolean inputIsInside = gameButton.getBoundingRectangle().contains(screenX,
					Gdx.graphics.getHeight() - screenY);
			// System.out.println(inputIsInside +
			// ","+this.getBoundingRectangle().toString() + "----" +screenX+","
			// + screenY);
			if (inputIsInside) {
				gameButton.executeAction();
			}
		}
		return true;
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
