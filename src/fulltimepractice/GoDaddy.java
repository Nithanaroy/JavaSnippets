package fulltimepractice;

/**
 * Given an array check if it has a balancedSum, which is, a split point 's', in the array where 
 * sum(left side of the array) == sum(right side of the array) 
 * 
 * @author nitinpasumarthy
 *
 */

public class GoDaddy {
	static int isBalanced(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int ls = getLeftSum(i, a);
			int rs = getRightSum(i, a);
			if (ls == rs)
				return 1;
		}
		return 0;
	}

	static int getLeftSum(int i, int a[]) {
		i--;
		int sum = 0;
		while (i >= 0) {
			sum += a[i];
			i--;
		}
		return sum;
	}

	static int getRightSum(int i, int a[]) {
		i++;
		int sum = 0;
		while (i < a.length) {
			sum += a[i];
			i++;
		}
		return sum;
	}

	public static void main(String[] args) {
		int a[] = { 1, 2, 3 };
		isBalanced(a);
	}
}
