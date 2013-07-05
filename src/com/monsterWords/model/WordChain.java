package com.monsterWords.model;

import java.util.ArrayList;
import java.util.List;

public class WordChain {

	private List<Letter> letterChain;

	public WordChain() {
		super();
		this.letterChain = new ArrayList<Letter>();
	}

	public List<Letter> getLetterChain() {
		return letterChain;
	}

	public void setLetterChain(List<Letter> letterChain) {
		this.letterChain = letterChain;
	}

	public void addLetter(Letter letter) {
		this.letterChain.add(letter);
	}

	public String toString() {
		String word = "";
		for (Letter letter : letterChain) {
			word += letter.getLetter();
		}
		return word;
	}
}
