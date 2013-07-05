package com.monsterWords.model;

public class Letter extends Entity{
	
	//TODO: implement hash code and equals for the correct remove
	private char letter;
	private float id;
	public Letter(){
		this.letter = 'a';
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
