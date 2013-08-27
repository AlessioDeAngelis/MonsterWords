package com.monsterWords.controller.factories;

import com.monsterWords.model.CheckingPlatform;
import com.monsterWords.model.Entity;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Monster;
import com.monsterWords.model.Round;
import com.monsterWords.model.couples.CoupleOfEntities;
import com.monsterWords.model.couples.EntityEntityCouple;
import com.monsterWords.model.couples.HeroLetterCouple;
import com.monsterWords.model.couples.HeroMonsterCouple;
import com.monsterWords.model.couples.HeroPlatformCouple;
import com.monsterWords.model.couples.LetterLetterCouple;
import com.monsterWords.model.hero.Hero;
import com.monsterWords.view.MusicPlayer;

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

	public CoupleOfEntities createCoupleOfEntities(Entity e1, Entity e2, Round currentRound) {
		Class<? extends Entity> e1Clazz = e1.getClass();
		Class<? extends Entity> e2Clazz = e2.getClass();
		CoupleOfEntities entities = new EntityEntityCouple();
		if (Letter.class.isAssignableFrom(e1Clazz)) {
			if (Letter.class.isAssignableFrom(e2Clazz)) {
				entities = new LetterLetterCouple();
			} else if (Hero.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroLetterCouple((Hero) e1, (Letter) e2, currentRound);
			}
		} else if (Hero.class.isAssignableFrom(e1Clazz)) {
			if (Letter.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroLetterCouple((Hero) e1, (Letter) e2, currentRound);
			} else if (CheckingPlatform.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroPlatformCouple((Hero) e1, (CheckingPlatform) e2, currentRound);
			} else if (Monster.class.isAssignableFrom(e2Clazz)) {
				entities = new HeroMonsterCouple((Hero) e1, (Monster) e2, currentRound);
			} else if (CheckingPlatform.class.isAssignableFrom(e1Clazz)) {
				if (Hero.class.isAssignableFrom(e2Clazz)) {
					entities = new HeroPlatformCouple((Hero) e2, (CheckingPlatform) e1, currentRound);
				}
			} else if (Monster.class.isAssignableFrom(e1Clazz)) {
				if (Hero.class.isAssignableFrom(e2Clazz)) {
					entities = new HeroMonsterCouple((Hero) e2, (Monster) e1, currentRound);
				}
			}
		}
		return entities;
	}

}