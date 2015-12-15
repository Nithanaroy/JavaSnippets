package selfpractice.leetcode;

public class TreeNode {
	public int val;
	public TreeNode left, right;

	public TreeNode(int v) {
		this.val = v;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return val + "";
	}
}
