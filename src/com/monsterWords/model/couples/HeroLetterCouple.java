package com.monsterWords.model.couples;

import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;

public class HeroLetterCouple implements CoupleOfEntities{

	private Hero hero;
	private Letter letter;
		
	public HeroLetterCouple(Hero hero, Letter letter) {
		super();
		this.hero = hero;
		this.letter = letter;
	}


	@Override
	public void collisionHappened() {
	}

}
