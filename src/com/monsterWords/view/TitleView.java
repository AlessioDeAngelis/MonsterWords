package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class TitleView {
	private static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
	private static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();
	private Texture background;
	private SpriteBatch spriteBatch;
	public TitleView() {
		this.background = new Texture(Gdx.files.internal("model/titleScreen.png"));
		this.spriteBatch = new SpriteBatch();
	}
	
	public void render(){
		this.spriteBatch.begin();
		this.spriteBatch.draw(background, 0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.spriteBatch.end();
	}
	
	public void dispose(){
		this.background.dispose();
	}
}
