package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.monsterWords.persistence.ScoreRepository;
import com.monsterWords.view.GameOverView;
import com.monsterWords.view.MusicPlayer;

public class GameOverScreen implements Screen {

	private Game game;
	private GameOverView gameOverView;
	private int roundScore;
	private boolean doneCheckingForHighscore;
	private float timeElapsed;

	public GameOverScreen(Game game, int roundScore) {
		this.game = game;
		this.roundScore = roundScore;
		Gdx.input.setCatchBackKey(true);
		this.gameOverView = new GameOverView(roundScore);
		this.doneCheckingForHighscore = false;
		this.timeElapsed = 0;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		timeElapsed += delta;
		gameOverView.render(delta);
		
		/**
		 * If the round score is higher than the highscore it will be saved
		 * as new highscore
		 * */
		if(!doneCheckingForHighscore){
			doneCheckingForHighscore = true;
			int highscore = ScoreRepository.getInstance().retrieveScore();
			if(roundScore> highscore){
				ScoreRepository.getInstance().saveScore(roundScore);
			}
		}
		
		/**
		 * Check for input so you can go back to the title screen
		 * */
		if ((Gdx.input.justTouched()||Gdx.input.isKeyPressed(Keys.BACK))&&timeElapsed>1) {
			MusicPlayer.getInstance().stopSoundtrack();
			this.game.setScreen(new TitleScreen(game));
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		this.timeElapsed = 0;
		this.doneCheckingForHighscore = false;
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
