package fulltimepractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GoogleRound1 {
	public static void main(String[] args) {
		int a[] = { 3, 2, 2, 1 };
		int b[] = { 4, 2, 1, 5 };
		ArrayList<Integer> s = diff(b, a);
		System.out.println(s);

		System.out.println(FindSum(a, 6));
		System.out.println(SuperSum(a, 6));
	}

	/**
	 * Question 1: Difference of 2 arrays
	 * 
	 * @param a Array 1
	 * @param b Array 2
	 * @return a - b
	 */
	private static ArrayList<Integer> diff(int[] a, int[] b) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> h = new HashMap<>();

		for (int i : b) {
			if (!inc(h, i, 1)) {
				h.put(i, 1);
			}
		}

		for (int i : a) {
			if (!h.containsKey(i)) {
				res.add(i);
			} else {
				int count = h.get(i);
				if (count > 0)
					inc(h, i, -1);
				else
					res.add(i);
			}
		}

		return res;
	}

	private static boolean inc(HashMap<Integer, Integer> h, int key, int value) {
		if (h.containsKey(key)) {
			int count = h.get(key);
			count += value;
			h.put(key, count);
			return true;
		}
		return false;
	}

	/**
	 * Check if sum of two elements in the array add upto k
	 * 
	 * @param arr
	 * @param k
	 * @return true if they add up, else false
	 */
	private static boolean FindSum(int[] arr, int k) {
		Arrays.sort(arr);
		int left = 0, r = arr.length - 1;
		while (left < r) {
			int sum = arr[left] + arr[r];
			if (sum < k)
				left++;
			else if (sum == k)
				return true;
			else
				r--;
		}
		return false;
	}

	/**
	 * Check if sum of three elements add upto k
	 * 
	 * @param arr
	 * @param k
	 * @return true if they add up, else false
	 */
	private static boolean SuperSum(int[] arr, int k) {
		Arrays.sort(arr);
		for (int i : arr) {
			int k1 = k - i;
			boolean result = FindSum(arr, k1);
			if (result == true)
				return true;
		}
		return false;
	}
}
