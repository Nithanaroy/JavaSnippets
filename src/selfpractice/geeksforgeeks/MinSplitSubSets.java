package selfpractice.geeksforgeeks;

import java.util.Arrays;

/**
 * Problem: http://www.geeksforgeeks.org/partition-a-set-into-two-subsets-such-that-the-difference-of-subset-sums-is-minimum/
 * 
 * @author nitinpasumarthy
 *
 */

public class MinSplitSubSets {
	public static void main(String[] args) {
		// int arr[] = { 100, 6, 11, 5 };
		// int arr[] = { 298, 718, 240, 216, 514, 619, 622, 291, 356, 797, 140, 711, 477, 490, 663, 934, 312, 475, 911, 260, 688, 843, 880,
		// 528, 766, 94, 983, 176, 622 };
		int arr[] = { 87, 844, 430, 835, 681, 815, 565, 904, 414, 408, 868, 833, 893, 789, 592, 326, 87, 489, 169, 293, 371, 285, 39, 15,
				278, 103, 22, 594, 488 };
//		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.format("i: %d, Mine: %d. His: %d\n", i, myAnswer(arr, i), correctAnswer(arr, i));
		}

	}

	private static int myAnswer(int[] s, int n) {
		// int n = s.length;
		int s1[] = new int[n + 1];
		int s2[] = new int[n + 1];
		if (n > 0) {
			s1[1] = s[0];
			s2[1] = 0;

			// start from 2nd element
			for (int i = 1; i < n; i++) {
				int a = s1[i] + s[i];
				int b = s2[i] + s[i];

				if (a < b) {
					s1[i + 1] = a;
					s2[i + 1] = s2[i];
				} else {
					s2[i + 1] = b;
					s1[i + 1] = s1[i];
				}
			}
		}

		return Math.abs(s1[n] - s2[n]);
	}

	// Returns the minimum value of the difference of the two sets.
	private static int correctAnswer(int arr[], int n) {
		// Calculate sum of all elements
		int sum = 0;
		for (int i = 0; i < n; i++)
			sum += arr[i];

		// Create an array to store results of subproblems
		boolean dp[][] = new boolean[n + 1][sum + 1];

		// Initialize first column as true. 0 sum is possible
		// with all elements.
		for (int i = 0; i <= n; i++)
			dp[i][0] = true;

		// Initialize top row, except dp[0][0], as false. With
		// 0 elements, no other sum except 0 is possible
		for (int i = 1; i <= sum; i++)
			dp[0][i] = false;

		// Fill the partition table in bottom up manner
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				// If i'th element is excluded
				dp[i][j] = dp[i - 1][j];

				// If i'th element is included
				if (arr[i - 1] <= j)
					dp[i][j] |= dp[i - 1][j - arr[i - 1]];
			}
		}

		// Initialize difference of two sums.
		int diff = 100000;

		// Find the largest j such that dp[n][j]
		// is true where j loops from sum/2 t0 0
		for (int j = sum / 2; j >= 0; j--) {
			// Find the
			if (dp[n][j] == true) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}
}
