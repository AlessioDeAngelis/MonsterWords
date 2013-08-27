package com.monsterWords.model.hero;

public class MoveHeroState extends HeroState {
	private int frameNumber;
	private String[] frameNames;
	private float timeElapsed;

	public MoveHeroState() {
		super();
		this.frameNumber = 0;
		this.timeElapsed = 0;
		this.frameNames = new String[] { "", "", "", "" };
	}

	public String[] getFrameNames() {
		return frameNames;
	}

	public void setFrameNames(String[] frameNames) {
		this.frameNames = frameNames;
	}

	@Override
	public void update(float dt) {
		timeElapsed += dt;
		if (timeElapsed > 0.3f) {//0.1 for desktop, dekstop less, like 0.05
			frameNumber++;
			timeElapsed = 0;
		}		
	}
	
	@Override
	public String getFrameName(){
		return this.frameNames[frameNumber % frameNames.length];
	}
}
