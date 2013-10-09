package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.monsterWords.persistence.ScoreRepository;
import com.monsterWords.view.HighscoreView;

public class HighscoreScreen implements Screen{
	private HighscoreView highscoreView;
	private Game game;
	private float timeElapsed;
	public HighscoreScreen(Game game){
		this.game = game;
		Gdx.input.setCatchBackKey(true);
		int highscore = ScoreRepository.getInstance().retrieveScore();
		this.highscoreView = new HighscoreView(highscore);
		this.timeElapsed = 0;
	}
	@Override
	public void render(float delta) {
		highscoreView.render(delta);
		timeElapsed+=delta;
		if(timeElapsed>1 && Gdx.input.justTouched() || Gdx.input.isKeyPressed(Keys.BACK)){
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
		highscoreView.dispose();
	}

}
