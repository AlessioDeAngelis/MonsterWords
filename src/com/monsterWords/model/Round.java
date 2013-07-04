package com.monsterWords.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Round {
	private World box2DWorld;
	private List<Letter> lettersOnTheTable;
	private Hero hero;

	public Round() {
		super();
		this.hero = new Hero();
		this.box2DWorld = new World(new Vector2(0, 0), true);
		this.lettersOnTheTable = new ArrayList<Letter>();
	}

	public void addLetter(Letter letter) {
		this.lettersOnTheTable.add(letter);
	}

	public World getBox2DWorld() {
		return box2DWorld;
	}

	public void setBox2DWorld(World box2dWorld) {
		box2DWorld = box2dWorld;
	}

	public List<Letter> getLettersOnTheTable() {
		return lettersOnTheTable;
	}

	public void setLettersOnTheTable(List<Letter> lettersOnTheTable) {
		this.lettersOnTheTable = lettersOnTheTable;
	}

	public Hero getHero() {
		return hero;
	}

	public void setHero(Hero hero) {
		this.hero = hero;
	}

}
