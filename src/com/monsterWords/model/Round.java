package com.monsterWords.model;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.listeners.CollisionListener;
import com.monsterWords.model.hero.Hero;
import com.monsterWords.view.MusicPlayer;

public class Round {
	private World box2DWorld;
	private List<Letter> lettersOnTheTable;
	private Hero hero;
	private Monster monster;
	private CheckingPlatform checkingPlatform;
	private Timer timer;

	public Round() {
		super();
		this.hero = new Hero();
		this.timer = new Timer();
		this.box2DWorld = new World(new Vector2(0, 0), true);
		this.box2DWorld.setContactListener(new CollisionListener(this));
		this.lettersOnTheTable = new ArrayList<Letter>();
		this.monster = new Monster();
		this.checkingPlatform = new CheckingPlatform();
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
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

	public Timer getTimer() {
		return timer;
	}

	public void setTimer(Timer timer) {
		this.timer = timer;
	}

	public CheckingPlatform getCheckingPlatform() {
		return checkingPlatform;
	}

	public void setCheckingPlatform(CheckingPlatform checkingPlatform) {
		this.checkingPlatform = checkingPlatform;
	}

	public void addLetter(Letter letter) {
		this.lettersOnTheTable.add(letter);
	}

	public void removeLetter(Letter letter) {
		letter.setFlaggedForDelete(true);
		this.lettersOnTheTable.remove(letter);
	}
	
	public void clearTable(){
		for(Letter letter : this.lettersOnTheTable){
			letter.setFlaggedForDelete(true);
		}
		this.lettersOnTheTable.clear();
	}

	public void update(float dt) {
		hero.update(dt);
		monster.update(dt);
		timer.update(dt);
		checkingPlatform.update(dt);
		checkForBodiesToDelete();
	}

	private void checkForBodiesToDelete() {
		Array<Body> bodies = new Array<Body>();
		this.box2DWorld.getBodies(bodies);
		for (Body body : bodies) {
			Entity data = (Entity) body.getUserData();
			if (data != null && data.isFlaggedForDelete()) {
				this.box2DWorld.destroyBody(body);
			}
		}
	}

	public boolean isRoundOver() {
		return this.timer.isTimeOver();
	}

}
