package selfpractice.stack;

/**
 * A stack with push, pop and min operations in O(1) time
 * For this we use a special class NodeV2 which has one extra param called min
 * It saves the min value in this stack upto that level
 * 
 * @author nitinpasumarthy
 *
 */
public class Stack {
	private NodeV2 head;

	public Stack() {
		this.head = null;
	}

	// push
	public void push(int v) {
		NodeV2 n = new NodeV2(v);
		// first element in the stack
		if (head == null) {
			head = n;
			head.setMin(v); // this is the first element, so minimum of all elements below it (inclusive)
		} else {
			// insert at head
			n.setNext(head);
			int min_below = head.getMin();
			if (min_below > v)
				n.setMin(v);
			else
				n.setMin(min_below);
			head = n;
		}
	}

	// pop
	public int pop() {
		if (head == null) {
			return -1; // or throw an exception
		}
		NodeV2 temp = head;
		head = head.getNext();
		return temp.getVal();
	}

	// min
	public int min() {
		return head.getMin();
	}

	// peek
	public int peek() {
		if (head != null)
			return head.val;
		return -1; // or you can throw an exception
	}

	// empty check
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public String toString() {
		NodeV2 runner = head;
		StringBuilder sb = new StringBuilder();
		while (runner != null) {
			sb.append(runner.getVal() + " ");
			runner = runner.getNext();
		}
		return sb.toString().trim();
	}
}
