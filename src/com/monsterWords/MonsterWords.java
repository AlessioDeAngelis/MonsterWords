package com.monsterWords;

import java.util.List;

import com.badlogic.gdx.Game;
import com.monsterWords.controller.WordListMatcher;
import com.monsterWords.screens.RoundScreen;

public class MonsterWords extends Game {
	@Override
	public void create() {
		this.setScreen(new RoundScreen());
	}
}
