package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycle_BFS {
    public static void main(String[] args) {

        int n1 = 4;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i <= n1; i++) adj1.add(new ArrayList<>());

        adj1.get(1).add(2); adj1.get(2).add(1);
        adj1.get(1).add(3); adj1.get(3).add(1);
        adj1.get(2).add(4); adj1.get(4).add(2);
        adj1.get(3).add(4); adj1.get(4).add(3);

        System.out.println("Graph 1 has cycle: " + isCycle(n1, adj1));
    }

    private static boolean isCycle(int n, List<List<Integer>> adj) {
        boolean[] visited = new boolean[n + 1];

        // I can have the n - connected components I need to traverse all the components first
        for(int i = 1; i <= n; i++){
            if(!visited[i]){
                if (hasCycleBFS(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;

    }

    private static boolean hasCycleBFS(int i, List<List<Integer>> adj, boolean[] visited) {
        visited[i] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,-1});

        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0];
            int parent = cur[1];

            for(int neighbour : adj.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    queue.add(new int[]{neighbour, node});
                } else if (neighbour != parent) {
                    return true;
                }
            }
        }
        return false;
    }
}
