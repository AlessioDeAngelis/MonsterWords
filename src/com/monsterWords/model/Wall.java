package com.monsterWords.model;

public class Wall extends Entity {
	public String type;

	public Wall() {
		super();
		this.type = "";
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public void collisionHappened() {

	}

	@Override
	public String getTextureName() {
		return "wall";
	}

}
