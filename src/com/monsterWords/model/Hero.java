package com.monsterWords.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.utils.Constants;

public class Hero extends Entity {

	private float speedValue;
	private char letter;

	public Hero() {
		super();
		this.setSpeedValue(20f);
		this.letter = 'a';
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
