package com.monsterWords.model.couples;

import com.monsterWords.model.Monster;
import com.monsterWords.model.Round;
import com.monsterWords.model.hero.Hero;

public class HeroMonsterCouple implements CoupleOfEntities{
	private Hero hero;
	private Monster monster;
	private Round currentRound;

	public HeroMonsterCouple(Hero hero, Monster monster, Round currentRound) {
		super();
		this.hero = hero;
		this.monster = monster;
		this.currentRound = currentRound;
	}
	
	@Override
	public void collisionHappened() {
		//TODO: the hero loses a life or the time is decreased
	}

}
