package com.monsterWords.model.couples;

import com.badlogic.gdx.physics.box2d.World;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Round;

public class HeroLetterCouple implements CoupleOfEntities {

	private Hero hero;
	private Letter letter;
	private Round currentRound;

	public HeroLetterCouple(Hero hero, Letter letter, Round currentRound) {
		super();
		this.hero = hero;
		this.letter = letter;
		this.currentRound = currentRound;
	}

	@Override
	public void collisionHappened() {
		// the letter touched by the hero is concatenated to form a word
		this.hero.getLettersCollected().addLetter(letter);
		//the letter is removed from the screen, together with the body
		this.letter.setFlaggedForDelete(true);
		this.currentRound.removeLetter(letter);
	}

}
