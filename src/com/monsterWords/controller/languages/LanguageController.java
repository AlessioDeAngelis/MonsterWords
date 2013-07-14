package com.monsterWords.controller.languages;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.monsterWords.model.Language;
import com.monsterWords.model.Letter;

public abstract class LanguageController {
	private Language language;
	private Map<String, Letter> name2Letter;

	public LanguageController() {
		super();
		this.language = new Language();
		this.name2Letter = new HashMap<String, Letter>();
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

	public Map<String, Letter> getName2Letter() {
		return name2Letter;
	}

	public void setName2Letter(Map<String, Letter> name2Letter) {
		this.name2Letter = name2Letter;
	}
	
	public boolean match(String word){
		return this.language.getDictionary().contains(word);
	}

	public abstract void initializeLanguage();
	public abstract List<Letter> giveACombination(float numberOfLetter);

}
