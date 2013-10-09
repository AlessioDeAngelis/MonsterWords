package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RoundScreen;

public class FrenchFlagButton extends GameButton{

	public FrenchFlagButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("frenchFlag");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new RoundScreen(this.getGame(),"french"));
	}

}
