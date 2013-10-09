package com.monsterWords.model.button;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Sprite;

public abstract class GameButton extends Sprite {
	private Game game;
	private String name;
	private boolean active;

	public GameButton(Game game, float x, float y, float width, float height) {
		super();
		this.game = game;
		this.name = "";
		this.setBounds(x, y, width, height);
		this.setPosition(x, y);
		this.setActive(true);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public abstract void executeAction();

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
