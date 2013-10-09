package com.monsterWords.view;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.monsterWords.model.button.GameButton;

public class ChooseGameView {
	private Array<GameButton> buttons;
	private Map<String, Texture> name2texture;
	private SpriteBatch spriteBatch;

	public ChooseGameView(Array<GameButton> buttons) {
		this.buttons = buttons;
		this.name2texture = new HashMap<String, Texture>();
		this.spriteBatch = new SpriteBatch();
		loadTextures();
	}

	private void loadTextures() {
		String name = "";
		for (GameButton button : buttons) {
			name = button.getName();
			this.name2texture.put(name, new Texture(Gdx.files.internal("model/flag/" + name + ".png")));
		}
		this.name2texture.put("background",new Texture(Gdx.files.internal("model/titleScreen.jpg")));
	}

	public void render(float delta) {
		spriteBatch.begin();
		spriteBatch.draw(this.name2texture.get("background"),0,0,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		for(GameButton gameButton : buttons){
			spriteBatch.draw(this.name2texture.get(gameButton.getName()),gameButton.getX(),gameButton.getY(),gameButton.getWidth(), gameButton.getHeight());
		}
		spriteBatch.end();
	}
	
	public void dispose(){
		for(Texture texture : name2texture.values()){
			texture.dispose();
		}
		this.spriteBatch.dispose();
	}

}
