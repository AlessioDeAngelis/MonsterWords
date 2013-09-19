package com.monsterWords;

import com.badlogic.gdx.Game;
import com.monsterWords.screens.LoadingScreen;
import com.monsterWords.screens.TitleScreen;

public class MonsterWords extends Game {
	@Override
	public void create() {
		this.setScreen(new LoadingScreen(this));
	}
}
