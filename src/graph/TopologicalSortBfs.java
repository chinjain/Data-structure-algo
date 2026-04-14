package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortBfs {

    public static void main(String[] args) {
        // Graph:
        // 5 → 0, 5 → 2
        // 4 → 0, 4 → 1
        // 2 → 3
        // 3 → 1
        int n = 6;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(5).add(0);
        adj.get(5).add(2);
        adj.get(4).add(0);
        adj.get(0).add(4);
        adj.get(4).add(1);
        adj.get(2).add(3);

        List<Integer> result = topoSort(n, adj);
        System.out.println("Topological Order: " + result);
    }

    static List<Integer> topoSort(int n, List<List<Integer>> adj) {
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        System.out.println("In-degrees" +  Arrays.toString(indegree));

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                queue.add(i);
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()){
            int node = queue.poll();
            result.add(node);

            for(int neighbour : adj.get(node)){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0){
                    queue.add(neighbour);
                }
            }
        }

        System.out.println("After process InDegrees" + Arrays.toString(indegree));

        if(result.size() != n){
            System.out.println("Cycle found");
        }

        return result;
    }
}
