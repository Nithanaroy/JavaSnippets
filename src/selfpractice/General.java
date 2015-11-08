package selfpractice;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class General {
	public static void main(String[] args) {
		// checkingOutPrioQueue();
		exploringStack();
	}

	private static void exploringStack() {
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(1);
		stack.push(3);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

	private static void checkingOutPrioQueue() {
		Queue<Integer> p = new PriorityQueue<>();
		p.add(12);
		p.add(1);
		p.add(15);
		System.out.println(p.peek());
		System.out.println(p.poll());
		System.out.println(p.peek());
	}
}
