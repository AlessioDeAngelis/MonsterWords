package com.monsterWords.model.hero;

import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.model.Entity;
import com.monsterWords.model.WordChain;
import com.monsterWords.utils.Constants;

public class Hero extends Entity {

	private float speedValue;
	private WordChain lettersCollected;
	private boolean isOnPlatform;
	private int totalScore;
	private HeroState state;

	public Hero() {
		super();
		this.setSpeedValue(5f);
		this.lettersCollected = new WordChain();
		this.isOnPlatform = false;
		this.totalScore = 0;
		this.state = new MoveRight();
	}

	public HeroState getState() {
		return state;
	}

	public void setState(HeroState currentState) {
		this.state = currentState;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}	

	public boolean isOnPlatform() {
		return isOnPlatform;
	}

	public void setOnPlatform(boolean isOnPlatform) {
		this.isOnPlatform = isOnPlatform;
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
		this.state.update(dt);
	}
	
	public void addScore(int score){
		this.totalScore += score;
	}
	
	public void reset(){
		this.lettersCollected = new WordChain();
		this.isOnPlatform = false;
	}
}
