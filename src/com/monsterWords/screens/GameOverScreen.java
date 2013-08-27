package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.monsterWords.view.GameOverView;
import com.monsterWords.view.MusicPlayer;

public class GameOverScreen implements Screen {

	private Game game;
	private GameOverView gameOverView;
	private int roundScore;

	public GameOverScreen(Game game, int roundScore) {
		this.game = game;
		this.roundScore = roundScore;
		this.gameOverView = new GameOverView(roundScore);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gameOverView.render(delta);
		if (Gdx.input.justTouched()) {
			MusicPlayer.getInstance().stopSoundtrack();
			this.game.setScreen(new TitleScreen(game));
		}
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
		gameOverView.dispose();
	}

}
