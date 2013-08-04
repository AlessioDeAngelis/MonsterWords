package com.monsterWords.view;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.model.Entity;
import com.monsterWords.model.Round;
import com.monsterWords.model.Wall;
import com.monsterWords.utils.Constants;

public class RoundView {
	private static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
	private static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();
	private static final float WORLD_SCALE = Constants.WORLD_SCALE;

	private OrthographicCamera cam;

	private ShapeRenderer shapeRenderer;
	private Box2DDebugRenderer debugRenderer;

	/** Textures **/
	private Map<String, Texture> name2texture;
	private SpriteBatch spriteBatch;
	private int width;
	private int height;
	private float ppuX; // pixels per unit on the X axis
	private float ppuY; // pixels per unit on the Y axis

	private Round round;
	private BitmapFont font;

	public RoundView(Round round) {
		this.round = round;
		this.font =  new BitmapFont();
		this.font = new BitmapFont(Gdx.files.internal("fonts/monsterFont.fnt"),
		         Gdx.files.internal("fonts/monsterFont.png"), false);
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
		this.name2texture = new HashMap<String, Texture>();
		/**
		 * Hero states
		 * */
		this.name2texture.put("back", new Texture(Gdx.files.internal("model/hero/back.png")));
		this.name2texture.put("back2", new Texture(Gdx.files.internal("model/hero/back2.png")));
		this.name2texture.put("back4", new Texture(Gdx.files.internal("model/hero/back4.png")));
		this.name2texture.put("front", new Texture(Gdx.files.internal("model/hero/front.png")));
		this.name2texture.put("front2", new Texture(Gdx.files.internal("model/hero/front2.png")));
		this.name2texture.put("front4", new Texture(Gdx.files.internal("model/hero/front4.png")));
		this.name2texture.put("right", new Texture(Gdx.files.internal("model/hero/right.png")));
		this.name2texture.put("right2", new Texture(Gdx.files.internal("model/hero/right2.png")));
		this.name2texture.put("right4", new Texture(Gdx.files.internal("model/hero/right4.png")));
		this.name2texture.put("left", new Texture(Gdx.files.internal("model/hero/left.png")));
		this.name2texture.put("left2", new Texture(Gdx.files.internal("model/hero/left2.png")));
		this.name2texture.put("left4", new Texture(Gdx.files.internal("model/hero/left4.png")));

		// this.name2texture.put("a", new
		// Texture(Gdx.files.internal("letters/a.png")));
		this.name2texture.put("empty",  new Texture(Gdx.files.internal("model/empty.png")));
		/**
		 * Letters
		 * */
		for (int i = 97; i < 97 + 26; i++) {// i is the ascii value
			char letter = (char) i;
			String letterString = "" + letter;
			this.name2texture.put(letterString, new Texture(Gdx.files.internal("letters/" + letterString + ".png")));
		}
		
		/**
		 * Platform
		 * */
		this.name2texture.put("platformNORMAL", new Texture(Gdx.files.internal("model/platform/platformNORMAL.png")));
		this.name2texture.put("platformOK", new Texture(Gdx.files.internal("model/platform/platformOK.png")));
		this.name2texture.put("platformWRONG", new Texture(Gdx.files.internal("model/platform/platformWRONG.png")));


		/**
		 * Walls
		 * */
		// this.name2texture.put("wallLeft", new
		// Texture(Gdx.files.internal("model/wall/wall_left.png")));
		// this.name2texture.put("wallFront", new
		// Texture(Gdx.files.internal("model/wall/wall_front.png")));

		/**
		 * Background
		 * */
		this.name2texture.put("background", new Texture(Gdx.files.internal("model/background.png")));
		this.name2texture.put("bar", new Texture(Gdx.files.internal("model/bar.png")));

		/**
		 * Apply filters
		 * */
		// for(Texture texture : this.name2texture.values()){
		// texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		// }

	}

	public void render() {

		spriteBatch.begin();
		renderBackground();
		renderBar();
		renderBodies();
		renderText();
		spriteBatch.end();
		this.debugRenderer.render(this.round.getBox2DWorld(), cam.combined);
		// this.debugRenderer.setDrawVelocities(true);
	}

	private void renderBar() {
		spriteBatch.draw(this.name2texture.get("bar"),0, Gdx.graphics.getHeight()-Constants.TOP_BAR_TICKNESS);
	}

	private void renderBodies() {
		if (this.round != null) {
			Array<Body> bodies = new Array<Body>();
			this.round.getBox2DWorld().getBodies(bodies);
			for (Body body : bodies) {
				Object userData = body.getUserData();
				if (userData != null && Entity.class.isAssignableFrom(userData.getClass())&& !(Wall.class.isAssignableFrom(userData.getClass()))) {
					Entity entity = (Entity) userData;
					String letterString = entity.getTextureName();
//					 letterSprite.setRotation((float)
//					 Math.toDegrees(body.getAngle()));
					spriteBatch.draw(this.name2texture.get(letterString), body.getPosition().x * WORLD_SCALE,
							body.getPosition().y * WORLD_SCALE);
				}
			}
		}
	}

	// private void renderBodiesBackup(){
	// if (this.round != null) {
	// Iterator<Body> bodies = this.round.getBox2DWorld().getBodies();
	// while (bodies.hasNext()) {
	// Body body = bodies.next();
	// Object userData = body.getUserData();
	// if (userData != null &&
	// Letter.class.isAssignableFrom(userData.getClass())) {
	// Letter letter = (Letter)userData;
	// String letterString = ""+letter.getLetter();
	// Texture texLetter = this.name2texture.get(letterString);//comment for
	// testin
	// // Texture texLetter = this.name2texture.get("a");
	//
	// Sprite letterSprite = new Sprite(texLetter);
	// // letterSprite.setSize(10*WORLD_SCALE, 10*WORLD_SCALE);
	// letterSprite.setX(body.getPosition().x * WORLD_SCALE);
	// letterSprite.setY(body.getPosition().y * WORLD_SCALE);
	// // letterSprite.setRotation((float) Math.toDegrees(body.getAngle()));
	// letterSprite.draw(spriteBatch);
	// // spriteBatch.draw(textureLetter, body.getPosition().x
	// // * WORLD_SCALE, body.getPosition().y * WORLD_SCALE);
	// }
	// if (userData != null && Hero.class.isAssignableFrom(userData.getClass()))
	// {
	// String heroState = this.round.getHero().getState().getFrameName();
	// Sprite heroSprite = new Sprite(this.name2texture.get(heroState));
	// // Sprite heroSprite = new Sprite(this.name2texture.get("back"));//for
	// testing
	//
	// // letterSprite.setSize(10*WORLD_SCALE, 10*WORLD_SCALE);
	// heroSprite.setX(body.getPosition().x * WORLD_SCALE);
	// heroSprite.setY(body.getPosition().y * WORLD_SCALE);
	// heroSprite.setScale(1f);
	// heroSprite.draw(spriteBatch);
	// }
	// if (userData != null && Wall.class.isAssignableFrom(userData.getClass()))
	// {
	// Wall wall = (Wall)userData;
	// Sprite wallSprite = new Sprite(this.name2texture.get(wall.getType()));
	// // letterSprite.setSize(10*WORLD_SCALE, 10*WORLD_SCALE);
	// wallSprite.setX(body.getPosition().x);
	// wallSprite.setY(body.getPosition().y);
	// // wallSprite.draw(spriteBatch);
	// }
	// }
	// }
	// }

	private void renderBackground() {
		spriteBatch.draw(this.name2texture.get("background"),0,0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	public void renderText() {
		float y = Gdx.graphics.getHeight() - Constants.TOP_BAR_TICKNESS + 30;
		CharSequence str = this.round.getHero().getLettersCollected().convertToString().toUpperCase();
		font.draw(spriteBatch, str, Gdx.graphics.getWidth() / 2 - 50, y);
		str = "Score: "+this.round.getHero().getTotalScore();
		font.draw(spriteBatch, str, Gdx.graphics.getWidth()-300,y);
		str = "Time: "+(int)this.round.getTimer().getTimeLeft();
		font.draw(spriteBatch, str,20, y);
//		str = ""+(int)this.round.getHero().getX() + "," + this.round.getHero().getY();
//		font.draw(spriteBatch, str,50, y);

	}
	
	public void dispose(){
		this.font.dispose();
		for(Texture texture : this.name2texture.values()){
			texture.dispose();
		}
		spriteBatch.dispose();
	}
}
