package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.monsterWords.view.CreditsView;

public class CreditsScreen implements Screen {
	private Game game;
	private CreditsView creditsView;
	float timeElapsed;

	public CreditsScreen(Game game) {
		this.game = game;
		this.creditsView = new CreditsView();
		timeElapsed = 0;
	}

	@Override
	public void render(float delta) {
		timeElapsed += delta;

		if (Gdx.input.isTouched() && timeElapsed > 3) {
			this.game.setScreen(new TitleScreen(game));
		}
		creditsView.render(delta);
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
		creditsView.dispose();
	}
}
