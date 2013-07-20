package com.monsterWords.model;

import com.badlogic.gdx.utils.Array;

public class Language {
	/**
	 * Letters available in the language, following a certain distribution
	 * **/
	private Array<Letter> lettersAvailable;
	/**
	 * Dictionary of all the correct terms of the language
	 * */
	private Array<String> dictionary;
	private String dictionaryPath;

	public Language() {
		this.lettersAvailable = new Array<Letter>();
		this.dictionary = new Array<String>();
		this.dictionaryPath = "";
	}

	public Array<Letter> getLettersAvailable() {
		return lettersAvailable;
	}

	public void setLettersAvailable(Array<Letter> lettersAvailable) {
		this.lettersAvailable = lettersAvailable;
	}

	public Array<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Array<String> dictionary) {
		this.dictionary = dictionary;
	}

	public String getDictionaryPath() {
		return dictionaryPath;
	}

	public void setDictionaryPath(String dictionaryPath) {
		this.dictionaryPath = dictionaryPath;
	}

	public void shuffleLetters() {
		this.lettersAvailable.shuffle();
	}
}
