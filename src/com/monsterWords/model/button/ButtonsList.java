package com.monsterWords.model.button;

import com.badlogic.gdx.utils.Array;

public class ButtonsList {
private Array<GameButton> buttons;
public ButtonsList(){
	this.buttons = new Array<GameButton>();
}

public void addButton(GameButton button, float x, float y){
	this.buttons.add(button);
}
}
