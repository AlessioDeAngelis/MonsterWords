package com.monsterWords.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.monsterWords.model.button.GameButton;

public class RulesView {
	private SpriteBatch spriteBatch;
	private Texture[] slides;
	private GameButton continueButton;
	private GameButton goBackButton;
	private Texture buttonTexture,flipButtonTexture;
	private float counter;// for the blinking effect of the button

	public RulesView(GameButton continueButton, GameButton goBackButton) {
		this.continueButton = continueButton;
		this.goBackButton = goBackButton;
		this.spriteBatch = new SpriteBatch();
		this.slides = new Texture[] { new Texture(Gdx.files.internal("model/rules/slide.png")),
				new Texture(Gdx.files.internal("model/rules/slide2.png")),
				new Texture(Gdx.files.internal("model/rules/slide3.png")),
				new Texture(Gdx.files.internal("model/rules/rules2.png")),
				new Texture(Gdx.files.internal("model/rules/rules3.png")) };
		this.buttonTexture = new Texture(Gdx.files.internal("model/button/continueButton.png"));
		this.flipButtonTexture = new Texture(Gdx.files.internal("model/button/goBackButton.png"));
		this.counter = 0;
	}

	public void render(float delta, int currentSlide) {
		counter += delta;
		this.spriteBatch.begin();
		this.spriteBatch.draw(this.slides[currentSlide], 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if ((int)(counter) % 2 == 0) {
			this.spriteBatch.draw(this.buttonTexture, this.continueButton.getX(), this.continueButton.getY());
			this.spriteBatch.draw(this.flipButtonTexture, this.goBackButton.getX(), this.goBackButton.getY());
		}
		this.spriteBatch.end();
	}

	public void dispose() {
		this.spriteBatch.dispose();
		for (Texture t : slides) {
			t.dispose();
		}
		this.buttonTexture.dispose();
	}
}
