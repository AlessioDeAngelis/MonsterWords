package com.monsterWords;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.RoundScreen;

public class MonsterWords extends Game {
	@Override
	public void create() {
		this.setScreen(new RoundScreen());
	}
}
