package selfpractice.leetcode;

/**
 * https://leetcode.com/problems/basic-calculator/
 * 
 * @author nitinpasumarthy
 *
 */
public class BasicCalculator {
	public static void main(String[] args) {
		// System.out.println(eval("(1+(4+5+2)-3)+(6+8)", 0)[0]);
		System.out.println(eval("1+ (1+1)", 0)[0]);
	}

	private static int[] eval(String s, int i) {
		int res = 0, temp[];
		s = s.trim();
		char opcode = '+';

		// int temp[] = extractOperand(s, i);
		// res = temp[0];
		// i = temp[1];

		while (i < s.length()) {
			temp = extractOperand(s, i);
			int op2 = temp[0];
			i = temp[1];
			if (op2 == -1) {
				// new expression starts
				temp = eval(s, ++i);
				op2 = temp[0];
				i = temp[1];
			}

			if (i < s.length()) {
				opcode = s.charAt(i++);
				if (opcode == ')')
					return new int[] { res, i };
			}

			switch (opcode) {
			case '+':
				res += op2;
				break;
			case '-':
				res -= op2;
				break;
			}
		}

		return new int[] { res, i };
	}

	private static int[] extractOperand(String s, int i) {
		int res[] = new int[2];
		StringBuilder sb = new StringBuilder();
		for (; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				res[0] = -1;
				res[1] = i;
				return res;
			}
			if (c == '+' || c == '-' || c == ')')
				break;
			sb.append(c);
		}
		res[0] = Integer.parseInt(sb.toString().trim());
		res[1] = i;
		return res;
	}
}
