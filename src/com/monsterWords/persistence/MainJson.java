package com.monsterWords.persistence;

public class MainJson {
	public static void main(String[] args) {
		JsonManager jm = new JsonManager();
		String txtPath = "data/english.txt";
		jm.txtToJson(txtPath);
	}
}
