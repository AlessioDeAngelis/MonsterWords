package com.monsterWords.model;

public class CheckingPlatform extends Entity {

	public enum PlatformState {//TODO: was private
		NORMAL, OK, WRONG
	};

	private PlatformState currentState;
	private boolean heroOnPlatform;
	private boolean wordMatchFound;
	private float timeElapsed;

	public CheckingPlatform() {
		this.currentState = PlatformState.NORMAL;
		this.heroOnPlatform = false;
		this.wordMatchFound = true;
		this.timeElapsed = 0;
	}

	public boolean isHeroOnPlatform() {
		return heroOnPlatform;
	}

	public void setHeroOnPlatform(boolean heroOnPlatform) {
		this.heroOnPlatform = heroOnPlatform;
	}

	public boolean isWordMatchFound() {
		return wordMatchFound;
	}

	public void setWordMatchFound(boolean wordMatchFound) {
		this.wordMatchFound = wordMatchFound;
	}

	@Override
	public void update(float dt) {
		if (heroOnPlatform) {
			if (wordMatchFound) {
				currentState = PlatformState.OK;
			} else {
				currentState = PlatformState.WRONG;
			}
			heroOnPlatform = false;
			wordMatchFound = false;
		} else
//		System.out.println(currentState);
		if (currentState != PlatformState.NORMAL) {
			timeElapsed += dt;
			if (timeElapsed >= 1.5f) {
				currentState = PlatformState.NORMAL;
				timeElapsed = 0f;
			}
		}
	}

	@Override
	public void collisionHappened() {

	}

	@Override
	public String getTextureName() {
		if (currentState != PlatformState.NORMAL) {
//			System.out.println("platform" + currentState.toString());
		}
		return "platform" + currentState.toString();
	}
	
	public void setCurrentState(PlatformState state){
		this.currentState = state;
	}

}
