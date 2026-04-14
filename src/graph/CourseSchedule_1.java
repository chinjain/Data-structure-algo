package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule_1 {

    public static void main(String[] args) {
        // Test 1 — possible
        //all the course are in inverse format and we have to done in such a way that 0 must be done before 1
        /*
                like pre-request things.
         */
        System.out.println(canFinish(4, new int[][]{{1,0},{2,1},{3,2}}));
        // Expected: true

        // Test 2 — impossible (cycle)
        System.out.println(canFinish(2, new int[][]{{0,1},{1,0}}));
        // Expected: false

        // Test 3 — no prerequisites
        System.out.println(canFinish(3, new int[][]{}));
        // Expected: true
    }

    private static boolean canFinish(int n, int[][] input) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] pre : input){
            adj.get(pre[1]).add(pre[0]);
        }

        int[] indegree = new int[n];
        for(int i = 0; i < n; i++){
            for(int neighbour : adj.get(i)){
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        int count = 0;

        while (!q.isEmpty()){
            int node = q.poll();
            count++;

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;

                if(indegree[neighbour] == 0)
                    q.add(neighbour);
            }
        }
        return count == n;

    }
}
