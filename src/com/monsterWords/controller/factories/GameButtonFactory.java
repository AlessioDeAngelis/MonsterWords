package com.monsterWords.controller.factories;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.monsterWords.model.button.*;

public class GameButtonFactory {

	// Private constructor prevents instantiation from other classes
	private GameButtonFactory() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final GameButtonFactory INSTANCE = new GameButtonFactory();
	}

	public static GameButtonFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public GameButton createGameButton(String buttonName, float x, float y, Game game) {
		GameButton gameButton = null;
		if (buttonName != null) {
			/**
			 * FLAG BUTTONS
			 * */
			float texelWidth = Gdx.graphics.getWidth()/12f;
			texelWidth = 100;
			if (buttonName.equals("italianFlag")) {
				gameButton = new ItalianFlagButton(game, x, y, texelWidth, texelWidth);//previuosly (100,100)
			} else if (buttonName.equals("englishFlag")) {
				gameButton = new EnglishFlagButton(game, x, y, texelWidth, texelWidth);
			} else if (buttonName.equals("norwegianFlag")) {
				gameButton = new NorwegianFlagButton(game, x, y, texelWidth, texelWidth);
			} else if (buttonName.equals("spanishFlag")) {
				gameButton = new SpanishFlagButton(game, x, y,texelWidth, texelWidth);
			} 
			else if (buttonName.equals("frenchFlag")) {
				gameButton = new FrenchFlagButton(game, x, y, texelWidth, texelWidth);
			} 
			else if (buttonName.equals("germanFlag")) {
				gameButton = new GermanFlagButton(game, x, y, texelWidth, texelWidth);
			} 
			
			/**
			 * GAME BUTTONS
			 * */
			else if (buttonName.equals("play")) {
				gameButton = new PlayGameButton(game, x, y, 195, 60);
			} else if (buttonName.equals("credits")) {
				gameButton = new CreditsButton(game, x, y, 315, 60);// TODO: fix
																	// size
			} else if (buttonName.equals("highscore")) {
				gameButton = new HighscoreButton(game, x, y, 442, 60);// TODO: fix
			} else if (buttonName.equals("rules")) {
				gameButton = new RulesButton(game, x, y, 245, 60);// TODO: fix
			} else if (buttonName.equals("continue")) {
				gameButton = new RulesButton(game, x, y, 100,100);// TODO: fix
			}
		}
		return gameButton;
	}
}