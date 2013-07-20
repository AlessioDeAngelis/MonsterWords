package com.monsterWords.model;

public class CheckingPlatform extends Entity{
	
	private enum PlatformState{NORMAL,OK,WRONG};
	private PlatformState currentState;
	private boolean heroOnPlatform;
	private boolean wordMatchFound;
	private float timeElapsed;
	
	public CheckingPlatform(){
		this.currentState = PlatformState.NORMAL;
		this.heroOnPlatform = false;
		this.wordMatchFound = false;
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
	public void update(float dt){
		if(heroOnPlatform){
			if(wordMatchFound){
				currentState = PlatformState.OK;
			}else{
				currentState = PlatformState.WRONG;
			}
			heroOnPlatform = false;
			wordMatchFound = false;
		}
		
		if(currentState != PlatformState.NORMAL){
			timeElapsed += dt;
			if(timeElapsed > 1.5f){
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
		return "platform"+currentState.toString();
	}

}
