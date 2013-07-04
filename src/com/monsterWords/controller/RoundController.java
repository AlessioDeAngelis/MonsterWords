package com.monsterWords.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.monsterWords.listeners.CollisionListener;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Round;
import com.monsterWords.utils.Constants;

public class RoundController {
	private Round round;
	private static final float WORLD_SCALE = Constants.WORLD_SCALE;

	public RoundController(Round round) {
		super();
		this.round = round;
	}

	public void populateWorld() {
		setUpBox2D();
	}

	public void setUpBox2D() {
		createBalls(10);
		createWalls();
		createHero();
	}

	private void createHero() {
		// Create our body definition
		BodyDef bodyDef = new BodyDef();
//		bodyDef.type = BodyType.StaticBody;
		// Set its world position
		bodyDef.position.set(Math.round(Math.random() * 600 + 20) / WORLD_SCALE,
				Math.round(Math.random() * 440 + 20) / WORLD_SCALE);		// Create a body from the defintion and add it to the world
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
		hero.setBody(heroBody);
		heroBody.setUserData(hero);
		this.round.setHero(hero);
	}

	public void createBalls(int numberOfBalls) {
		float circleSpeed = 50f;
		for (int i = 0; i < numberOfBalls; i++) {
			// First we create a body definition
			BodyDef bodyDef = new BodyDef();
			// We set our body to dynamic, for something like ground which
			// doesnt
			// move we would set it to StaticBody
			bodyDef.type = BodyType.DynamicBody;
			// Set our body's starting position in the world
			bodyDef.position.set(Math.round(Math.random() * 600 + 20) / WORLD_SCALE,
					Math.round(Math.random() * 440 + 20) / WORLD_SCALE);
			float randomAngle = (float) (2f * Math.random() * Math.PI);
			bodyDef.angle = randomAngle;
			// bodyDef.linearVelocity.set(0, -100000000000f);
			bodyDef.gravityScale = 200000;
			// Create our body in the world using our body definition
			Body body = this.round.getBox2DWorld().createBody(bodyDef);
			float vx = (float) (circleSpeed * Math.cos(randomAngle));
			float vy = (float) (circleSpeed * Math.sin(randomAngle));
			body.setLinearVelocity(vx, vy);
			body.setAngularVelocity(0.5f);
			Letter letter = new Letter();
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

	public void createWalls() {
		float tickness = 10f;
		float epsilon = 0.1f;
		addWall(epsilon, epsilon, Gdx.graphics.getWidth(), tickness);
		addWall(epsilon, epsilon, tickness, Gdx.graphics.getHeight());
		addWall(epsilon, Gdx.graphics.getHeight() - epsilon, Gdx.graphics.getWidth(), tickness);
		addWall(Gdx.graphics.getWidth() - epsilon, Gdx.graphics.getHeight() - epsilon, tickness,
				Gdx.graphics.getHeight());
	}

	private void addWall(float px, float py, float width, float height) {
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
	}

	public void update(float delta) {
		this.round.update(delta);
		this.round.getBox2DWorld().step(1 / 60f, 6, 2);
	}

}
