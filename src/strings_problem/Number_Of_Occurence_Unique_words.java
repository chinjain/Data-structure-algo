package strings_problem;

import java.util.HashMap;
import java.util.Map;

public class Number_Of_Occurence_Unique_words {

	public static void main(String[] args) {

		String inputString = "Java is a programming language. Java is widely used in software development.";
		Map<String, Integer> wordCountMap = new HashMap<>();

		String[] s = inputString.split("\\s");

		for (String word : s) {
			word = word.toLowerCase();

			wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
		}

//		wordCountMap.entrySet().stream().filter(m -> m.getValue() == 1).forEach(entry -> {
//			System.out.println(entry.getKey());
//		});
		
		String output = wordCountMap.entrySet().stream().filter(m -> m.getValue() == 1).findFirst().get().getKey();
		System.out.println("Number_Of_Occurence_Unique_words.main()");
		System.out.println(output);

	}

}
