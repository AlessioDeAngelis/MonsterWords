package com.monsterWords.model.hero;

import com.badlogic.gdx.Gdx;

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
		int index = frameNumber % frameNames.length;
		this.setFrameName(this.frameNames[index]);
		timeElapsed += dt;
		if (timeElapsed > 0.1f) {//0.1 for desktop, dekstop less, like 0.05
			frameNumber++;
			timeElapsed = 0;
		}
	}
}
