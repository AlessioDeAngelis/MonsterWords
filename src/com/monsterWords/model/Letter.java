package com.monsterWords.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

public class Letter extends Entity{
	
	private char letter;
	public Letter(){
		this.letter = 'a';
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	@Override
	public void collisionHappened() {
		
	}
}
