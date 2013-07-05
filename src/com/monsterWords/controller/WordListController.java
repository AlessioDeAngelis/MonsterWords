package com.monsterWords.controller;

import java.util.List;

public class WordListController {
	public int matches(String word, List<String> wordList) {
		int index = -1;
		if (word != null || wordList != null) {
			for (int i = 0; i < wordList.size(); i++) {
				if (word.equals(wordList.get(i))) {
					index = i;
					break;
				}
			}
		}
		return index;
	}
}
