package com.monsterWords.listeners;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.monsterWords.controller.factories.CoupleOfEntitiesFactory;
import com.monsterWords.model.Entity;
import com.monsterWords.model.Round;
import com.monsterWords.model.couples.CoupleOfEntities;

public class CollisionListener implements ContactListener{

	private Round currentRound;
	public CollisionListener(){
		
	}
	public CollisionListener(Round round){
		super();
		this.currentRound = round;
	}
	/**
	 * This is called when two fixtures begin to overlap. This is called for
	 * sensors and non-sensors. This event can only occur inside the time step.
	 * *
	 * **/
	@Override
	public void beginContact(Contact contact) {
		Fixture fixA = contact.getFixtureA();
		Fixture fixB = contact.getFixtureB();
		Body bodyA = fixA.getBody();
		Body bodyB = fixB.getBody();
		Entity entityA = null;
		Entity entityB = null;
		//checks if the userdata is a class that extends Entity. Is not really needed, is just for lazy programmers :)
		if (bodyA.getUserData() != null && Entity.class.isAssignableFrom(bodyA.getUserData().getClass()) && bodyB.getUserData() != null && Entity.class.isAssignableFrom(bodyB.getUserData().getClass())) { 
			entityA = (Entity) bodyA.getUserData();
			entityB = (Entity) bodyB.getUserData();
			CoupleOfEntities entities = CoupleOfEntitiesFactory.getInstance().createCoupleOfEntities(entityA, entityB,this.currentRound);
			if(entities!=null){
				entities.collisionHappened();
			}
		}

	}


	@Override
	public void endContact(Contact contact) {
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		
	}

}
