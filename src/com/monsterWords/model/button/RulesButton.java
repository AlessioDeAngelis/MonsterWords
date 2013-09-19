package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RulesScreen;

public class RulesButton extends GameButton{

	public RulesButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("rules");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new RulesScreen(this.getGame()));
	}

}
