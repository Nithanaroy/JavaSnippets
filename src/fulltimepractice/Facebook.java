package fulltimepractice;

public class Facebook {
	/*
	 * Given a circularly sorted array, find an element in it
	 * 7 8 9 1 2 3 4 
	 * fn(arr, elem) -> index of elem 
	 * fn(arr, 9) -> 2
	 */

	// O(logF(N))
	//
	// a[i] > a[i+1]
	//
	// Inversion: a[0-i] & a[i+1 to n]
	// findSplit => O(logN)
	// PerformBinarySearch O(log2(n))
	// Total => O(N)

	// Space Complexity: O(log2(N)), tail recursion => O(1)
	// Time: O(log2(N))

	private int findSplit(int arr[], int start, int end) {
		// base case
		if (start - end == 1) {
			if (arr[start] > arr[end])
				return start; // inversion exists
			else
				return -1; // sorted
		}

		// len(arr) > 2
		int m = (start + end) / 2;
		// check start, m elem and decide which side to recurse
		if (arr[start] < arr[m])
			return findSplit(arr, m + 1, end);
		else if (arr[m] > arr[m + 1])
			return m; // split inv case
		else
			return findSplit(arr, start, m);
	}
}
