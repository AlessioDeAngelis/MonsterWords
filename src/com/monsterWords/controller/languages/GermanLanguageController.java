package com.monsterWords.controller.languages;

import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.WordListParser;
import com.monsterWords.model.Letter;
import com.monsterWords.utils.Constants;

public class GermanLanguageController extends LanguageController {

	public GermanLanguageController() {
		super();
		initializeLanguage();
	}

	/**
	 * Based on Scrabble letter distribution
	 * */
	@Override
	public void initializeLanguage() {
		Array<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		char[] letterDistribution = new char[] { 'a', 'a', 'a', 'a', 'a', 'b', 'b', 'c', 'c', 'd', 'd', 'd', 'd', 'e',
				'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'f', 'f', 'g', 'g', 'g', 'h',
				'h', 'h', 'h', 'i', 'i', 'i', 'i', 'i', 'i', 'l', 'l', 'l', 'j', 'k', 'k', 'm', 'm', 'm', 'm', 'n',
				'n', 'n', 'n', 'n', 'n', 'n', 'n', 'n', 'o', 'o', 'o', 'p', 'q', 'r', 'r', 'r', 'r', 'r', 'r', 's',
				's', 's', 's', 's', 's', 's', 't', 't', 't', 't', 't', 't', 'u', 'u', 'u', 'u', 'u', 'u', 'v', 'w',
				'x', 'y', 'z', 'ö', 'ä', 'ü', 'ß', 'ß'};
		for (int i = 0; i < letterDistribution.length; i++) {
			Random random = new Random();
			Letter letter = new Letter(letterDistribution[i], i + random.nextInt() * random.nextInt()
					* random.nextInt());
			lettersAvailable.add(letter);
		}
		this.getLanguage().setDictionaryPath(Constants.GERMAN_WORD_LIST_PATH);
		WordListParser.getInstance().parse(this);// TODO: think a better way
													// where to put it
	}

}
