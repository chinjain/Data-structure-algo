package graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(3);
		adj.get(3).add(0);
		adj.get(2).add(4);
		adj.get(4).add(2);
		
		dfsGraph(5, adj);

	}

	private static void dfsGraph(int v, ArrayList<ArrayList<Integer>> adj) {
		boolean [] visit = new boolean[v + 1];
		visit[0] = true;
		
		List<Integer> ls = new ArrayList<Integer>();
		dfs(0,visit,adj,ls);
		
		ls.stream().forEach(System.out::println);
		
	}

	private static void dfs(int node, boolean[] visit, ArrayList<ArrayList<Integer>> adj, List<Integer> ls) {
		
		visit[node] = true;
		ls.add(node);
		
		for(int it : adj.get(node)) {
			if(visit[it] == false) {
				dfs(it, visit, adj, ls);
			}
		}
		
	}

}
