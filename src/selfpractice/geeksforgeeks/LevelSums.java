package selfpractice.geeksforgeeks;

/**
 * http://www.geeksforgeeks.org/find-multiplication-of-sums-of-data-of-all-leaves-at-sane-levels/
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import selfpractice.leetcode.BinaryTree;
import selfpractice.leetcode.TreeNode;

public class LevelSums {
	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.create(new Integer[] { 2, 7, 5, 8, 6, null, 9, null, null, 1, 11, 4, 10 });
		System.out.println(productLevelSum(t));
	}

	private static int productLevelSum(BinaryTree t) {
		Queue<NodeWrapper> q = new LinkedList<>();
		q.add(new NodeWrapper(t.r, 1));
		HashMap<Integer, Integer> sums = new HashMap<>();
		int res = 1;
		while (!q.isEmpty()) {
			NodeWrapper n1 = q.poll();
			TreeNode n = n1.n;
			if (n.left != null) {
				q.add(new NodeWrapper(n.left, n1.depth + 1));
			}
			if (n.right != null) {
				q.add(new NodeWrapper(n.right, n1.depth + 1));
			}
			if (n.left == null && n.right == null) {
				upsert(sums, n1.depth, n.val);
			}
		}
		for (Integer sum : sums.values()) {
			res *= sum;
		}
		return res;
	}

	private static void upsert(HashMap<Integer, Integer> h, int k, int v) {
		if (h.containsKey(k)) {
			int val = h.get(k);
			val += v;
			h.put(k, val);
		} else {
			h.put(k, v);
		}
	}
}

class NodeWrapper {
	TreeNode n;
	int depth;

	public NodeWrapper(TreeNode n, int depth) {
		this.n = n;
		this.depth = depth;
	}

	@Override
	public String toString() {
		return String.format("[%s, %d]", n, depth);
	}
}
