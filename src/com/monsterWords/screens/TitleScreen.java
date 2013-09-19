package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.factories.GameButtonFactory;
import com.monsterWords.model.button.GameButton;
import com.monsterWords.view.MusicPlayer;
import com.monsterWords.view.TitleView;

public class TitleScreen implements Screen {

	private Game game;
	private TitleView titleView;
	private Array<GameButton> buttons;

	// private Stage stage;
	// private TextButton buttonsP1[] = new TextButton[3];
	// private TextButton next;

	public TitleScreen(Game game) {
		this.game = game;
		this.buttons = new Array<GameButton>();
		Gdx.input.setCatchBackKey(true);
		initializeButtons();
		MusicPlayer.getInstance();// it loads all the music at the beginning
		this.titleView = new TitleView(this.buttons);
		// this.stage = new Stage();
		// this.next = new TextButton(text, style);
	}

	private void initializeButtons() {
		GameButton gameButton = GameButtonFactory.getInstance().createGameButton("play", Gdx.graphics.getWidth() - 345,
				Gdx.graphics.getHeight() - 150, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("credits", Gdx.graphics.getWidth() - 400,
				Gdx.graphics.getHeight() - 250, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("highscore", Gdx.graphics.getWidth() - 450,
				Gdx.graphics.getHeight() - 350, game);
		this.buttons.add(gameButton);
		gameButton = GameButtonFactory.getInstance().createGameButton("rules", Gdx.graphics.getWidth() - 375,
				Gdx.graphics.getHeight() - 450, game);
		this.buttons.add(gameButton);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		checkForInput();
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

	private void checkForInput() {
		float screenX = Gdx.input.getX();
		float screenY = Gdx.input.getY();
		for (GameButton gameButton : buttons) {
			boolean inputIsInside = gameButton.getBoundingRectangle().contains(screenX,
					Gdx.graphics.getHeight() - screenY);

			// System.out.println(inputIsInside +
			// ","+gameButton.getBoundingRectangle().toString() + "----"
			// +screenX+","
			// + (Gdx.graphics.getHeight() - screenY));
			if (inputIsInside && Gdx.input.justTouched()) {
				MusicPlayer.getInstance().playSoundSelect();
				gameButton.executeAction();
			}
		}
		if(Gdx.input.isKeyPressed(Keys.BACK)){//pressing the back key you exit from the application
			Gdx.app.exit();
		}
	}

}
