package selfpractice.leetcode;

public class MaxStockProfit {
	public static void main(String[] args) {
		int prices[] = { 1, 2, 3 };
		System.out.println(maxProfit(prices));
		// Correct Logic: For every consecutive days i+1 and i, if tomorrow's price is higher than today's, we buy it today and sell tomorrow, else we dont do anything
	}

	/**
	 * Incorrect implementation
	 * 
	 * @param prices
	 * @return
	 */
	public static int maxProfit(int[] prices) {
		int P[] = new int[prices.length];
		P[0] = -prices[0]; // buy on day 0 TODO: May not true
		boolean canSell = true;
		for (int i = 1; i < prices.length; i++) {
			int B = buy(prices, P, i);
			int S = sell(prices, P, i);
			int N = P[i - 1];
			if (canSell) {
				if (B > S && B > N) {
					P[i] = B;
					canSell = true;
				} else if (S > B && S > N) {
					P[i] = S;
					canSell = false;
				} else {
					P[i] = N;
				}
			} else {
				if (B > S && B > N) {
					P[i] = B;
					canSell = true;
				} else {
					P[i] = N;
				}
			}
		}
		return P[prices.length - 1];
	}

	private static int buy(int[] prices, int[] P, int i) {
		return P[i - 1] - prices[i];
	}

	private static int sell(int[] prices, int[] P, int i) {
		return P[i - 1] + prices[i];
	}
}
