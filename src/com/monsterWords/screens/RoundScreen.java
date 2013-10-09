package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.GL20;
import com.monsterWords.controller.HeroController;
import com.monsterWords.controller.RoundController;
import com.monsterWords.controller.factories.LanguageControllerFactory;
import com.monsterWords.controller.languages.ItalianLanguageController;
import com.monsterWords.controller.languages.LanguageController;
import com.monsterWords.model.AnimatedScore;
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
	private GameStatus currentGameStatus;
	private PauseScreen pauseScreen;

	public RoundScreen(Game game, String languageName) {
		this.game = game;
		this.languageName = languageName;
		Gdx.input.setCatchBackKey(true);
	}

	@Override
	public void show() {
		this.round = new Round();
		this.currentGameStatus = GameStatus.GAME_RUNNING;
		LanguageController languageController = LanguageControllerFactory.getInstance().createLanguageController(
				languageName);
		this.roundController = new RoundController(round, null, languageController);
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
		if (roundController.isGameOver()) {
			this.game.setScreen(new GameOverScreen(game, heroController.getHero().getTotalScore()));
		}
		// TODO: to test the pause
		 if (Gdx.input.isKeyPressed(Keys.BACK)) {
		// pauseGame();
		 }
		//
		// if (currentGameStatus == GameStatus.GAME_PAUSED) {
		// pauseScreen = new PauseScreen(game, this);
		// pauseScreen.setRoundScreen(this);
		// // pauseScreen.render(delta);
		// this.game.setScreen(pauseScreen);
		// }else{
		heroController.update(delta);
		roundController.update(delta);
		roundView.render();
		// }
	}

	public void pauseGame() {
		MusicPlayer.getInstance().pauseSoundtrack();
		currentGameStatus = GameStatus.GAME_PAUSED;
	}

	public void resumeGame() {
		MusicPlayer.getInstance().playSoundtrack();
		currentGameStatus = GameStatus.GAME_RUNNING;
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void hide() {
	}

	@Override
	public void pause() {
		pauseGame();
	}

	@Override
	public void resume() {
		resumeGame();
	}

	@Override
	public void dispose() {
		this.roundView.dispose();
		MusicPlayer.getInstance().dispose();
		if (pauseScreen != null) {
			pauseScreen.dispose();
		}
	}
}
