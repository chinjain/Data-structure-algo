package binary_search_problems;

import java.util.ArrayList;
import java.util.Arrays;

public class SearchSIngleElementInSortedArray {

    public static void main(String[] args) {

        ArrayList<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6));

        bruteForce(arr);

    }

    public static void bruteForce(ArrayList<Integer> list){
        int n = list.size();

        if(n == 1){
            System.out.println(list.get(0));
        }

        for(int i = 0; i < n; i++){

        }


    }

}
