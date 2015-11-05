package tests;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		// Scanner in = new Scanner(System.in);
		// final String fileName = System.getenv("OUTPUT_PATH");
		// BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
		// int res;
		// String _s;
		// try {
		// _s = in.nextLine();
		// } catch (Exception e) {
		// _s = null;
		// }
		//
		// String _t;
		// try {
		// _t = in.nextLine();
		// } catch (Exception e) {
		// _t = null;
		// }

		String _s = "aabb", _t = "ab";
		int res = maxRounds(_s, _t);
		System.out.println(res);
		// bw.write(String.valueOf(res));
		// bw.newLine();
		//
		// bw.close();
	}

	 static int maxRounds(String s, String t) {
	 int count = 0;
	 while (true) {
	 int r = s.indexOf(t, 0);
	 if (r < 0)
	 break;
	 String s1 = s.substring(0, r);
	 String s2 = s.substring(r + t.length(), s.length());
	 s = s1 + s2;
	 count++;
	 }
	 return count;
	 }

	// static int gcount = 0;
	//
	// static int maxRounds(String s, String t) {
	// int count = 0;
	// int index = s.indexOf(t);
	// while (index >= 0) {
	// // System.out.println(index);
	// String s1 = s.substring(0, index);
	// String s2 = s.substring(index + t.length(), s.length());
	// s = s1 + s2;
	// count++;
	// int _count = maxRounds(s, t);
	// if (_count > count)
	// count = _count;
	// index = s.indexOf(t, index + 1);
	// }
	// gcount += count;
	//
	// return gcount;
	// }
}