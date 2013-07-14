package com.monsterWords.model.hero;

public abstract class HeroState {
	private String frameName;

	public HeroState() {
		this.frameName = this.getClass().getSimpleName();
	}
		
	public String getFrameName() {
		return frameName;
	}

	public void setFrameName(String frameName) {
		this.frameName = frameName;
	}

	public abstract void update(float dt);
}
