package com.monsterWords.model.couples;

import com.monsterWords.model.CheckingPlatform;
import com.monsterWords.model.Round;
import com.monsterWords.model.hero.Hero;

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
		this.hero.setOnPlatform(true);
	}

}
