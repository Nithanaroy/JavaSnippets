package selfpractice.stack;

public class StackRunner {

	public static void main(String[] args) {
		Stack s = createStack();
		System.out.format("Min in [%s]: %d\n", s, s.min());
		s.push(0);
		System.out.format("Min in [%s]: %d\n", s, s.min());
		s.pop(); s.pop();
		System.out.format("Min in [%s]: %d\n", s, s.min());
		s.pop(); 
		System.out.format("Min in [%s]: %d\n", s, s.min());
	}
	
	private static Stack createStack() {
		Stack s = new Stack();
		int a[] = {3, 6, 2, 1};
		for(int i : a) {
			s.push(i);
		}
		return s;
	}
}
