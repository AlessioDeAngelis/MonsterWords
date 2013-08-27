package com.monsterWords.controller.languages;


import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.WordListParser;
import com.monsterWords.model.Letter;
import com.monsterWords.utils.Constants;

public class NorwegianLanguageController extends LanguageController {

	public NorwegianLanguageController() {
		super();
		initializeLanguage();
	}

	/**
	 * Based on Scrabble letter distribution
	 * */
	@Override
	public void initializeLanguage() {
		Array<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		char[] letterDistribution = new char[] { 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'a', 'a',
				'a', 'a', 'a', 'a', 'a', 'i', 'i', 'i', 'i', 'i', 
				'o', 'o', 'o', 'o', 'n', 'n', 'n', 'n', 'n', 'n', 'r', 'r', 'r', 'r', 'r', 'r', 't', 't', 't', 't',
				't', 't', 'l', 'l', 'l', 'l', 'l', 's', 's', 's', 's', 's','s','u', 'u', 'u', 'd', 'd', 'd', 'd','d', 'g', 'g',
				'g','g', 'b','b',  'b', 'c', 'm', 'm','m', 'p', 'p', 'f', 'f','f', 'f', 'h', 'h','h', 'v', 'v',  'v','w', 'y', 'k','k','k','k',
				'j','j', 'x', 'q', 'z' ,'æ','ø','ø','å' };
		for (int i = 0; i < letterDistribution.length; i++) {
			Random random = new Random();
			Letter letter = new Letter(letterDistribution[i], i + random.nextInt());
			lettersAvailable.add(letter);
		}
		this.getLanguage().setDictionaryPath(Constants.NORWEGIAN_WORD_LIST_PATH);
		WordListParser.getInstance().parse(this);// TODO: think a better way
													// where to put it
	}

}
