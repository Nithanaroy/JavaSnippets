package selfpractice;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class General {
	public static void main(String[] args) {
		// checkingOutPrioQueue();
		// exploringStack();
		System.out.println(Math.pow(2, 99));
		System.out.println("# recursive calls: " + counter);
	}

	private static int counter = -1;

	private static int fib(int n) {
		counter++;
		if (n < 1)
			return 1;
		else
			return fib(n - 1) + fib(n - 2) + fib(n - 3) + fib(n - 4);
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
