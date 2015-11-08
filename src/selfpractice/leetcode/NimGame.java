package selfpractice.leetcode;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/nim-game/
 * Note: Below solutions doesnt work
 * @author nitinpasumarthy
 *
 */
public class NimGame {
	public static void main(String[] args) {
		for (int i = 10; i <= 10; i++) {
			System.out.format("%2d stones. I win: %b\n", i, solve(i));
		}
	}

	public static boolean solve(int n) {
		return solveHelper(n, true);
	}

	private static ArrayList<String> debugStrings = new ArrayList<>();

	/**
	 * Says who wins the game
	 * 
	 * @param n number of stones
	 * @param myturn true if my turn
	 * @return true if I win, false if my friend wins
	 */
	private static boolean solveHelper(int n, boolean myturn) {
		StringBuilder sb = new StringBuilder();
		if (myturn) {
			sb.append("My turn. ");
		} else
			sb.append("\tNot my turn. ");

		if (n <= 3) {
			sb.append(n + " stones left. Win!!!");
			System.out.println(sb.toString());
			return myturn;
		} else if (n <= 6) {
			sb.append(n + " stones left. Lose");
			System.out.println(sb.toString());
			return !myturn;
		} else {

			sb.append(n + " stone(s) left. Picked ");

			boolean oneStoneRes, twoStonesRes = false, threeStonesRes = false;
			oneStoneRes = solveHelper(n - 1, !myturn);
			if (!oneStoneRes) {
				twoStonesRes = solveHelper(n - 2, !myturn);
				if (!twoStonesRes) {
					threeStonesRes = solveHelper(n - 3, !myturn);
					sb.append("3 stones");
				} else
					sb.append("2 stones");
			} else
				sb.append("1 stone");

			System.out.println(sb.toString());
			return oneStoneRes || twoStonesRes || threeStonesRes;
		}
	}
}
