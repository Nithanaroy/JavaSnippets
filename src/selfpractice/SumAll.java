package selfpractice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SumAll {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		final String fileName = System.getenv("OUTPUT_PATH");
		BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		long res;

		int _arr_size = Integer.parseInt(in.nextLine());
		int[] _arr = new int[_arr_size];
		int _arr_item;
		for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
			_arr_item = Integer.parseInt(in.nextLine());
			_arr[_arr_i] = _arr_item;
		}

		res = sumOfIntegers(_arr);
		bw.write(String.valueOf(res));
		bw.newLine();

		in.close();
		bw.close();
	}

	static long sumOfIntegers(int[] arr) {
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
}