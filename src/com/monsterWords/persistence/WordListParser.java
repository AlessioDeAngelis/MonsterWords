package com.monsterWords.persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WordListParser {
	public List<String> txtToList(String txtPath) {
		List<String> words = new ArrayList<String>();
		FileReader fileReader = null;
		BufferedReader br = null;
		try {
			fileReader = new FileReader(txtPath);
			br = new BufferedReader(fileReader);
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				words.add(strLine);
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
		return words;

	}
}
