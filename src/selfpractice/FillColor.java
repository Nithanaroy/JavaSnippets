package selfpractice;

public class FillColor {
	public static void main(String[] args) {
		char[][] a = { { 'R', 'M', 'M', 'M', 'Z' }, { 'W', 'R', 'Y', 'O', 'O' }, { 'W', 'W', 'R', 'R', 'Y' }, { 'W', 'G', 'R', 'R', 'B' },
				{ 'W', 'G', 'G', 'G', 'B' } };
		printImage(a);
		paint(a, 1, 1, 'P');
		System.out.println();
		printImage(a);
	}

	private static void printImage(char[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Paint the Grid
	 * 
	 * @param a Grid of colors
	 * @param r row where the mouse struck
	 * @param c column where the mouse struck
	 * @param color new color to re paint
	 */
	public static void paint(char[][] a, int r, int c, char color) {
		fill(a[r][c], color, r, c, a);
	}

	private static void fill(char s, char d, int r, int c, char[][] a) {
		// array bounds check
		if (r < 0 || c < 0 || r > a.length || c > a[0].length)
			return;
		// color check
		if (a[r][c] == s) {
			a[r][c] = d;

			fill(s, d, r - 1, c, a);
			fill(s, d, r, c - 1, a);
			fill(s, d, r - 1, c - 1, a);
			fill(s, d, r + 1, c - 1, a);
			fill(s, d, r + 1, c, a);
			fill(s, d, r + 1, c + 1, a);
			fill(s, d, r, c + 1, a);
			fill(s, d, r - 1, c + 1, a);
		}
	}
}
