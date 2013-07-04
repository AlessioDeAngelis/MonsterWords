package com.monsterWords.model;

import java.util.List;

public class WordChain {

	private List<Letter> letterChain;

	public WordChain(List<Letter> letterChain) {
		super();
		this.letterChain = letterChain;
	}
	
	public void addLetter(Letter letter){
		this.letterChain.add(letter);
	}
	
	public String toString(){
		String word = "";
		for(Letter letter : letterChain){
			word += letter.getLetter();
		}
		return word;
	}
}
