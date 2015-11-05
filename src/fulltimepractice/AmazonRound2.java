package fulltimepractice;

import java.util.ArrayList;

/**
 * Given a 2D array see if there is a path from (0,0) to (X,Y)
 * Note: The below code works, but only 16 of 30 test cases passed. Dont know what error is thrown, probably, stackoverflow
 * Idea: Treat this as a graph and do a BFS
 * 
 * @author Nitin Pasumarthy
 *
 */
public class AmazonRound2 {
	public static void main(String[] args) {
		int[][] grid = { { 1, 0, 1, 1, 1, 0, 0, 1 }, { 1, 0, 0, 0, 1, 1, 1, 1 }, { 1, 0, 0, 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 9, 0, 1, 1 },
				{ 1, 1, 1, 0, 1, 0, 0, 1 }, { 1, 0, 1, 0, 1, 1, 0, 1 }, { 1, 0, 0, 0, 0, 1, 0, 1 }, { 1, 1, 1, 1, 1, 1, 1, 1 } };
		// int[][] grid = { { 1, 1, 1 }, { 9, 1, 1 }, { 0, 1, 0 } };
		System.out.println(isPath(grid));
	}

	public static int isPath(int[][] grid) {
		boolean res = helper2(0, 0, grid);
		if (res)
			return 1;
		return 0;
	}

	private static boolean helper(int i, int j, int[][] g) {
		boolean res;

		int ni = i, nj = j + 1;
		res = recurse(g, ni, nj);
		if (res)
			return res;

		// ni = i + 1;
		// nj = j + 1;
		// res = recurse(g, ni, nj);
		// if (res)
		// return res;

		ni = i + 1;
		nj = j;
		res = recurse(g, ni, nj);
		if (res)
			return res;

		// ni = i + 1;
		// nj = j - 1;
		// res = recurse(g, ni, nj);
		// if (res)
		// return res;

		ni = i;
		nj = j - 1;
		res = recurse(g, ni, nj);
		if (res)
			return res;

		// ni = i - 1;
		// nj = j - 1;
		// res = recurse(g, ni, nj);
		// if (res)
		// return res;

		ni = i - 1;
		nj = j;
		res = recurse(g, ni, nj);
		if (res)
			return res;

		// ni = i - 1;
		// nj = j + 1;
		// res = recurse(g, ni, nj);
		// if (res)
		// return res;

		return false;

		// return helper(i, j + 1, g) || helper(i + 1, j, g) || helper(i, j - 1, g) || helper(i - 1, j, g);
	}

	private static boolean recurse(int[][] g, int ni, int nj) {
		if (isValidIndex(ni, nj, g) && g[ni][nj] != 0) {
			if (g[ni][nj] == 9)
				return true;
			return helper(ni, nj, g);
		}
		return false;
	}

	static ArrayList<String> covered = new ArrayList<String>();

	private static boolean helper2(int i, int j, int[][] g) {
		if (i < 0 || i >= g.length || j < 0 || j >= g[0].length)
			return false;
		if (covered.indexOf(i + "" + j) > 0)
			return false;

		covered.add(i + "" + j);
		if (g[i][j] == 0)
			return false;
		if (g[i][j] == 9)
			return true;
		return helper2(i, j + 1, g) || helper2(i + 1, j + 1, g) || helper2(i + 1, j, g) || helper2(i + 1, j - 1, g) || helper2(i, j - 1, g)
				|| helper2(i - 1, j - 1, g) || helper2(i - 1, j, g) || helper2(i - 1, j + 1, g);

		// return helper(i, j + 1, g) || helper(i + 1, j + 1, g) || helper(i + 1, j, g);

		// return helper2(i, j + 1, g) || helper2(i + 1, j, g) || helper2(i, j - 1, g) || helper2(i - 1, j, g);
	}

	private static boolean isValidIndex(int i, int j, int[][] g) {
		if (i < 0 || i >= g.length || j < 0 || j >= g[0].length)
			return false;
		return true;
	}
}
