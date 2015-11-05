package fulltimepractice;

import java.util.ArrayList;

public class AmazonRound1 {
	public static void main(String[] args) {
		ArrayList<Integer> l = getList();
		System.out.println(calculateWindowSums(l, 2));
	}

	private static ArrayList<Integer> getList() {
		int elements[] = { 4, 2, 73, 11, -5 };
		ArrayList<Integer> l = new ArrayList<>();
		for (Integer e : elements) {
			l.add(e);
		}
		return l;
	}

	public static ArrayList<Integer> calculateWindowSums(ArrayList<Integer> list, int windowSize) {
		// WRITE YOUR CODE HERE
		ArrayList<Integer> a = new ArrayList<Integer>();
		int k = 0;
		int lower = 0;
		int upper = k + windowSize - 1;
		int size = list.size();
		// For the first window
		
		while (upper < size) {
			int sum = getSum(list, lower, upper, size);
			a.add(sum);
			lower++;
			upper++;
		}
		return a;
	}

	private static int getSum(ArrayList<Integer> list, int lower, int upper, int size) {
		int sum = 0;
		for (int i = lower; i <= upper && upper < size; i++) {
			sum += list.get(i);
		}
		return sum;
	}
}
