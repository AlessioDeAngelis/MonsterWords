package com.monsterWords.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.monsterWords.utils.AssetLoader;

public class LoadingScreen implements Screen {
	private AssetManager manager;
	private Game game;
	private BitmapFont font;
	private SpriteBatch spriteBatch;
	
	public LoadingScreen(Game game){
		this.game = game;
		Gdx.input.setCatchBackKey(true);
	}
	
	@Override
	public void show() {
		manager = new AssetManager();
		manager.load("music/soundtrack.ogg", Sound.class);
		this.font = new BitmapFont(Gdx.files.internal("fonts/monsterFont.fnt"),
		         Gdx.files.internal("fonts/monsterFont.png"), false);
		this.spriteBatch = new SpriteBatch();
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(1f, 1f, 1f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(manager.update()){
			// we are done loading, let's move to another screen!
			AssetLoader.getInstance().setManager(manager);
			this.game.setScreen(new TitleScreen(game));
		}
		// display loading information
	      float progress = manager.getProgress();
	      this.spriteBatch.begin();
//	      this.font.draw(spriteBatch, "LOADING " + (int)(progress * 100) + "% ", Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);      
	      this.spriteBatch.end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void hide() {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void dispose() {
		this.font.dispose();
		this.spriteBatch.dispose();
	}

}
