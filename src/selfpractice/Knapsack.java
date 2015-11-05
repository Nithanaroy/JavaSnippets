package selfpractice;

/**
 * Classic Knapsack Problem
 * @author Nitin Pasumarthy
 * Tips: The array A which tracks the maximum value when using i items and j weight limit has i+1 rows and W+1 columns
 * There can be zero items or allowed weight can be zero. Hence both zero indices cannot be used to track 1st item or 1 weight limit
 * A[1][1] => 1 item available, 1 weight limit
 * A[1][0] => 1 item available, 0 weight limit
 * But the indices of values[] and weights[] run from 0 to n
 * "Be careful with indices of A, values and indices on line 28" 
 */
public class Knapsack {
	public static void main(String[] args) {
		int values[] = { 1, 2, 3, 4, 5 };
		int weights[] = { 1, 1, 1, 1, 1 };
		int W = 3;

		int A[][] = new int[values.length + 1][W + 1];
		for (int i = 0; i <= values.length; i++) {
			A[i][0] = 0; // value is zero when allowed weight is zero
		}
		for (int j = 0; j <= W; j++) {
			A[0][j] = 0; // value is zero when value of the item is zero
		}
		for (int i = 1; i <= values.length; i++) {
			for (int j = 1; j <= W; j++) {
				A[i][j] = Math.max(A[i - 1][Math.max(j - weights[i - 1], 0)] + values[i - 1], A[i - 1][j]);
			}
		}
		System.out.println(A[values.length][W]);
		
		// TODO: Track the items are included using A[][]
	}

}
