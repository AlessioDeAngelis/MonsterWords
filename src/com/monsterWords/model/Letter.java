package com.monsterWords.model;

import java.util.Random;

public class Letter extends Entity {

	private char letter;
	private float id;

	public Letter() {
		Random random = new Random();
		int asciiValue = random.nextInt(26) + 97;
		this.letter = (char) asciiValue;
	}
	
	public Letter(char letter, float id){
		this.letter = letter;
		this.id = id;
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
}
