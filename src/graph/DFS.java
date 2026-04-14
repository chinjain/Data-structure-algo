package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	public static void main(String[] args) {
		int n = 4;
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		// Adding edges
		adj.get(0).add(1);
		adj.get(1).add(0);

		adj.get(0).add(2);
		adj.get(2).add(0);

		adj.get(1).add(3);
		adj.get(3).add(1);

		boolean[] visited = new boolean[n + 1];
		System.out.print("DFS Traversal: ");
		dfs(0, adj, visited);

	}


	private static void dfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] visit) {
		
		visit[start] = true;
		System.out.println(start+ " ");
		
		for(int it : adj.get(start)) {
			if(!visit[it]) {
				dfs(it, adj,visit);
			}
		}
		
	}

}
