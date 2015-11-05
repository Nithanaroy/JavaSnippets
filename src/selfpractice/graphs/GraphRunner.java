package selfpractice.graphs;

public class GraphRunner {
	public static void main(String[] args) {
		Graph g = createGraph2();
		GraphAlgos.breadthFirstSearch(g, g.findVertexByName("s"));
		System.out.println("Done");
		
		g = createGraph2();
		GraphAlgos.depthFirstSearch(g, g.findVertexByName("s"));
		System.out.println("Done");
	}

	private static Graph createGraph() {
		Graph g = new Graph();
		String names[] = { "A", "B", "C", "D", "E", "F", "G" };
		for (String name : names) {
			g.addVertex(new Vertex(name));
		}
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("C", "E");
		g.addEdge("E", "F");
		g.addEdge("E", "G");

		return g;
	}

	private static Graph createGraph2() {
		Graph g = new Graph();
		String names[] = { "r", "s", "t", "u", "v", "w", "x", "y" };
		for (String name : names) {
			g.addVertex(new Vertex(name));
		}
		g.addEdge("r", "v");
		g.addEdge("r", "s");

		g.addEdge("s", "w");

		g.addEdge("t", "w");
		g.addEdge("t", "x");
		g.addEdge("t", "u");

		g.addEdge("u", "x");
		g.addEdge("u", "y");

		g.addEdge("w", "x");

		g.addEdge("x", "y");

		return g;
	}
}
