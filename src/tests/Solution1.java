package tests;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Solution1 {
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		// int res;
		//
		// int _numbers_size = Integer.parseInt(in.nextLine());
		// int[] _numbers = new int[_numbers_size];
		// int _numbers_item;
		// for (int _numbers_i = 0; _numbers_i < _numbers_size; _numbers_i++) {
		// _numbers_item = Integer.parseInt(in.nextLine());
		// _numbers[_numbers_i] = _numbers_item;
		// }
		//

		// int _numbers[] = { 1, 3, 1, 4, 5, 6, 2, 3 };
		int _numbers[] = { 1, 1, 1, 1, 1, 1, 1 };
		int res = countDuplicates(_numbers);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
	}

	static int countDuplicates(int[] numbers) {
		int count = 0;
		Map<Integer, Integer> a = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer v = a.get(numbers[i]);
			if (v == null)
				a.put(numbers[i], 0);
			else {
				v++;
				a.put(numbers[i], v);
			}
		}
		Object[] t = a.values().toArray();
		for (int i = 0; i < t.length; i++) {
			int b = (int) t[i];
			if (b > 0)
				count++;
		}
		return count;
	}
}
