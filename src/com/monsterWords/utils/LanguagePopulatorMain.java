package com.monsterWords.utils;

/***
 * This is a util class for generating the letter distribution string in a
 * language to pass in the array in the specific language controller. You know,
 * I am very lazy :)
 * */
public class LanguagePopulatorMain {
	public static void main(String[] args) {
//		1 point: E ×15, N ×9, S ×7, I ×6, R ×6, T ×6, U ×6, A ×5, D ×4
//		2 points: H ×4, G ×3, L ×3, O ×3
//		3 points: M ×4, B ×2, W ×1, Z ×1
//		4 points: C ×2, F ×2, K ×2, P ×1
//		6 points: Ä ×1, J ×1, Ü ×1, V ×1
//		8 points: Ö ×1, X ×1
//		10 points: Q ×1, Y ×1
		String result = "";
			result +=	populateWithLetters('a', 5);
		result += populateWithLetters('b', 2);
		result += populateWithLetters('c', 2);
		result += populateWithLetters('d', 4);
		result += populateWithLetters('e', 15);
		result += populateWithLetters('f', 2);
		result += populateWithLetters('g', 3);
		result += populateWithLetters('h', 4);
		result += populateWithLetters('i', 6);
		result += populateWithLetters('l', 3);
		result += populateWithLetters('j', 1);
		result += populateWithLetters('k', 2);
		result += populateWithLetters('m', 4);
		result += populateWithLetters('n', 9);
		result += populateWithLetters('o', 3);
		result += populateWithLetters('p', 1);
		result += populateWithLetters('q', 1);
		result += populateWithLetters('r', 6);
		result += populateWithLetters('s', 7);
		result += populateWithLetters('t', 6);
		result += populateWithLetters('u', 6);
		result += populateWithLetters('v', 1);
		result += populateWithLetters('w', 1);
		result += populateWithLetters('x', 1);
		result += populateWithLetters('y', 1);
		result += populateWithLetters('z', 1);
		result += populateWithLetters('ö', 1);
		result += populateWithLetters('ä', 1);
		result += populateWithLetters('ü', 1);
		result += populateWithLetters('ß', 2);



		System.out.println(result);
	}

	private static String populateWithLetters(char letter, int times) {
		String result = "";
		for (int i = 0; i < times; i++) {
			result += "'" + letter + "',";
		}
		return result;
	}
}
