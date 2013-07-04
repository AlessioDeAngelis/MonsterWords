package com.monsterWords.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.badlogic.gdx.utils.Json;

/***
 * Deals with the persistance of the word list
 * */
public class JsonManager {

	public void txtToJson(String txtPath) {
		Json json = new Json();
		json.prettyPrint(json);
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(txtPath);
			br = new BufferedReader(fileReader);
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				System.out.println(strLine);
			}
			// Close the input stream
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		} finally {
			try {
				fileReader.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

	}

}
