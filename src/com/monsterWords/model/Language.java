package com.monsterWords.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Language {
	/**
	 * Letters available in the language, following a certain distribution
	 * **/
	private List<Letter> lettersAvailable;
	/**
	 * Dictionary of all the correct terms of the language
	 * */
	private List<String> dictionary;
	private String dictionaryPath;

	public Language() {
		this.lettersAvailable = new ArrayList<Letter>();
		this.dictionary = new ArrayList<String>();
		this.dictionaryPath = "";
	}

	public List<Letter> getLettersAvailable() {
		return lettersAvailable;
	}

	public void setLettersAvailable(List<Letter> lettersAvailable) {
		this.lettersAvailable = lettersAvailable;
	}

	public List<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(List<String> dictionary) {
		this.dictionary = dictionary;
	}

	public String getDictionaryPath() {
		return dictionaryPath;
	}

	public void setDictionaryPath(String dictionaryPath) {
		this.dictionaryPath = dictionaryPath;
	}

	public void shuffleLetters() {
		Collections.shuffle(this.lettersAvailable);
	}
}
