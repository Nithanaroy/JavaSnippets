package fulltimepractice;

/**
 * Predict stock prices for the missing prices 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class GoDaddy_Round3 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		HashMap<Timestamp, Float> prices = getPrices(n, br); // read from STDIN
		int line[] = fitLine(prices); // RMSE
		// float price = predict(line, day); // Prediction using the curve
	}

	private static HashMap<Timestamp, Float> getPrices(int n, BufferedReader br) throws IOException, ParseException {
		HashMap<Timestamp, Float> prices = new HashMap<>(n);
		SimpleDateFormat sdf = new SimpleDateFormat("M/D/y k:m:s");
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			String[] date_price = line.split("\t");

			Timestamp timestamp = new Timestamp(sdf.parse(date_price[0].trim()).getTime());
			try {
				prices.put(timestamp, Float.parseFloat(date_price[1].trim()));
			} catch (Exception e) {
				prices.put(timestamp, -1.0F); // prices to be predicted
			}
		}
		return prices;
	}

	private static int[] fitLine(HashMap<Timestamp, Float> prices) {
		return null;
		// y = m*x + c

		// for()

	}
}
