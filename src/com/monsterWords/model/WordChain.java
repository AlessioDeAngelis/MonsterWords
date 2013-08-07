package com.monsterWords.model;

import com.badlogic.gdx.utils.Array;

public class WordChain {

	private Array<Letter> letterChain;

	public WordChain() {
		super();
		this.letterChain = new Array<Letter>();
	}

	public Array<Letter> getLetterChain() {
		return letterChain;
	}

	public void setLetterChain(Array<Letter> letterChain) {
		this.letterChain = letterChain;
	}

	public void addLetter(Letter letter) {
		this.letterChain.add(letter);
	}

	public String convertToString() {
		String word = "";
		for (Letter letter : letterChain) {
			word += letter.getLetter();
		}
		return word;
	}
}
