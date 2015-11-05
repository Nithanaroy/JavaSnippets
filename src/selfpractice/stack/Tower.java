package selfpractice.stack;

/**
 * Just like stack except it is an ascending stack based on value of node, like tower of hanoi
 * 
 * @author nitinpasumarthy
 *
 */
public class Tower {
	private Stack s;

	public Tower() {
		s = new Stack();
	}

	public boolean push(int v) {
		if (s.isEmpty()) {
			s.push(v);
			return true;
		} else {
			if (v >= s.peek()) {
				throw new IllegalArgumentException("Cannot push " + v + " onto " + s.peek());
			} else {
				s.push(v);
				return true;
			}
		}
	}

	public int pop() {
		return s.pop();
	}
	
	@Override
	public String toString() {
		return s.toString();
	}
}
