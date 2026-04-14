package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class ShortestPathDAG {

    public static void main(String[] args) {
        int n = 6;
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        adj.get(0).add(new Pair(1, 2));
        adj.get(0).add(new Pair(4, 1));
        adj.get(1).add(new Pair(2, 3));
        adj.get(4).add(new Pair(2, 2));
        adj.get(4).add(new Pair(5, 4));
        adj.get(2).add(new Pair(3, 6));
        adj.get(5).add(new Pair(3, 1));

        int[] result = shortestPath(n, 0, adj);

        System.out.println("Shortest distances from source 0:");
        for (int i = 0; i < n; i++) {
            System.out.println("0 → " + i + " = " + (result[i] == Integer.MAX_VALUE ? "unreachable" : result[i]));
        }

    }

    private static int[] shortestPath(int n, int src, List<List<Pair>> adj) {
        boolean[] visit = new boolean[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                topologicalSort(i, visit, stack, adj);
            }
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!stack.isEmpty()){
            int node = stack.pop();

            if(dist[node] != Integer.MAX_VALUE){
                for(Pair pair : adj.get(node)){
                    int newDist = dist[node] + pair.weight;

                    if(newDist < dist[pair.node]){
                        dist[pair.node] = newDist;
                    }
                }
            }
        }

        return dist;
    }

    private static void topologicalSort(int node, boolean[] visit, Deque<Integer> stack, List<List<Pair>> adj) {
        visit[node] = true;

        for(Pair pair : adj.get(node)){
            if(!visit[pair.node]){
                topologicalSort(pair.node, visit, stack, adj);
            }
        }
        stack.push(node);
    }


    public static class Pair{
        int node, weight;

        Pair(int n, int w){
            node = n;
            weight = w;
        }
    }
}


