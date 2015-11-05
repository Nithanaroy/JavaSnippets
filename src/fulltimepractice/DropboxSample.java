package fulltimepractice;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.nio.channels.SeekableByteChannel;
import java.util.regex.*;

public class DropboxSample {

	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		// String[] res;
		//
		// int _input_strings_size = Integer.parseInt(in.nextLine());
		// String[] _input_strings = new String[_input_strings_size];
		// String _input_strings_item;
		// for (int _input_strings_i = 0; _input_strings_i < _input_strings_size; _input_strings_i++) {
		// try {
		// _input_strings_item = in.nextLine();
		// } catch (Exception e) {
		// _input_strings_item = null;
		// }
		// _input_strings[_input_strings_i] = _input_strings_item;
		// }
		//
		// res = say_what_you_see(_input_strings);
		// for (int res_i = 0; res_i < res.length; res_i++) {
		// bw.write(String.valueOf(res[res_i]));
		// bw.newLine();
		// }
		//
		// bw.close();

		String s[] = { "321550" };
		say_what_you_see(s);
	}

	static String[] say_what_you_see(String[] input_strings) {
		int inp_len = input_strings.length;
		String res[] = new String[inp_len];
		for (int j = 0; j < inp_len; j++) {
			String s = input_strings[j];
			String curr_res = "";
			int len = s.length();
			for (int i = 0; i < len;) {
				int count = get_counts(s, i);
				curr_res += count + "" + s.charAt(i);
				i += count;
			}
			System.out.println(curr_res);
			res[j] = curr_res;
		}
		return res;
	}

	static int get_counts(String v, int s) {
		char t = v.charAt(s);
		int count = 1;
		for (int i = s + 1; i < v.length(); i++) {
			char c = v.charAt(i);
			if (t == c)
				count++;
			else
				break;
		}
		return count;
	}
}