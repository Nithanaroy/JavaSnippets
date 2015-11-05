package selfpractice.stack;

public class NodeV2 {
	private NodeV2 next;
	int val;
	int min; /* Extra param */

	public NodeV2(int _val) {
		this.next = null;
		this.val = _val;
	}

	public NodeV2 getNext() {
		return next;
	}

	public int getVal() {
		return val;
	}

	public int getMin() {
		return min;
	}

	public void setNext(NodeV2 next) {
		this.next = next;
	}

	public void setMin(int min) {
		this.min = min;
	}

}
