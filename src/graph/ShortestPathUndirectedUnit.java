package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPathUndirectedUnit {

    public static void main(String[] args) {
        int n1 = 5;
        List<List<Integer>> adj1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) adj1.add(new ArrayList<>());

        adj1.get(0).add(1); adj1.get(1).add(0);
        adj1.get(0).add(2); adj1.get(2).add(0);
        adj1.get(1).add(3); adj1.get(3).add(1);
        adj1.get(2).add(4); adj1.get(4).add(2);
        adj1.get(3).add(4); adj1.get(4).add(3);

        int[] result1 = shortestPath(n1, 0, adj1);
        System.out.println("Distances from node 0:");

        for(int i = 0; i < n1; i++){
            System.out.println("0 → " + i + " = " + result1[i]);
        }
    }

    static int[] shortestPath(int n, int src, List<List<Integer>> adj){
        boolean[] visit = new boolean[n];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()){
            int node = queue.poll();

            for(int neighbour : adj.get(node)){

                if(dist[node] + 1 < dist[neighbour]){
                    dist[neighbour] = dist [node] + 1;
                    queue.add(neighbour);
                }
            }
        }

        return dist;
    }
}
