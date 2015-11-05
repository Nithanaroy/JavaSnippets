package selfpractice.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Graph {
	private List<Vertex> V;
	private Map<Vertex, Set<Vertex>> E;

	public Graph() {
		V = new ArrayList<>();
		E = new HashMap<>();
	}

	public List<Vertex> vertices() {
		return V;
	}

	public Set<Vertex> adj(Vertex v) {
		return E.get(v);
	}

	public void addVertex(Vertex v) {
		V.add(v);
		E.put(v, new HashSet<Vertex>());
	}

	public void addEdge(Vertex u, Vertex v) {
		E.get(u).add(v);
		E.get(v).add(u); // assuming undirected graph
	}

	public void addEdge(String u, String v) {
		E.get(findVertexByName(u)).add(findVertexByName(v));
		E.get(findVertexByName(v)).add(findVertexByName(u)); // assuming undirected graph
	}

	public Vertex findVertexByName(String name) {
		for (Vertex vertex : V) {
			if (vertex.getName().equalsIgnoreCase(name))
				return vertex;
		}
		return null;
	}
}
