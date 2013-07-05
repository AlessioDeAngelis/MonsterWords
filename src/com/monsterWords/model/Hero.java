package com.monsterWords.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.utils.Constants;

public class Hero extends Entity {

	private float speedValue;
	private char letter;
	private WordChain lettersCollected;
	
	public Hero() {
		super();
		this.setSpeedValue(20f);
		this.letter = 'a';
		this.lettersCollected = new WordChain();
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public float getSpeedValue() {
		return speedValue;
	}

	public void setSpeedValue(float speedX) {
		this.speedValue = speedX;
	}	
	

	public WordChain getLettersCollected() {
		return lettersCollected;
	}

	public void setLettersCollected(WordChain lettersCollected) {
		this.lettersCollected = lettersCollected;
	}

	@Override
	public void collisionHappened() {

	}

	public void update(float dt) {
		Body body = this.getBody();
		if (body != null) {
			float bodyX = this.getX()/Constants.WORLD_SCALE;
			float bodyY = this.getY()/Constants.WORLD_SCALE;
			body.setTransform(bodyX, bodyY, body.getAngle());
		}
	}
}
