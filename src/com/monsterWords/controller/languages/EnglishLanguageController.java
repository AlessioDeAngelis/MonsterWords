package com.monsterWords.controller.languages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.monsterWords.controller.WordListParser;
import com.monsterWords.model.Letter;
import com.monsterWords.utils.Constants;

public class EnglishLanguageController extends LanguageController {

	public EnglishLanguageController() {
		super();
		initializeLanguage();
	}

	/**
	 * Based on Scrabble letter distribution
	 * */
	@Override
	public void initializeLanguage() {
		List<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		char[] letterDistribution = new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'a', 'a',
				'a', 'a', 'a', 'a', 'a', 'a', 'a', 'i', 'i', 'i', 'i', 'i', 'i', 'i', 'i', 'i', 'o', 'o', 'o', 'o',
				'o', 'o', 'o', 'o', 'n', 'n', 'n', 'n', 'n', 'n', 'r', 'r', 'r', 'r', 'r', 'r', 't', 't', 't', 't',
				't', 't', 'l', 'l', 'l', 'l', 's', 's', 's', 's', 'u', 'u', 'u', 'u','d','d','d','d','g','g','g','b','b','c','c','m','m','p','p','f','f','h','h','v','v','w','w','y','y','k','j','x','q','z'};
		for(int i =0; i<letterDistribution.length;i++){
			Random random = new Random();
			Letter letter = new Letter(letterDistribution[i],i+random.nextInt());
			lettersAvailable.add(letter);
		}
		this.getLanguage().setDictionaryPath(Constants.ENGLISH_WORD_LIST_PATH);
		WordListParser.getInstance().parse(this);//TODO: think a better way where to put it
	}

	@Override
	public List<Letter> giveACombination(float numberOfLetters) {
		List<Letter> combination = new ArrayList<Letter>();
		List<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		Collections.shuffle(lettersAvailable);
		for(int i = 0; i< numberOfLetters; i++){
			combination.add(lettersAvailable.get(i));
		}
		return combination;
	}

}
