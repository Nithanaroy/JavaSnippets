package selfpractice;

/**
 * The maximum sum in an array
 * 
 * @author nitin
 *
 */

public class MaxSumSubSeq {

	private static final int NEGINFINITY = -1000000;

	public static void main(String[] args) {
		int nums[] = { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		System.out.println("Given:");
		printArray(nums);
		
		int result[] = maxSum(nums);
		
		System.out.format("\nStart at index, %d and end at index %d in the array to get a sum, %d\n", result[0],
				result[1], result[2]);
		System.out.println("\nSub array is:");
		printArray(nums, result[0], result[1]);
	}

	public static int[] maxSum(int nums[]) {
		return _maxSum(nums, 0, nums.length);
	}

	private static int[] _maxSum(int nums[], int start, int end) {
		// base cases
		if (end - start == 1) {
			// only 1 element
			return new int[] { 0, 0, nums[start] };
		} else if (start >= end) {
			// no elements in the array
			return new int[] { -1, -1, NEGINFINITY };
		}

		int sresult[] = { 0, 0, 0 }, lresult[] = { 0, 0, 0 }, rresult[] = { 0, 0, 0 };
		int m = (start + end) / 2;
		lresult = _maxSum(nums, start, m);
		rresult = _maxSum(nums, m, end);
		sresult = maxSplit(nums, start, end);

		// return the max sum from lresult, rresult, sresult
		if (sresult[2] > lresult[2] && sresult[2] > rresult[2]) {
			return sresult;
		} else if (rresult[2] > sresult[2] && rresult[2] > lresult[2]) {
			return rresult;
		} else {
			return lresult;
		}
	}

	private static int[] maxSplit(int nums[], int start, int end) {
		int result[] = { 0, 0, 0 };
		int m = (start + end) / 2;
		int sum = 0;
		int maxLeftSum = NEGINFINITY, maxRightSum = NEGINFINITY;
		int maxLeftIndex = -1, maxRightIndex = -1;
		for (int i = m - 1; i >= start; i--) {
			sum += nums[i];
			if (sum > maxLeftSum) {
				maxLeftSum = sum;
				maxLeftIndex = i;
			}
		}

		sum = 0;
		for (int i = m; i < end; i++) {
			sum += nums[i];
			if (sum > maxRightSum) {
				maxRightSum = sum;
				maxRightIndex = i;
			}
		}

		result[0] = maxLeftIndex;
		result[1] = maxRightIndex;
		result[2] = maxLeftSum + maxRightSum;
		return result;
	}

	private static void printArray(int nums[]) {
		printArray(nums, 0, nums.length - 1);
	}

	/**
	 * Print array from 'from' index to 'to' index (included). Zero based
	 */
	private static void printArray(int nums[], int from, int to) {
		for (int i = from; i <= to; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println();
	}
}
