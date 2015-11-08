package selfpractice.leetcode;

/**
 * Also called digital root
 * Digital Root of 11 = 2, that is 11 - 2 is a multiple of 9.
 * My inference: Same as % 9, except when 'n' is a multiple of 9, Digital Root returns 9, but % 9 returns 0
 * 
 * @author nitinpasumarthy
 *
 */
public class SumOfDigits {
	public static void main(String[] args) {
		int n = 1853;
		System.out.println(sumDigits(n) + " " + (n % 9));
	}

	public static int sumDigits(int n) {
		System.out.println(n);
		int sum = 0;
		do {
			sum += n % 10;
			n /= 10;
		} while (n > 0);
		if (sum / 10 > 0)
			return sumDigits(sum);
		else
			return sum;
	}

	public static int otherSolutionByMath(int num) {
		if (num < 10) /* to handle case: num = 0 */
			return num;

		int mod = num % 9;
		if (mod == 0)
			return 9;
		else
			return mod;
	}
}
