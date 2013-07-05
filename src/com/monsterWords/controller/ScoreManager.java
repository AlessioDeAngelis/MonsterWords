package com.monsterWords.controller;

import com.monsterWords.model.WordChain;

public class ScoreManager {
	public int score(WordChain word) {
		int score = 0;
		score = word.getLetterChain().size();
		return score;
	}
}
