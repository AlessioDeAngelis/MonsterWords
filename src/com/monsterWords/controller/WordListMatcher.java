package com.monsterWords.controller;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.monsterWords.utils.Constants;

public class WordListMatcher {

	private List<String> allWords;

	// Private constructor prevents instantiation from other classes
	private WordListMatcher() {
		this.allWords = parse(null);
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final WordListMatcher INSTANCE = new WordListMatcher();
	}

	public static WordListMatcher getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public List<String> parse(String txtPath) {
		List<String> words = new ArrayList<String>();
		FileHandle file = Gdx.files.internal(Constants.ENGLISH_WORD_LIST_PATH);
		String stringa = file.readString();// read the string
		String[] splits = stringa.split("\n");
		for (int i = 0; i < splits.length; i++) {
			words.add(splits[i].trim());
		}
		return words;
	}
	
	public boolean match(String word){
		return this.allWords.contains(word);
	}
}
