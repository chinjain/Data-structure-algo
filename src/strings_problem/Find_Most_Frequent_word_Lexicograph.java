package strings_problem;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Find_Most_Frequent_word_Lexicograph {

	public static void main(String[] args) {

		String A = "apple banana apple orange banana mango";
		String B = "banana mango";

		findMostFrequent(A, B);
		
	}

	private static void findMostFrequent(String a, String b) {
		// TODO Auto-generated method stub

		String[] sA = a.split(" ");
		String[] sB = b.split(" ");

		Map<String, Integer> frequencyMap = new HashMap<>();
		for (String words : sA) {
			frequencyMap.put(words, frequencyMap.getOrDefault(words, 0) + 1);
		}

		for (String word : sB) {
			frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
		}

		String mostFreq = null;
		for (String word : sA) {
			if (frequencyMap.get(word) != null && frequencyMap.get(word) > 0) {
				if (mostFreq == null || word.compareTo(mostFreq) < 0) {
					mostFreq = word;
				}
			}
		}
		
		System.out.println("Find_Most_Frequent_word_Lexicograph.findMostFrequent()");
		System.out.println(mostFreq);

	}

}
