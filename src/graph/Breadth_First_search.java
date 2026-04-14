package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Breadth_First_search {

	public static void main(String[] args) {
		int n = 4;
		List<List<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			adj.add(new ArrayList<>());
		}
		adj.get(0).add(1);
		adj.get(1).add(0);
		adj.get(0).add(2);
		adj.get(2).add(0);
		adj.get(1).add(3);
		adj.get(3).add(1);

		System.out.println("BFS Traversals: ");
		bfs(n, adj);
	}

	private static List<Integer> bfs(int v, List<List<Integer>> adj) {
		List<Integer> bsf = new ArrayList<>();
		boolean[] visit = new boolean[v];

		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visit[0] = true;

		while (!q.isEmpty()) {
			int node = q.poll();
			System.out.println(node + " ");

			for (int it : adj.get(node)) {
				if (!visit[it]) {
					q.add(it);
					visit[it] = true;
				}
			}
		}
		return bsf;
	}

}
