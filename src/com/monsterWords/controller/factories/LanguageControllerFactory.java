package com.monsterWords.controller.factories;

import com.monsterWords.controller.languages.EnglishLanguageController;
import com.monsterWords.controller.languages.FrenchLanguageController;
import com.monsterWords.controller.languages.GermanLanguageController;
import com.monsterWords.controller.languages.ItalianLanguageController;
import com.monsterWords.controller.languages.LanguageController;
import com.monsterWords.controller.languages.NorwegianLanguageController;
import com.monsterWords.controller.languages.SpanishLanguageController;

public class LanguageControllerFactory {

	// Private constructor prevents instantiation from other classes
	private LanguageControllerFactory() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final LanguageControllerFactory INSTANCE = new LanguageControllerFactory();
	}

	public static LanguageControllerFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public LanguageController createLanguageController(String languageName) {
		LanguageController languageController = new EnglishLanguageController();
		if (languageName != null) {
			if (languageName.equals("italian")) {
				languageController = new ItalianLanguageController();
			} else if (languageName.equals("norwegian")) {
				languageController = new NorwegianLanguageController();
			} else if (languageName.equals("french")) {
				languageController = new FrenchLanguageController();
			} else if (languageName.equals("spanish")) {
				languageController = new SpanishLanguageController();
			} else if (languageName.equals("german")) {
				languageController = new GermanLanguageController();
			}
		}
		return languageController;
	}

}