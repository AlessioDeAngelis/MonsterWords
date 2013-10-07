package com.monsterWords.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.monsterWords.utils.Constants;

public class ScoreRepository {
	private String filePath;

	// Private constructor prevents instantiation from other classes
	private ScoreRepository() {
		this.filePath = Constants.SCORE_FILE_PATH;
	}

	/**
	 * SingletonHolder is loaded on the first execution of
	 * Singleton.getInstance() or the first access to SingletonHolder.INSTANCE,
	 * not before.
	 */
	private static class SingletonHolder {
		public static final ScoreRepository INSTANCE = new ScoreRepository();
	}

	public static ScoreRepository getInstance() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * Persists the highscore
	 * */
	public void saveScore(int score) {
		FileHandle file = Gdx.files.local(filePath);
		file.writeString(""+score, false);
	}

	/**
	 * Retrieves the highscore
	 * */
	public int retrieveScore() {
		FileHandle file = Gdx.files.local(filePath);//internal does not work
		String stringa = file.readString();
		int score = -1;
		if(stringa!=null||stringa!=""){
			score=Integer.parseInt(stringa);
		}
		return score;
	}

}