package com.monsterWords.controller.languages;

import java.util.Random;

import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.WordListParser;
import com.monsterWords.model.Letter;
import com.monsterWords.utils.Constants;

public class SpanishLanguageController extends LanguageController {

	public SpanishLanguageController() {
		super();
		initializeLanguage();
	}

	/**
	 * Based on Scrabble letter distribution
	 * */
	@Override
	public void initializeLanguage() {
		Array<Letter> lettersAvailable = this.getLanguage().getLettersAvailable();
		char[] letterDistribution = new char[] { 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'b', 'b',
				'c', 'c', 'c', 'c', 'd', 'd', 'd', 'd', 'd', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e', 'e',
				'e', 'f', 'g', 'g', 'h', 'h', 'i', 'i', 'i', 'i', 'i', 'i', 'l', 'l', 'l', 'l', 'l', 'j', 'm', 'm',
				'n', 'n', 'n', 'n', 'n', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'p', 'p', 'q', 'r', 'r', 'r',
				'r', 'r', 's', 's', 's', 's', 's', 's', 't', 't', 't', 't', 'u', 'u', 'u', 'u', 'u', 'v', 'x', 'y',
				'z', 'ñ' };
		for (int i = 0; i < letterDistribution.length; i++) {
			Random random = new Random();
			Letter letter = new Letter(letterDistribution[i], i + random.nextInt() * random.nextInt()
					* random.nextInt());
			lettersAvailable.add(letter);
		}
		this.getLanguage().setDictionaryPath(Constants.SPANISH_WORD_LIST_PATH);
		WordListParser.getInstance().parse(this);// TODO: think a better way
													// where to put it
	}

}
