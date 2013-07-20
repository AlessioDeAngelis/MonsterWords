package com.monsterWords.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.languages.LanguageController;

public class WordListParser {

	// Private constructor prevents instantiation from other classes
	private WordListParser() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final WordListParser INSTANCE = new WordListParser();
	}

	public static WordListParser getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public Array<String> parse(LanguageController languageController) {
		Array<String> words = new Array<String>();
		FileHandle file = Gdx.files.internal(languageController.getLanguage().getDictionaryPath());
		String stringa = file.readString();// read the string
		String[] splits = stringa.split("\n");
		for (int i = 0; i < splits.length; i++) {
			words.add(splits[i].trim());
		}
		languageController.getLanguage().setDictionary(words);
		return words;
	}	

}
