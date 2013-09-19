package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class CreditsView {
private SpriteBatch spriteBatch;
private BitmapFont font;
private Texture background;
	public CreditsView(){
		this.background = new Texture(Gdx.files.internal("model/titleScreen.png"));

		this.spriteBatch = new SpriteBatch();
		this.font = new BitmapFont();
		this.font = new BitmapFont(Gdx.files.internal("fonts/creditsFont.fnt"),
				Gdx.files.internal("fonts/creditsFont.png"), false);
	}
	
	public void render(float delta) {
		spriteBatch.begin();
		spriteBatch.draw(this.background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		font.drawMultiLine(spriteBatch, "Monster Words \n developed by \n Alessio De Angelis \n \n Copyright 2013 \n \n Powered by libGDX \n \n Soundtrack title: \"Sylly Fun\" from \n http://incompetech.com/ \n by Kevin MacLeod  ",450, Gdx.graphics.getHeight()-20);
		spriteBatch.end();
	}
	
	public void dispose() {
		background.dispose();
		font.dispose();
		spriteBatch.dispose();
	}

}
