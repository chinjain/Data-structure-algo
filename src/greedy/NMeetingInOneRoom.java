package greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*

    Start array we have & End Arrays we have start[i] is the start time & end[i] is the end time.


 */

public class NMeetingInOneRoom {
    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};

        List<Integer> res = new ArrayList<>();

        List<int[]> meets = new ArrayList<>();
        for(int i = 0; i < start.length; i++){
            meets.add(new int[]{end[i],start[i],i + 1});
        }

        meets.sort(Comparator.comparingInt(a -> a[0]));
        int currTime = -1;

        for(int[] meet : meets){

            if(meet[1] > currTime){
                currTime = meet[0];
                res.add(meet[2]);
            }
        }

        System.out.println(res);

    }
}
