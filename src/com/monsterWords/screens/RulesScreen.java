package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.monsterWords.controller.factories.GameButtonFactory;
import com.monsterWords.model.button.GameButton;
import com.monsterWords.view.RulesView;

public class RulesScreen implements Screen {
	private RulesView rulesView;
	private Game game;
	private int currentSlide;
	private float timeElapsed;
	private GameButton continueButton,goBackButton;

	public RulesScreen(Game game) {
		this.game = game;
		Gdx.input.setCatchBackKey(true);
		this.currentSlide = 0;
		this.continueButton = GameButtonFactory.getInstance().createGameButton("continue",
				Gdx.graphics.getWidth() - 150, 50, game);
		this.goBackButton = GameButtonFactory.getInstance().createGameButton("continue",
				150, 50, game);
		this.rulesView = new RulesView(continueButton,goBackButton);

	}

	@Override
	public void render(float delta) {
		this.rulesView.render(delta, currentSlide);
		timeElapsed += delta;
		float x = Gdx.input.getX();
		float y = Gdx.graphics.getHeight() - Gdx.input.getY();
		if (Gdx.input.justTouched() && timeElapsed >= 1) {	
			if (this.continueButton.getBoundingRectangle().contains(x, y)) {
				currentSlide++;
				timeElapsed = 0;
			}
			if (this.goBackButton.getBoundingRectangle().contains(x, y)) {
				currentSlide--;
				timeElapsed = 0;
			}
		}
		if(currentSlide <=0){
			currentSlide = 0;
		}
		if (currentSlide > 4) {
			// there is no more slide to show, go back to the title screen
			this.game.setScreen(new TitleScreen(game));
		}
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void show() {
		this.currentSlide = 0;
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
		this.rulesView.dispose();
	}

}
