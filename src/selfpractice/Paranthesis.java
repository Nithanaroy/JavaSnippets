package selfpractice;

import java.util.ArrayList;

/**
 * Given number of available paranthesis, print all combinations of valid paranthesis pairs
 * 
 * @author nitinpasumarthy
 *
 */
public class Paranthesis {
	public static void main(String[] args) {
		System.out.println(getParanCombinations(3));
	}

	public static ArrayList<String> getParanCombinations(int n) {
		ArrayList<String> r = new ArrayList<>();
		char[] c = new char[2 * n];
		paran(n, n, c, 0, r);
		return r;
	}

	private static void paran(int l, int r, char[] c, int index, ArrayList<String> res) {
		if (l > r)
			return;

		if (l == 0 && r == 0) {
			res.add(new String(c));
		}
		if (l > 0) {
			c[index] = '(';
			paran(l - 1, r, c, index + 1, res);
		}
		if (r > 0) {
			c[index] = ')';
			paran(l, r - 1, c, index + 1, res);
		}
	}

	@SuppressWarnings("unused")
	private static <T> String join(ArrayList<T> s) {
		StringBuilder sb = new StringBuilder();
		for (T a : s) {
			sb.append(a);
		}
		return sb.toString();
	}
}
