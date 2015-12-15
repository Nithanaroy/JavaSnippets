package selfpractice.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * @author nitinpasumarthy
 *
 */

public class IsBalanced {
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return Math.abs(height(root.left) - height(root.right)) <= 1;
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int h = 1;
		while (!q.isEmpty()) {
			TreeNode n = q.poll();
			if (n.left != null || n.right != null) {
				h++;
				if (n.left != null)
					q.add(n.left);
				if (n.right != null)
					q.add(n.right);
			}
		}
		return h;
	}

	public static void main(String[] args) {
		BinaryTree t = new BinaryTree();
		t.create(new Integer[] { 1, 2, 2, 3, null, null, 3, 4, null, null, 4 });
		IsBalanced b = new IsBalanced();
		System.out.println(b.isBalanced(t.r));
	}
}
