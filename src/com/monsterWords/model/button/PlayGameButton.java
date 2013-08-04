package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.ChooseGameScreen;

public class PlayGameButton extends GameButton{

	public PlayGameButton(Game game, float x, float y, float width, float height) {
		super(game, x, y, width, height);
		this.setName("play");
	}

	@Override
	public void executeAction() {
		this.getGame().setScreen(new ChooseGameScreen(this.getGame()));
	}

}
