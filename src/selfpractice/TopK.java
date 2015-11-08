package selfpractice;

import java.util.Arrays;

public class TopK {
	public static void main(String[] args) {
		int a[] = { 1, 23, 12, 9, 2, 50 };
		int k = 3;
		TopK self = new TopK();
		int res[] = self.getTopK(a, k);
		printArray(res, k);
		System.out.println("Done");
	}

	public int[] getTopK(int[] a, int k) {
		// return bubbleK(a, k);
		return tempArray(a, k);
	}

	/**
	 * Bubble sort for the first K elements
	 * O(N * K)
	 * 
	 * @param a
	 * @return
	 */
	private int[] bubbleK(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] < a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		return a;
	}

	private int[] tempArray(int[] a, int k) {
		int buffer[] = new int[k];

		// Step 1 - O(K)
		int imin = 0;
		for (int i = 0; i < buffer.length; i++) {
			buffer[i] = a[i];
			if (a[imin] > a[i])
				a[imin] = a[i];
		}

		// Step 2 - O(N-K * K)
		for (int i = k; i < a.length; i++) {
			if (a[i] > buffer[imin]) {
				buffer[imin] = a[i];
				imin = findMinIndex(buffer); /* O(K) */
			}
		}

		Arrays.sort(buffer); /* O(K * log(K) ) */
		return buffer;
	}

	private int findMinIndex(int[] a) {
		int imin = 0;
		for (int i = 1; i < a.length; i++) {
			if (a[i] < a[imin])
				imin = i;
		}
		return imin;
	}

	private static void printArray(int[] a, int k) {
		for (int i = 0; i < k; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
}
