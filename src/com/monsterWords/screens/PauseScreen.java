package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.Screen;
import com.monsterWords.view.PauseView;

public class PauseScreen implements Screen {
		
	private Game game;
	private GameStatus currentGameStatus;
	private PauseView pauseView;
	private RoundScreen roundScreen;
	
	public PauseScreen(Game game, RoundScreen roundScreen){
		this.game = game;
		this.roundScreen = roundScreen;
		this.pauseView = new PauseView();
		Gdx.input.setCatchBackKey(true);
	} 
	
	public void setRoundScreen(RoundScreen roundScreen){
		this.roundScreen = roundScreen;
	}
	
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    	pauseView.draw();
		if (Gdx.input.isKeyPressed(Keys.BACK)) {
            this.roundScreen.resumeGame();
            this.game.setScreen(roundScreen);
        }

	}


	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		this.currentGameStatus = GameStatus.GAME_RUNNING;
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
		pauseView.dispose();
	}

}
