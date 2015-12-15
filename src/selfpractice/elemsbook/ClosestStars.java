package selfpractice.elemsbook;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Problem 11.2
 * 
 * @author nitinpasumarthy
 *
 */
public class ClosestStars {

	private static final int HEAP_SIZE = 3; // l

	public static void main(String[] args) {
		int distances[] = { 23, 34, 75, 20, 34, 68, 9, 24, 9, 98 };
		System.out.println(getKFarthest(distances, 4));

		Arrays.sort(distances);
		System.out.println(distances);

		System.out.println("Done");
	}

	public static int[] getKFarthest(int d[], int k) {
		Queue<Integer> q = new PriorityQueue<>(k);
		int i = 0;
		int res[] = new int[k];

		// O(k)
		while (i < k) {
			// Only HEAP_SIZE elements are in memory
			for (; i < HEAP_SIZE; i++) {
				q.add(d[i]);
			}
		}

		while (i < d.length) {
			// Only HEAP_SIZE elements are in memory
			for (int j = 0; j < HEAP_SIZE && i < d.length; j++) {
				if (q.peek() < d[i]) {
					q.poll();
					q.add(d[i]);
				}
				i++;
			}
		}

		for (int j = 0; j < k; j++) {
			res[j] = q.poll();
		}

		return res;
	}
}
