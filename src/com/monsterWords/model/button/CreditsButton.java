package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.CreditsScreen;

public class CreditsButton extends GameButton{

	public CreditsButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("credits");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new CreditsScreen(this.getGame()));
	}

}
