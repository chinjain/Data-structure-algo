package strings_problem;

public class Revers_Each_word {

	public static void main(String[] args) {

		String input = "Hello World Java Programming";
		reverseWords(input);
		optimalCode(input);
	}

	private static void optimalCode(String input) {

		char ch[] = input.toCharArray();
		int start = 0;

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ' || i == ch.length - 1) {
				int left = start;
				int right = (i == ch.length - 1) ? i : i - 1;

				while (left < right) {
					char temp = ch[left];
					ch[left] = ch[right];
					ch[right] = temp;
					left++;
					right--;
				}

				start = i + 1;
			}
		}
		
		System.out.println("Revers_Each_word.optimalCode()");
		System.out.println(new String(ch));

	}

	private static void reverseWords(String input) {

		char[] ch = input.toCharArray();
		int start = 0;

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == ' ') {
				reverse(ch, start, i - 1);
				start = i + 1;
			}
		}

		reverse(ch, start, ch.length - 1);

//		reverse(ch, 0, ch.length - 1);

		System.out.println("Revers_Each_word.reverseWords()");
		System.out.println(new String(ch));

	}

	private static void reverse(char[] ch, int start, int i) {

		while (start < i) {
			char temp = ch[start];
			ch[start] = ch[i];
			ch[i] = temp;
			start++;
			i--;
		}

	}

}
