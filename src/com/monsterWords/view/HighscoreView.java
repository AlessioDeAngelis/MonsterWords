package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class HighscoreView {

	private BitmapFont font;
	private SpriteBatch spriteBatch;
	private Texture background;
	private int highscore;

	public HighscoreView(int highscore) {
		this.background = new Texture(Gdx.files.internal("model/titleScreen.jpg"));
		this.highscore = highscore;
		this.spriteBatch = new SpriteBatch();
		this.font = new BitmapFont();
		this.font = new BitmapFont(Gdx.files.internal("fonts/gameOverFont.fnt"),
				Gdx.files.internal("fonts/gameOverFont.png"), false);
	}

	public void render(float delta) {
		spriteBatch.begin();
		spriteBatch.draw(this.background,0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		font.drawMultiLine(spriteBatch, "YOUR\nHIGHSCORE \n IS:" + highscore, 400, Gdx.graphics.getHeight()-50);
		spriteBatch.end();
	}

	public void dispose() {
		background.dispose();
		font.dispose();
		spriteBatch.dispose();
	}

}
