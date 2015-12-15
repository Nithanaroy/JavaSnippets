package selfpractice.geeksforgeeks;

/**
 * Number of ways to reach from Source to Destination with at most K turns in a 2D grid
 * http://www.geeksforgeeks.org/count-number-of-paths-with-k-turns/
 * 
 * @author nitinpasumarthy
 *
 */
public class KTurns {
	public static void main(String[] args) {
		int m = 1, n = 1, k = 2;
//		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
//		print2DArray(grid, m, n);
//
//		m = 1;
//		n = 2;
//		k = 2;
//		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
//		print2DArray(grid, m, n);
//
//		m = 2;
//		n = 1;
//		k = 2;
//		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
//		print2DArray(grid, m, n);
//
//		m = 2;
//		n = 2;
//		k = 2;
//		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
//		print2DArray(grid, m, n);
//
		m = 3;
		n = 3;
		k = 1;
		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
		print2DArray(grid, m, n);
//		
//		m = 3;
//		n = 3;
//		k = 2;
//		System.out.format("m = %d, n = %d, k = %d, ways = %d\n", m, n, k, solve(m, n, k));
//		print2DArray(grid, m, n);

		System.out.println("Done");
	}

	public static int solve(int m, int n, int k) {
		grid = new int[m][n];
		int res = helper(m, n, new Cell(0, 1), new Cell(m - 1, n - 1), k, false)
				+ helper(m, n, new Cell(1, 0), new Cell(m - 1, n - 1), k, true);
		grid[0][0] = res;
		return res;
	}

	private static int[][] grid;

	private static int helper(int m, int n, Cell s, Cell d, int k, boolean fromTop) {
		if (k >= 0 && s.x < m && s.y < n) {
			if (s.equals(d))
				return 1;
			else if (s.y == d.y - 1 && s.x == d.x) {
				grid[s.x][s.y] = 1;
				return 1;
			} else if (s.x == d.x - 1 && s.y == d.y) {
				grid[s.x][s.y] = 1;
				return 1;
			} else {
				int res;
				if (fromTop) {
					res = helper(m, n, new Cell(s.x + 1, s.y), d, k, true) + helper(m, n, new Cell(s.x, s.y + 1), d, k - 1, false);
					grid[s.x][s.y] = res;
					return res;
				} else {
					res = helper(m, n, new Cell(s.x + 1, s.y), d, k - 1, true) + helper(m, n, new Cell(s.x, s.y + 1), d, k, false);
					grid[s.x][s.y] = res;
					return res;
				}
			}
		} else
			return 0;
	}

	/**
	 * prints 2D array
	 * 
	 * @param a 2D array
	 * @param m # rows
	 * @param n # columns
	 */
	private static void print2DArray(int[][] a, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}
}

class Cell {
	int x, y;

	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		try {
			Cell d = (Cell) o;
			return this.x == d.x && this.y == d.y;
		} catch (ClassCastException e) {
			return false;
		}
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}
