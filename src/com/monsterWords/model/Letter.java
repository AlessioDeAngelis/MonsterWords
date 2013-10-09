package com.monsterWords.model;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.physics.box2d.Body;
import com.monsterWords.utils.Constants;

public class Letter extends Entity {

	private char letter;
	private float id;
	private boolean canBeCaptured;// the letter will not be captured as soon as
									// it enters the game
	private float timeElapsed;

	public Letter() {
		Random random = new Random();
		int asciiValue = random.nextInt(26) + 97;
		this.letter = (char) asciiValue;
		this.timeElapsed = 0;
	}

	public Letter(char letter, float id) {
		this.letter = letter;
		this.id = id;
		this.timeElapsed = 0;
	}

	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public float getId() {
		return id;
	}

	public void setId(float id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(id);
		result = prime * result + letter;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Letter other = (Letter) obj;
		if (Float.floatToIntBits(id) != Float.floatToIntBits(other.id))
			return false;
		if (letter != other.letter)
			return false;
		return true;
	}

	@Override
	public void collisionHappened() {

	}

	@Override
	public String getTextureName() {
		return "" + this.letter;
	}

	public void update(float dt) {
		this.timeElapsed += dt;
		if (timeElapsed > 1) {
			this.canBeCaptured = true;
		}
		if (this.getBody() != null) {
			Body body = this.getBody();
			if (body.getPosition().x < 0 || body.getPosition().y < 0
					|| body.getPosition().x > Gdx.graphics.getWidth() / Constants.WORLD_SCALE
					|| body.getPosition().y > Gdx.graphics.getHeight() / Constants.WORLD_SCALE) {
				body.setTransform(10 / Constants.WORLD_SCALE, 10 / Constants.WORLD_SCALE, body.getAngle());
			}
		}
	}
}
