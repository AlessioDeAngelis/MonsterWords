package com.monsterWords.controller;

import com.monsterWords.model.WordChain;

public class ScoreManager {
	public int score(WordChain word) {
		int score = 0;
		int size = word.getLetterChain().size;
;
		if(size <= 3){
			score += size; 
		}else if(size ==4){
			score += 5;
		}else if(size ==5){
			score += 7;
		}else if(size == 6){
			score += 10;
		}else{
			score += 15;
		}
		return score;
	}
}
