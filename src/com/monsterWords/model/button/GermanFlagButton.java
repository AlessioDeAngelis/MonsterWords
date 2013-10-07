package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RoundScreen;

public class GermanFlagButton extends GameButton{

	public GermanFlagButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("germanFlag");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new RoundScreen(this.getGame(),"german"));
	}

}
