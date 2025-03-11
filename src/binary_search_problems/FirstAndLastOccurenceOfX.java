package binary_search_problems;

public class FirstAndLastOccurenceOfX {

    private int[] result;

    public static void main(String[] args) {

        FirstAndLastOccurenceOfX occurence = new FirstAndLastOccurenceOfX();

        int arr[] = {2, 2 , 3 , 3 , 3 , 3 , 4};
        int x = 3;


        int firstOccur = findFirstOccur(arr, x, arr.length);
        int lastOccur = findLastOccur(arr, x, arr.length);

        System.out.println(firstOccur);
        System.out.println(lastOccur);

        occurence.setResult(firstOccur,lastOccur);

    }

    public static int findLastOccur(int[] arr, int x, int length) {
        int lo = 0;
        int hi = length - 1;
        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi -lo)/2;
            if(arr[mid] == x){
                ans = mid;
                lo = mid + 1;
            }else if(arr[mid] > x){
                hi = mid - 1;
            }else{
                lo = mid + 1;
            }

        }

        return  ans;
    }

    public static int findFirstOccur(int[] arr, int x, int length) {

        int lo = 0;
        int hi = length - 1;
        int ans = -1;
        while (lo <= hi){
            int mid = lo + (hi -lo)/2;
            if(arr[mid] == x){
                ans = mid;
                hi = mid - 1;
            }else if(arr[mid] < x){
                lo = mid + 1;
            }else{
                hi = mid - 1;
            }

        }

        return  ans;
    }


    public int[] getResult(){
        return  result;
    }

    public void setResult(int firsOccurence, int lastOccurrence){
        result = new int[]{firsOccurence,lastOccurrence};
    }
}
