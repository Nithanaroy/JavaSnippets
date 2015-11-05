package fulltimepractice;

/**
 * Given aaaabbcdde, should print a4b2cd2e
 */

import java.io.IOException;

public class GoDaddy_Compression {
	static String compress(String str) {
		String res = "";
		for (int i = 0; i < str.length(); ) {
			char c = str.charAt(i);
			int count = 1;
			for (int j = i + 1; j < str.length(); j++) {
				if (str.charAt(j) != c) {
					break;
				}
				count++;
			}
			if (count == 1) {
				res += (c + "");
			} else {
				res += (c + "") + (count + "");
			}
			i += count;
		}
		return res;
	}

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		String res;
		String _str = "aaaabbcdde";
		// try {
		// _str = in.nextLine();
		// } catch (Exception e) {
		// _str = null;
		// }
		//
		res = compress(_str);
		System.out.println(res);
		// bw.write(res);
		// bw.newLine();
		//
		// bw.close();
	}
}