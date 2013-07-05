package com.monsterWords.controller.factories;

import com.monsterWords.model.Entity;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Round;
import com.monsterWords.model.couples.CoupleOfEntities;
import com.monsterWords.model.couples.HeroLetterCouple;
import com.monsterWords.model.couples.LetterLetterCouple;

public class CoupleOfEntitiesFactory {

	// Private constructor prevents instantiation from other classes
	private CoupleOfEntitiesFactory() {
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final CoupleOfEntitiesFactory INSTANCE = new CoupleOfEntitiesFactory();
	}

	public static CoupleOfEntitiesFactory getInstance() {
		return SingletonHolder.INSTANCE;
	}

	public CoupleOfEntities createCoupleOfEntities(Entity e1, Entity e2,Round currentRound) {
		Class<? extends Entity> e1Clazz = e1.getClass();
		Class<? extends Entity> e2Clazz = e2.getClass();
		CoupleOfEntities entities = null;
		if (Letter.class.isAssignableFrom(e1Clazz)) {
			if (Letter.class.isAssignableFrom(e2Clazz)) {
				entities = new LetterLetterCouple();
			} else if (Hero.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroLetterCouple((Hero) e1, (Letter) e2, currentRound);
			}
		} else if (Hero.class.isAssignableFrom(e1Clazz)) {
			if (Letter.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroLetterCouple((Hero) e1, (Letter) e2,currentRound);
			}
			// else if (GameMap.class.isAssignableFrom(e1Clazz)) {
			// entities = new WeaponGameMap((Weapon) e2, (GameMap) e1);
			// }
			// } else if (GameMap.class.isAssignableFrom(e2Clazz)
			// && GameCharacter.class.isAssignableFrom(e1Clazz)) {
			// entities = new CharacterGameMap((GameCharacter) e1, (GameMap)
			// e2);
			// } else if (GameMap.class.isAssignableFrom(e1Clazz)
			// && GameCharacter.class.isAssignableFrom(e2Clazz)) {
			// entities = new CharacterGameMap((GameCharacter) e2, (GameMap)
			// e1);
		}
		return entities;
	}

}