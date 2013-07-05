package com.monsterWords.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.utils.Constants;

public class Hero extends Entity {

	private float speedValue;
	private char letter;
	private WordChain lettersCollected;
	private boolean hasAMatchingCombination;
	private int totalScore;

	public Hero() {
		super();
		this.setSpeedValue(50f);
		this.letter = 'a';
		this.lettersCollected = new WordChain();
		this.hasAMatchingCombination = false;
		this.totalScore = 0;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	public boolean getHasAMatchingCombination() {
		return hasAMatchingCombination;
	}

	public void setHasAMatchingCombination(boolean hasAMatchingCombination) {
		this.hasAMatchingCombination = hasAMatchingCombination;
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

	@Override
	public void update(float dt) {
		Body body = this.getBody();
		if (body != null) {
			float bodyX = this.getX() / Constants.WORLD_SCALE;
			float bodyY = this.getY() / Constants.WORLD_SCALE;
			body.setTransform(bodyX, bodyY, body.getAngle());
		}
	}
	
	public void addScore(int score){
		this.totalScore += score;
	}
	
	public void reset(){
		this.lettersCollected = new WordChain();
	}
}
