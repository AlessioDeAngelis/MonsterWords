package com.monsterWords.view;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.monsterWords.model.Hero;
import com.monsterWords.model.Letter;
import com.monsterWords.model.Round;
import com.monsterWords.utils.Constants;

public class RoundView {
	private static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
	private static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();
	private static final float WORLD_SCALE = Constants.WORLD_SCALE;

	private OrthographicCamera cam;

	private ShapeRenderer shapeRenderer;
	private Box2DDebugRenderer debugRenderer;

	/** Textures **/
	private Texture textureLetter,textureHero;

	private SpriteBatch spriteBatch;
	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis

	private Round round;

	public RoundView(Round round) {
		this.round = round;
		this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
		this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
		this.cam.update();
		this.ppuX = 10 / CAMERA_WIDTH;
		this.ppuY = 10 / CAMERA_WIDTH;
		spriteBatch = new SpriteBatch();
		this.shapeRenderer = new ShapeRenderer();
		loadTextures();
		this.debugRenderer = new Box2DDebugRenderer();
	}

	/*
	 * Converts from world coordinates to screen coordinates *
	 */
	public void setSize(int w, int h) {
		this.width = w;
		this.height = h;
		ppuX = width / CAMERA_WIDTH;
		ppuY = height / CAMERA_HEIGHT;
	}

	private void loadTextures() {
		textureLetter = new Texture(Gdx.files.internal("letters/a.png"));
		textureHero = new Texture(Gdx.files.internal("model/hero.png"));
	}

	public void render() {
		// debugRenderer.render(jungleWorld.getWorld(),
		// cam.combined);//uncomment if you want to debug box2d objects
		spriteBatch.begin();
		if (this.round != null) {
			Iterator<Body> bodies = this.round.getBox2DWorld().getBodies();
			while (bodies.hasNext()) {
				Body body = bodies.next();
				Object userData = body.getUserData();
				if (userData != null
						&& Letter.class.isAssignableFrom(userData.getClass())) {					
					Sprite letterSprite = new Sprite(textureLetter);
//					letterSprite.setSize(10*WORLD_SCALE, 10*WORLD_SCALE);
					letterSprite.setX( body.getPosition().x
							* WORLD_SCALE);
					letterSprite.setY(body.getPosition().y * WORLD_SCALE);
					letterSprite.setRotation((float)Math.toDegrees(body.getAngle()));
					letterSprite.draw(spriteBatch);
//					spriteBatch.draw(textureLetter, body.getPosition().x
//							* WORLD_SCALE, body.getPosition().y * WORLD_SCALE);
				}
				if (userData != null
						&& Hero.class.isAssignableFrom(userData.getClass())) {					
					Sprite heroSprite = new Sprite(textureHero);
//					letterSprite.setSize(10*WORLD_SCALE, 10*WORLD_SCALE);
					heroSprite.setX( body.getPosition().x
							* WORLD_SCALE);
					heroSprite.setY(body.getPosition().y * WORLD_SCALE);
					heroSprite.draw(spriteBatch);
				}
			}
		}
		spriteBatch.end();
		this.debugRenderer.render(this.round.getBox2DWorld(), cam.combined);
		this.debugRenderer.setDrawVelocities(true);
	}
}
