package com.monsterWords.model;

import com.monsterWords.utils.*;

public class Timer {
	private float timeLeft;

	public Timer() {
		this.timeLeft = Constants.TIME_OF_A_GAME;
	}

	public float getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(float timeLeft) {
		this.timeLeft = timeLeft;
	}

	public void update(float dt) {
		this.timeLeft -= dt;
	}

	public boolean isTimeOver() {
		return this.timeLeft <= 0;
	}
}
