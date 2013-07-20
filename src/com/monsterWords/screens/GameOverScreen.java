package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.monsterWords.view.GameOverView;

public class GameOverScreen implements Screen{

	private Game game;
	private GameOverView gameOverView;
	
	public GameOverScreen(Game game){
		this.game = game;
		this.gameOverView = new GameOverView();
	}
	
	@Override
	public void render(float delta) {
		
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
		
	}

}
