package selfpractice.leetcode;

import java.util.Deque;
import java.util.LinkedList;

import selfpractice.trees2.BinarySearchTree;
import selfpractice.trees2.Node;

/**
 * Finds the deepest node in a binary tree using an iterative approach
 * Think of the tree like a graph and do a BFS
 * Every iteration, increment the distance from source (root) and update deepest node local variable
 * 
 * @author nitinpasumarthy
 *
 */
public class DeepestNode {
	public static void main(String[] args) {
		BinarySearchTree t = createTree();
		DeepestNode n = new DeepestNode();

		NodeWrapper nw = n.getDeepestNode(t);
		System.out.format("Deepest Node: %s. Depth: %d\n", nw.n, nw.depth);
	}

	public NodeWrapper getDeepestNode(BinarySearchTree t) {
		NodeWrapper deepestNode = new NodeWrapper(null, 0);
		Deque<NodeWrapper> q = new LinkedList<>();
		q.addLast(new NodeWrapper(t.head, 0));
		while (!q.isEmpty()) {
			NodeWrapper nw = q.poll();

			Node n = nw.n;
			if (nw.depth > deepestNode.depth) {
				deepestNode = nw;
			}

			if (n.left != null)
				q.addLast(new NodeWrapper(n.left, nw.depth + 1));
			if (n.right != null)
				q.addLast(new NodeWrapper(n.right, nw.depth + 1));
		}
		return deepestNode;
	}

	private static BinarySearchTree createTree() {
		BinarySearchTree t = new BinarySearchTree();
		t.insert(6);
		t.insert(9);
		t.insert(3);
		t.insert(2);
		t.insert(5);
		t.insert(8);
		t.insert(10);
		t.insert(4);
		t.insert(7);
		return t;
	}
}

class NodeWrapper {
	Node n;
	int depth;

	public NodeWrapper(Node _n, int d) {
		this.n = _n;
		this.depth = d;
	}
}
