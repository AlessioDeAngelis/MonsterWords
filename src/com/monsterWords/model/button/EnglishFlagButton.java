package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RoundScreen;

public class EnglishFlagButton extends GameButton {

	public EnglishFlagButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("englishFlag");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new RoundScreen(this.getGame(), "english"));
	}

}
