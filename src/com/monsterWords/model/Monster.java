package com.monsterWords.model;

import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.utils.Constants;

public class Monster extends Entity {
	//TODO: implement movement
	private float speedValue;

	public Monster() {
		this.speedValue = 50;
	}

	public float getSpeedValue() {
		return speedValue;
	}

	public void setSpeedValue(float speedValue) {
		this.speedValue = speedValue;
	}

	@Override
	public void collisionHappened() {

	}

	public void update(float dt) {
		Body body = this.getBody();
		if (body != null) {
			float bodyX = this.getX() / Constants.WORLD_SCALE;
			float bodyY = this.getY() / Constants.WORLD_SCALE;
			body.setTransform(bodyX, bodyY, body.getAngle());
		}
	}

}
