package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.factories.GameButtonFactory;
import com.monsterWords.model.button.GameButton;
import com.monsterWords.view.TitleView;

public class TitleScreen implements Screen,InputProcessor{

	private Game game;
	private TitleView titleView;
	private Array<GameButton> buttons;

	// private Stage stage;
	// private TextButton buttonsP1[] = new TextButton[3];
	// private TextButton next;

	public TitleScreen(Game game) {
		this.game = game;
		this.buttons = new Array<GameButton>();
		initializeButtons();
		this.titleView = new TitleView(this.buttons);
		Gdx.input.setInputProcessor(this);
		// this.stage = new Stage();
		// this.next = new TextButton(text, style);
	}

	private void initializeButtons() {
		GameButton gameButton = GameButtonFactory.getInstance().createGameButton("play",Gdx.graphics.getWidth()-400, Gdx.graphics.getHeight()-300, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("credits", Gdx.graphics.getWidth()-400, Gdx.graphics.getHeight()-500, game);
		this.buttons.add(gameButton);
	}

	@Override
	public void render(float delta) {
		titleView.render(delta);
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
		this.titleView.dispose();
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
			
			 System.out.println(inputIsInside +
						 ","+gameButton.getBoundingRectangle().toString() + "----" +screenX+","
						 + (Gdx.graphics.getHeight() - screenY));
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
