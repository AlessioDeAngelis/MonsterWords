package com.monsterWords.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.monsterWords.listeners.CollisionListener;
import com.monsterWords.model.hero.Hero;

public class Round {
	private World box2DWorld;
	private List<Letter> lettersOnTheTable;
	private Hero hero;
	private Monster monster;

	public Round() {
		super();
		this.hero = new Hero();
		this.box2DWorld = new World(new Vector2(0, 0), true);
		this.box2DWorld.setContactListener(new CollisionListener(this));
		this.lettersOnTheTable = new ArrayList<Letter>();
		this.monster = new Monster();
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
	
	public void addLetter(Letter letter) {
		this.lettersOnTheTable.add(letter);
	}	
	
	public void removeLetter(Letter letter){
		this.lettersOnTheTable.remove(letter);
	}
	
	public void update(float dt){
		hero.update(dt);
		monster.update(dt);
		checkForBodiesToDelete();
	}


	private void checkForBodiesToDelete() {
		Iterator<Body> i = this.box2DWorld.getBodies();
		Body node=i.next();
		while (i.hasNext()) {
		    Body oBj=node;
		    node=i.next();
		    Entity data = (Entity) oBj.getUserData();
		    if(data!=null &&  data.isFlaggedForDelete()){
		        this.box2DWorld.destroyBody(oBj);             
		    }
		}		
	}

}
