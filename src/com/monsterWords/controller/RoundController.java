package com.monsterWords.controller;

import aurelienribon.tweenengine.Tween;
import aurelienribon.tweenengine.TweenManager;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.controller.languages.LanguageController;
import com.monsterWords.model.AnimatedScore;
import com.monsterWords.model.CheckingPlatform;
import com.monsterWords.model.CheckingPlatform.PlatformState;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Monster;
import com.monsterWords.model.Round;
import com.monsterWords.model.Wall;
import com.monsterWords.model.WordChain;
import com.monsterWords.model.hero.Hero;
import com.monsterWords.utils.Constants;
import com.monsterWords.view.MusicPlayer;

public class RoundController {
	private Round round;
	private static final float WORLD_SCALE = Constants.WORLD_SCALE;
	private ScoreManager scoreManager;
	private LanguageController languageController;
	private HeroController heroController;
	private TweenManager tweenManager;

	public RoundController(Round round, HeroController heroController, LanguageController languageController) {
		super();
		this.round = round;
		this.scoreManager = new ScoreManager();
		this.heroController = heroController;
		this.languageController = languageController;
		// We need a manager to handle every tween.
		Tween.registerAccessor(AnimatedScore.class, new AnimatedScoreAccessor());
		this.tweenManager = new TweenManager();

	}

	public HeroController getHeroController() {
		return heroController;
	}

	public void setHeroController(HeroController heroController) {
		this.heroController = heroController;
	}

	public void populateWorld() {
		setUpBox2D();
	}

	public void setUpBox2D() {
		createHero();
		createLetters(10, false);
		createWalls();
		createPlatform();
		createMonster();
	}

	private void createMonster() {
		// Create our body definition
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		// Set its world position
		bodyDef.position.set(Math.round(Math.random() * 600 + 20) / WORLD_SCALE, Math.round(Math.random() * 440 + 20)
				/ WORLD_SCALE); // Create a body from the defintion and add it
								// to the world
		Body monsterBody = this.round.getBox2DWorld().createBody(bodyDef);

		// Create a polygon shape
		PolygonShape monsterBox = new PolygonShape();
		// Set the polygon shape as a box which is twice the size of our view
		// port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		monsterBox.setAsBox(17 / WORLD_SCALE, 29 / WORLD_SCALE);
		// Create a fixture from our polygon shape and add it to our ground body
		Fixture monsterFixture = monsterBody.createFixture(monsterBox, 0.0f);
		monsterFixture.setRestitution(1f);
		monsterFixture.setDensity(1f);
		monsterFixture.setFriction(0f);
		// Clean up after ourselves
		monsterBox.dispose();
		Monster monster = new Monster();
		monster.setBody(monsterBody);
		// monsterBody.setUserData(monster);//TODO: uncomment it if you need to
		// render it
		this.round.setMonster(monster);
	}

	private void createPlatform() {
		// Create our body definition
		BodyDef platformBodyDef = new BodyDef();
		platformBodyDef.type = BodyType.StaticBody;
		// Set its world position
		platformBodyDef.position.set(new Vector2(Gdx.graphics.getWidth() / 2f / WORLD_SCALE,
				(Gdx.graphics.getHeight() - 100) / 2f / WORLD_SCALE));
		// Create a body from the defintion and add it to the world
		Body platformBody = this.round.getBox2DWorld().createBody(platformBodyDef);
		CheckingPlatform checkingPlatform = new CheckingPlatform();
		platformBody.setUserData(checkingPlatform);// TODO: uncomment it if you
													// need to render it
		checkingPlatform.setBody(platformBody);
		// Create a polygon shape
		PolygonShape platformBox = new PolygonShape();
		// Set the polygon shape as a box which is twice the size of our view
		// port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		platformBox.setAsBox(30 / WORLD_SCALE, 30 / WORLD_SCALE);
		// Create a fixture from our polygon shape and add it to our ground body
		Fixture platformFixture = platformBody.createFixture(platformBox, 0.0f);
		platformFixture.setRestitution(1f);
		platformFixture.setDensity(1f);
		platformFixture.setFriction(0f);
		// Clean up after ourselves
		platformBox.dispose();
		this.round.setCheckingPlatform(checkingPlatform);
	}

	private void createHero() {
		// Create our body definition
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyType.DynamicBody;
		// Set its world position
		bodyDef.position.set(Math.round(200) / WORLD_SCALE, Math.round(200 / WORLD_SCALE)); // Create
																							// a
																							// body
																							// from
																							// the
																							// defintion
																							// and
																							// add
																							// it
																							// to
																							// the
																							// world
		Body heroBody = this.round.getBox2DWorld().createBody(bodyDef);

		// Create a polygon shape
		PolygonShape heroBox = new PolygonShape();
		// Set the polygon shape as a box which is twice the size of our view
		// port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		heroBox.setAsBox(17 / WORLD_SCALE, 29 / WORLD_SCALE);
		// Create a fixture from our polygon shape and add it to our ground body
		Fixture heroFixture = heroBody.createFixture(heroBox, 0.0f);
		heroFixture.setRestitution(1f);
		heroFixture.setDensity(1f);
		heroFixture.setFriction(0f);
		// Clean up after ourselves
		heroBox.dispose();
		Hero hero = new Hero();
		hero.setPosition(200, 200);
		hero.setBody(heroBody);
		heroBody.setUserData(hero);
		this.round.setHero(hero);
	}

	public void createLetters(int numberOfLetters, boolean randomOrder) {
		Array<Letter> letters = this.languageController.giveACombination(numberOfLetters);
		letters.shuffle();
		float circleSpeed = 10;// previous 50
		for (int i = 0; i < numberOfLetters; i++) {
			// First we create a body definition
			BodyDef bodyDef = new BodyDef();
			// We set our body to dynamic, for something like ground which
			// doesnt
			// move we would set it to StaticBody
			bodyDef.type = BodyType.DynamicBody;
			float x = 300;
			float y = 300;
			if (randomOrder) {
				x = Math.round(Math.random() * 500 + 100);
				y = Math.round(Math.random() * 300 + 100);
			}
			// Set our body's starting position in the world
			// float x = Math.round(Math.random() * Gdx.graphics.getWidth()
			// +20);
			// ;
			// float y = Math.round(Math.random() * Gdx.graphics.getHeight()
			// +20-100);
			// float x = Math.round(Math.random() * 600 +100);
			//
			// float y = Math.round(Math.random() * 400 + 100);

			if (this.heroController != null && this.heroController.getHero() != null) {
				while (this.heroController.getHero().getBoundingRectangle().contains(x, y)) { // to
																								// avoid
																								// that
																								// a
																								// letter
																								// collides
																								// with
																								// the
																								// hero
																								// in
																								// the
																								// starting
																								// position
					x = Math.round(Math.random() * 500 + 100);
					y = Math.round(Math.random() * 300 + 100);
				}
			}
			bodyDef.position.set(x / WORLD_SCALE, y / WORLD_SCALE);
			float randomAngle = (float) (2f * Math.random() * Math.PI);
			bodyDef.angle = randomAngle;
			// bodyDef.linearVelocity.set(0, -100000000000f);
			bodyDef.gravityScale = 200000;
			// Create our body in the world using our body definition
			Body body = this.round.getBox2DWorld().createBody(bodyDef);
			float vx = (float) (circleSpeed * Math.cos(randomAngle));
			float vy = (float) (circleSpeed * Math.sin(randomAngle));
			body.setLinearVelocity(vx, vy);
			body.setAngularVelocity(0.2f);// previous 0.5
			Letter letter = letters.get(i);
			body.setUserData(letter);
			// Create a circle shape and set its radius to 6
			CircleShape circle = new CircleShape();
			circle.setRadius(10f / WORLD_SCALE);
			// Create a fixture definition to apply our shape to
			FixtureDef fixtureDef = new FixtureDef();
			fixtureDef.shape = circle;
			fixtureDef.density = 1f;
			fixtureDef.friction = 0f;
			fixtureDef.restitution = 1f; // Make it bounce a little bit
			// Create our fixture and attach it to the body
			Fixture fixture = body.createFixture(fixtureDef);
			// Remember to dispose of any shapes after you're done with them!
			// BodyDef and FixtureDef don't need disposing, but shapes do.
			circle.dispose();

			this.round.addLetter(letter);
		}

	}

	private void createWalls() {
		float tickness = 10f;
		float epsilon = 0.0f;
		addWall(epsilon, epsilon, epsilon, Gdx.graphics.getHeight(), "wallLeft");// left
		addWall(epsilon, Gdx.graphics.getHeight() - epsilon - Constants.TOP_BAR_TICKNESS, Gdx.graphics.getWidth(),
				tickness + Constants.TOP_BAR_TICKNESS, "wallFront");// top
		addWall(Gdx.graphics.getWidth() - epsilon - tickness, epsilon, tickness, Gdx.graphics.getHeight() - epsilon,
				"wallLeft");// right
		addWall(epsilon, epsilon, Gdx.graphics.getWidth(), epsilon, "wallFront");// down

	}

	private void addWall(float px, float py, float width, float height, String type) {
		// Create our body definition
		BodyDef groundBodyDef = new BodyDef();
		// Set its world position
		groundBodyDef.position.set(new Vector2(px / WORLD_SCALE, py / WORLD_SCALE));
		// Create a body from the defintion and add it to the world
		Body groundBody = this.round.getBox2DWorld().createBody(groundBodyDef);

		// Create a polygon shape
		PolygonShape groundBox = new PolygonShape();
		// Set the polygon shape as a box which is twice the size of our view
		// port and 20 high
		// (setAsBox takes half-width and half-height as arguments)
		groundBox.setAsBox(width / WORLD_SCALE, height / WORLD_SCALE);
		// Create a fixture from our polygon shape and add it to our ground body
		Fixture groundFixture = groundBody.createFixture(groundBox, 0.0f);
		groundFixture.setRestitution(1f);
		groundFixture.setDensity(1f);
		groundFixture.setFriction(0f);
		// Clean up after ourselves
		groundBox.dispose();
		Wall wall = new Wall();
		wall.setType(type);
		groundBody.setUserData(wall);
		wall.setBody(groundBody);
	}

	/*
	 * Here there is the game loop 1)box2d world is simulated 2)the sprite
	 * world(round) is update 3)check if the hero has a winning combination
	 * 4)have always 10 letters in the ground after the checking
	 */
	public void update(float delta) {
		this.round.getBox2DWorld().step(1 / 60f, 6, 2);
		this.round.update(delta);
		Hero hero = this.heroController.getHero();
		if (hero.isOnPlatform()) {
			WordChain word = hero.getLettersCollected();
			boolean matchOccurred = languageController.match(word.convertToString());
			// this.round.getCheckingPlatform().setWordMatchFound(matchOccurred);
			if (matchOccurred) {
				int wordScore = this.scoreManager.score(word);
				hero.addScoreToTotal(wordScore);
				hero.getLastScoreEarned().setValue(wordScore);
				hero.getLastScoreEarned().setStartTweening(true);
				startTweeningTheScore(hero.getLastScoreEarned());
				this.round.getCheckingPlatform().setWordMatchFound(true);
				this.round.getCheckingPlatform().setCurrentState(PlatformState.OK);
				MusicPlayer.getInstance().playSoundCorrect();
			} else {
				MusicPlayer.getInstance().playSoundWrong();
				this.round.getCheckingPlatform().setWordMatchFound(false);
				this.round.getCheckingPlatform().setCurrentState(PlatformState.WRONG);
			}
			int numberOfLettersToAdd = 10 - this.round.getLettersOnTheTable().size();
			if (numberOfLettersToAdd > 0) {
				createLetters(numberOfLettersToAdd, true);

			}
			hero.reset();
		}
		this.tweenManager.update(delta);
	}

	private void startTweeningTheScore(AnimatedScore animatedScore) {
//		// position_xy
//
//
//		Tween.to(animatedScore, 3, 2.0f).target(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2)
//				.ease(Back.INOUT).start(tweenManager);
		//alpha
		Tween.set(animatedScore, AnimatedScoreAccessor.ALPHA).target(0).start(tweenManager);
//        Tween.to(animatedScore, AnimatedScoreAccessor.ALPHA, 1.5f).target(1).repeatYoyo(1, .5f).start(tweenManager);
        Tween myTween = Tween.to(animatedScore, AnimatedScoreAccessor.ALPHA, 1.5f).target(1).start(tweenManager);
        if(myTween.isFinished()){
        	this.heroController.getHero().getLastScoreEarned().setStartTweening(false);
        	Color color = this.heroController.getHero().getLastScoreEarned().getColor();
        	color.a = 1;
        	this.heroController.getHero().getLastScoreEarned().setColor(color);
        }

	}

	public boolean isGameOver() {
		return this.round.isRoundOver();
	}

}
