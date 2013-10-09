package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.HighscoreScreen;

public class HighscoreButton extends GameButton{

	public HighscoreButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("highscore");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new HighscoreScreen(this.getGame()));
	}

}
