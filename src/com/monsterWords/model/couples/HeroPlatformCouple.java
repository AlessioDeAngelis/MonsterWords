package com.monsterWords.model.couples;

import com.monsterWords.controller.WordListMatcher;
import com.monsterWords.model.CheckingPlatform;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Round;

public class HeroPlatformCouple implements CoupleOfEntities{
	private Hero hero;
	private CheckingPlatform checkingPlatform;
	private Round currentRound;

	public HeroPlatformCouple(Hero hero, CheckingPlatform checkingPlatform, Round currentRound) {
		super();
		this.hero = hero;
		this.checkingPlatform = checkingPlatform;
		this.currentRound = currentRound;
	}
	
	@Override
	public void collisionHappened() {
		String word = this.hero.getLettersCollected().toString();
		boolean matchOccured = WordListMatcher.getInstance().match(word);
		this.hero.setHasAMatchingCombination(true);
	}

}
