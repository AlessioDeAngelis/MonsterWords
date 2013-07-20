package com.monsterWords.controller.languages;


import com.badlogic.gdx.utils.Array;
import com.monsterWords.model.Language;
import com.monsterWords.model.Letter;


public abstract class LanguageController {
	private Language language;
	public LanguageController() {
		super();
		this.language = new Language();
//		/**
//		 * The nextId is used to keep track of the id that must be assigned to
//		 * the letter in order to be unique
//		 * */
//		float nextId = 0;
//		for(int i = 97; i < 97 + 26; i++){//i is the ascii value
//			char letter = (char) i;
//			this.getName2Letter().put(letter+"",new Letter(letter,nextId));
//			nextId++;
//		}
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}
	
	public boolean match(String word){
		return this.language.getDictionary().contains(word, false);
	}

	public abstract void initializeLanguage();
	
	public Array<Letter> giveACombination(float numberOfLetters) {
		Array<Letter> combination = new Array<Letter>();
		Array<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		lettersAvailable.shuffle();
		for (int i = 0; i < numberOfLetters; i++) {
			combination.add(lettersAvailable.get(i));
		}
		return combination;
	}

}
