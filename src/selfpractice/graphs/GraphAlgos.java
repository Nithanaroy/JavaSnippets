package selfpractice.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class GraphAlgos {

	public static boolean D = true;

	public static void breadthFirstSearch(Graph g, Vertex s) {

		Queue<Vertex> q = new LinkedList<>();

		for (Vertex v : g.vertices()) {
			v.setExplored(false);
		}

		s.setExplored(true);
		s.setDistanceFromSource(0);
		s.setParent(null);

		q.add(s);

		while (!q.isEmpty()) {
			Vertex v = q.poll();
			for (Vertex u : g.adj(v)) {
				if (!u.isExplored()) {
					updateVertex(v, u);
					q.add(u);
					System.out.print(u.getName() + " => " + u.getDistanceFromSource());
					if (D) {
						printRouteToSource(u);
					}
					System.out.println();
				}

			}
		}
	}

	private static void updateVertex(Vertex v, Vertex u) {
		u.setDistanceFromSource(v.getDistanceFromSource() + 1);
		u.setExplored(true);
		u.setParent(v);
	}

	public static void depthFirstSearch(Graph g, Vertex s) {
		if (s == null) {
			// Below code handles disconnected components also
			// In this case, distances dont make sense as there is no source
			for (Vertex v : g.vertices()) {
				if (!v.isExplored()) {
					doDfs(g, v, null);
				}
			}
		} else {
			s.setDistanceFromSource(0);
			doDfs(g, s, null);

		}

	}

	private static void doDfs(Graph g, Vertex v, Vertex p) {
		if (v != null && !v.isExplored()) {
			v.setParent(p);
			v.setExplored(true);
			if (p != null)
				v.setDistanceFromSource(p.getDistanceFromSource() + 1);
			System.out.print(v + " => " + v.getDistanceFromSource());
			if (D) {
				printRouteToSource(v);
			}
			System.out.println();
			for (Vertex u : g.adj(v)) {
				doDfs(g, u, v);
			}
		}
	}

	private static void printRouteToSource(Vertex v) {
		while (v != null) {
			System.out.print(" -> " + v);
			v = v.getParent();
		}
	}
}
