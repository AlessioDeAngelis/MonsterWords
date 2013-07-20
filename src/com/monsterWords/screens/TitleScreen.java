package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.monsterWords.view.TitleView;

public class TitleScreen implements Screen {

	private Game game;
	private TitleView titleView;
	
	public TitleScreen(Game game){
		this.game = game;
		this.titleView = new TitleView();
	}
	@Override
	public void render(float delta) {
		titleView.render();
		if(Gdx.input.isTouched()){
			this.game.setScreen(new RoundScreen(this.game));
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
		this.titleView.dispose();
	}

}
