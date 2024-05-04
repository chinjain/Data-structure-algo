package strings_problem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Two_MostRepetitiveWords_String {

	public static void main(String[] args) {
		String inputString = "hi my name is java nigam is i love to java in java because it is very good name";
		List<String> mostRepetitiveWords = findMostRepetitiveWords(inputString);
		System.out.println("Two most repetitive words: " + mostRepetitiveWords);
	}

	private static List<String> findMostRepetitiveWords(String inputString) {
		String words[] = inputString.split(" ");
		Map<String, Integer> wordCount = new HashMap<String, Integer>();

		for (String word : words) {
			wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
		}

		List<Map.Entry<String, Integer>> entries = new ArrayList<Map.Entry<String, Integer>>(wordCount.entrySet());
		entries.sort(Map.Entry.comparingByValue(Collections.reverseOrder()));

		List<String> mostRepetitiveWords = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			mostRepetitiveWords.add(entries.get(i).getKey());
		}

		return mostRepetitiveWords;
	}

}
