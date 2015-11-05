package selfpractice;

public class SeqAlignment {
	public static void main(String[] args) {
		String X = "AGGGCT", Y = "AGGCA";
		int cgap = 15, cmm = 5;
		int m = X.length(), n = Y.length();
		int A[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			A[i][0] = i * cgap;
		}
		for (int i = 0; i <= n; i++) {
			A[0][i] = i * cgap;
		}
		print2DArray(A);
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				A[i][j] = Math.min(A[i - 1][j] + cgap,
						Math.min(A[i][j - 1] + cgap, A[i - 1][j - 1] + costOfMisMatch(X.charAt(i - 1), Y.charAt(j - 1), cmm)));
			}
		}
		print2DArray(A);
		System.out.format("Total penality: %d\n", A[m][n]);

		extractAlignment(X, Y, cgap, m, n, A);
	}

	private static void extractAlignment(String X, String Y, int cgap, int m, int n, int[][] A) {
		StringBuilder X1 = new StringBuilder(), Y1 = new StringBuilder();
		for (int i = m; i > 0;) {
			for (int j = n; j > 0;) {
				// Case 1: Character from X is used, Character from Y is not used
				if (A[i][j] == A[i][j - 1] + cgap) {
					X1.insert(0, ' ');
					Y1.insert(0, Y.charAt(j - 1));
					j--;
					// System.out.println("Case 1");
				}

				// Case 2: Character from Y is used, Character from X is not used
				else if (A[i][j] == A[i - 1][j] + cgap) {
					X1.insert(0, X.charAt(i - 1));
					Y1.insert(0, ' ');
					i--;
					// System.out.println("Case 2");
				}

				// Case 3: Character from X and Y are used
				else {
					X1.insert(0, X.charAt(i - 1));
					Y1.insert(0, Y.charAt(j - 1));
					i--;
					j--;
					// System.out.println("Case 3");
				}
			}
		}
		System.out.format("X: %s\nY: %s", X1, Y1);
	}

	private static int costOfMisMatch(char a, char b, int cmm) {
		if (a == b) {
			return 0;
		}
		return cmm;
	}

	private static void print2DArray(int A[][]) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				System.out.format("%-2d ", A[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}
}
