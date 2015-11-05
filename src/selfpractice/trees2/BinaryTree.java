package selfpractice.trees2;

import java.util.ArrayList;
import java.util.HashMap;

public class BinaryTree {
	Node head;

	public BinaryTree() {
		head = null;
	}

	public void insert(int v) {
		if (head == null)
			head = insert(head, v);
		else
			insert(head, v);
	}

	public boolean isBalanced() {
		return Math.abs(height(head.left) - height(head.right)) <= 1;
	}

	public int height() {
		return height(head);
	}

	private int height(Node h) {
		if (h == null)
			return 0;
		else if (h.left == null && h.right == null)
			return 1;
		else {
			return Math.max(height(h.left), height(h.right)) + 1;
		}
	}

	private Node insert(Node h, int v) {
		Node n = new Node(v);
		if (h == null) {
			h = n;
			return h;
		} else {
			if (v <= h.v) {
				if (h.left == null)
					h.left = n;
				else
					insert(h.left, v);
			} else {
				if (h.right == null)
					h.right = n;
				else
					insert(h.right, v);
			}
		}
		return n;
	}

	public void inOrder() {
		inOrder(head);
	}

	private void inOrder(Node h) {
		if (h != null) {
			inOrder(h.left);
			System.out.print(h.v + " ");
			inOrder(h.right);
		}
	}

	public void levelOrder() {
		HashMap<Integer, ArrayList<Integer>> h = new HashMap<>();
		levelOrder(h, head, 0);
		System.out.println();
		for (int level : h.keySet()) {
			printList(h.get(level));
			System.out.println();
		}
	}

	private void printList(ArrayList<Integer> a) {
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	private void levelOrder(HashMap<Integer, ArrayList<Integer>> h, Node n, int depth) {
		if (n != null) {
			levelOrder(h, n.left, depth + 1);
			insertIntoHashMap(h, depth, n.v);
			levelOrder(h, n.right, depth + 1);
		}
	}

	private void insertIntoHashMap(HashMap<Integer, ArrayList<Integer>> h, int key, int value) {
		if (h.get(key) == null) {
			ArrayList<Integer> a = new ArrayList<>();
			a.add(value);
			h.put(key, a);
		} else {
			ArrayList<Integer> a = h.get(key);
			a.add(value);
		}
	}
}
