package com.monsterWords.controller.factories;

import com.badlogic.gdx.Game;
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
			if (buttonName.equals("italianFlag")) {
				gameButton = new ItalianFlagButton(game,x,y,100,100);
			}else if (buttonName.equals("englishFlag")) {
				gameButton = new EnglishFlagButton(game,x,y,100,100);
			}else if (buttonName.equals("norwegianFlag")) {
				gameButton = new NorwegianFlagButton(game,x,y,100,100);
			}else if (buttonName.equals("play")) {
				gameButton = new PlayGameButton(game,x,y,100,100);
			}else if (buttonName.equals("credits")) {
				gameButton = new CreditsButton(game,x,y,100,100);
			}
		}
		return gameButton;
	}

}