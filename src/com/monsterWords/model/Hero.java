package com.monsterWords.model;

public class Hero extends Entity {

	private float speedX;
	private char letter;

	public Hero() {
		super();
		this.setSpeedX(2.0f);
		this.letter = 'a';
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public float getSpeedX() {
		return speedX;
	}

	public void setSpeedX(float speedX) {
		this.speedX = speedX;
	}

	@Override
	public void collisionHappened() {
		
	}
}
