package graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class TopologicalSortDfs {

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
        adj.get(4).add(1);
        adj.get(2).add(3);
        adj.get(3).add(1);
        System.out.println("Topological Order: " + topoSort(n, adj));


    }

    static List<Integer> topoSort(int n, List<List<Integer>> adj) {
        boolean[] visit = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            if(!visit[i]){
                dfs(i, adj, visit, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    static void dfs(int node, List<List<Integer>> adj,
                    boolean[] visited, Deque<Integer> stack) {
        visited[node] = true;

        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
