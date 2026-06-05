package intervals;

import java.util.Arrays;
import java.util.Map;

public class Non_Overlapping_Intervals {
    public static void main(String[] args) {
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int end = intervals[0][1];
        int cnt = 0;


        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                cnt++;
                end = Math.min(intervals[i][1],end);
            }else{
                end = intervals[i][1];
            }
        }

        System.out.println(cnt);

        System.out.println("Min Removal flow");

        minRemoval(intervals);
    }

    private static void minRemoval(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);

        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] < end){
                
            }
        }
    }
}