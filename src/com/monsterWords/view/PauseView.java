package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PauseView {
	private SpriteBatch spriteBatch;
	private AssetManager manager;
	private Texture tex;
	public PauseView(){
		this.spriteBatch = new SpriteBatch();
		this.manager = new AssetManager();
		manager.load("model/background.png", Texture.class);
	}
	
	public void draw(){
		if(manager.isLoaded("model/background.png", Texture.class)){
			tex = manager.get("model/background.png", Texture.class);
			spriteBatch.draw(tex, 0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		}
	}
	
	public void dispose(){
		tex.dispose();
		manager.clear();
	}
}
