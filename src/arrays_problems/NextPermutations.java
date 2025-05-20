package arrays_problems;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NextPermutations {

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3);

        findNextPerumtations(a);
    }

    static void findNextPerumtations(List<Integer> list){

        int idx = -1;

        for(int i = list.size() - 2; i >= 0; i--){

            if(list.get(i) < list.get(i + 1)){
                idx = i;
                break;
            }

        }

        if(idx == -1){
            Collections.reverse(list);
        }


        for(int i = list.size() - 1; i >= idx; i--){
            if(list.get(i) > list.get(idx)){
                int temp = list.get(i);
                list.set(i, list.get(idx));
                list.set(idx, temp);

                break;
            }
        }

    }
}
