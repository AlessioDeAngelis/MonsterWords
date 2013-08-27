package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.monsterWords.controller.HeroController;
import com.monsterWords.controller.RoundController;
import com.monsterWords.controller.factories.LanguageControllerFactory;
import com.monsterWords.controller.languages.ItalianLanguageController;
import com.monsterWords.controller.languages.LanguageController;
import com.monsterWords.model.Round;
import com.monsterWords.view.MusicPlayer;
import com.monsterWords.view.RoundView;

public class RoundScreen implements Screen {

	private Round round;
	private String languageName;
	private RoundController roundController;
	private RoundView roundView;
	private HeroController heroController;
	private Game game;
	public RoundScreen(Game game, String languageName){
		this.game = game;
		this.languageName = languageName;
	}

	@Override
	public void show() {
		this.round = new Round();
		LanguageController languageController = LanguageControllerFactory.getInstance().createLanguageController(languageName);
		this.roundController = new RoundController(round,null, languageController);
		MusicPlayer.getInstance().playSoundtrack();
		this.roundView = new RoundView(this.round);
		this.roundController.populateWorld();
		this.heroController = new HeroController(this.round.getHero());
		this.roundController.setHeroController(heroController);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.56f, 0.165f, 0.1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(roundController.isGameOver()){
			this.game.setScreen(new GameOverScreen(game,heroController.getHero().getTotalScore()));
		}
		heroController.update(delta);
		roundController.update(delta);
		roundView.render();
	}

	@Override
	public void resize(int width, int height) {
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
		this.roundView.dispose();
		MusicPlayer.getInstance().dispose();
	}
}
