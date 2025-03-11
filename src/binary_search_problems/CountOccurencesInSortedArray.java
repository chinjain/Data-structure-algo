package binary_search_problems;

public class CountOccurencesInSortedArray {

    public static void main(String[] args) {

        int[] arr = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int x = 3;

       int first = FirstAndLastOccurenceOfX.findFirstOccur(arr,x,arr.length);
       int last = FirstAndLastOccurenceOfX.findLastOccur(arr, x, arr.length);
       System.out.println(last - first + 1);

    }
}
