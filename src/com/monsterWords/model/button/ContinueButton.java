package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.CreditsScreen;

public class ContinueButton extends GameButton{

	public ContinueButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("continue");
	}

	@Override
	public void executeAction() {

	}

}
