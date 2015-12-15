package selfpractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	public TreeNode r;

	/**
	 * Constructs a Binary Tree using the level order array
	 * Check https://leetcode.com/faq/#binary-tree for syntax
	 */
	public void create(Integer[] v) {
		// TODO: Didnt work for { 2, 7, 5, 8, 6, null, 9, null, null, 1, 11, 4, 10 }
		if (v.length == 0)
			return;
		Queue<TreeNode> q = new LinkedList<>();
		r = new TreeNode(v[0]);
		q.add(r);
		for (int i = 0; i < v.length; i++) {
			// Attaching children for Node i
			if (v[i] != null) {
				TreeNode n = q.poll();
				if (2 * i + 1 < v.length && v[2 * i + 1] != null) {
					n.left = new TreeNode(v[2 * i + 1]);
					q.add(n.left);
				}
				if (2 * i + 2 < v.length && v[2 * i + 2] != null) {
					n.right = new TreeNode(v[2 * i + 2]);
					q.add(n.right);
				}
			}
		}
	}
}
