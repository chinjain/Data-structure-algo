package stack_problems;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

	public static void main(String[] args) {
		int[] a = {1, 5, 2, 3, 5};
		fromRight(a);
		brut_approach(a);
	}

	 static void brut_approach(int[] a) {

		int [] result = new int[a.length];

		for(int i = 0; i < a.length; i++){
			result[i] = -1;
			for(int j = i + 1; j < a.length; j++){
				if(a[j] > a[i]) {
					result[i] = a[j];
					break;
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}

	 static void fromRight(int[] a) {
		Stack<Integer> st = new Stack<>();
		int [] result = new int[a.length];
		Arrays.fill(result, -1);

		for(int i = 0; i < a.length; i++){

			while (!st.isEmpty() && a[i] > a[st.peek()]){
				int idx = st.pop();
				result[idx] = a[i];
			}
			st.push(i);
		}
		System.out.println(Arrays.toString(result));
	}
}
