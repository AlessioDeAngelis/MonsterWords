package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.model.button.GameButton;

public class TitleView {
	private static final float CAMERA_WIDTH = Gdx.graphics.getWidth();
	private static final float CAMERA_HEIGHT = Gdx.graphics.getHeight();
	private Texture background;
	private SpriteBatch spriteBatch;
	private Array<GameButton> buttons;
	private BitmapFont font;

	public TitleView(Array<GameButton> buttons) {
		this.buttons = buttons;
		this.background = new Texture(Gdx.files.internal("model/titleScreen.png"));
		this.spriteBatch = new SpriteBatch();
		this.font =  new BitmapFont();
		this.font = new BitmapFont(Gdx.files.internal("fonts/monsterFont.fnt"),
		         Gdx.files.internal("fonts/monsterFont.png"), false);
	}

	public void render(float delta) {
		this.spriteBatch.begin();
		this.spriteBatch.draw(background, 0, 0, CAMERA_WIDTH, CAMERA_HEIGHT);
		this.renderButtons();
		this.spriteBatch.end();
	}

	private void renderButtons(){
		CharSequence str = "";
		for(GameButton gameButton : buttons){
			str = gameButton.getName().toUpperCase();
			font.draw(spriteBatch, str, gameButton.getX(),gameButton.getY());
		}
	}
	
	public void dispose() {
		this.background.dispose();
		this.font.dispose();
		this.spriteBatch.dispose();
	}
}
