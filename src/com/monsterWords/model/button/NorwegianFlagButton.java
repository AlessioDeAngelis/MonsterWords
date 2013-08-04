package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RoundScreen;

public class NorwegianFlagButton extends GameButton{

//TODO: add norwegian language support
	public NorwegianFlagButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("norwegianFlag");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new RoundScreen(this.getGame(),"english"));
	}

}
