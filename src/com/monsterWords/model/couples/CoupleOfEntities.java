package com.monsterWords.model.couples;

/**
 * Used for managing the interaction among couples of entities after the
 * collision It is open for new interaction with new entities.
 * */
public interface CoupleOfEntities {
	public void collisionHappened();
}