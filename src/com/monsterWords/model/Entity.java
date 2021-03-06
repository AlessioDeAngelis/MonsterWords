package com.monsterWords.model;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Each model class that is subject to collision must extend this class
 * **/
public abstract class Entity extends Sprite {

	private Body body;
	private boolean flaggedForDelete;

	public Entity() {
		super();
		this.setBody(null);
		this.flaggedForDelete = false;
	}

	public Body getBody() {
		return body;
	}

	public void setBody(Body body) {
		this.body = body;
	}

	public boolean isFlaggedForDelete() {
		return flaggedForDelete;
	}

	public void setFlaggedForDelete(boolean flaggedForDelete) {
		this.flaggedForDelete = flaggedForDelete;
	}

	/**
	 * This method will be overrided from all the class that extend entity. It
	 * contains the code that will be triggered when the first collision happens
	 * and modifies something in the entity. If the collision doesn't make any
	 * effect on the entity, this method can be kept empty.
	 * **/
	public abstract void collisionHappened();

	public abstract String getTextureName();
	
	public void update(float dt) {
		
	}
}