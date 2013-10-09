package com.monsterWords.model;

import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * This score will be animated with the universal tween engine
 * **/
public class AnimatedScore extends Sprite{
	private float x, y;
	private int value;
	private boolean startTweening;

	public AnimatedScore() {
		x = 0;
		y = 0;
		value = 0;
		startTweening = false;
	}

	public AnimatedScore(float x, float y, int value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
		this.startTweening = false;
	}

	public boolean isStartTweening() {
		return startTweening;
	}

	public void setStartTweening(boolean startTweening) {
		this.startTweening = startTweening;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

}
