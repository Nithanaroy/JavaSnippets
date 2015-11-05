package selfpractice;

/**
 * Prints all the permutations for a given string
 * The trick: Every level of recursion, we fix one more 
 * character from previous recursive call in the beginning of the string.
 * Every character swaps with the first character of the non-fixed
 * part of the string!
 * http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
 * @author Nitin Pasumarthy
 *
 */

public class Permutations {
	public static void main(String[] args) {
		permute("ABCD");
	}

	public static void permute(String x) {
		_permute(x, 0);
	}

	/**
	 * Prints all permutations of str
	 * 
	 * @param str
	 *            String to permute
	 * @param index
	 *            starting of string in consideration. used for recursion
	 */
	private static void _permute(String str, int index) {
		int actualLength = str.length();
		int len = actualLength - index;
		if (len > 2) {
			for (int i = index; i < actualLength; i++) {
				String newStr = swapCharacters(str, index, i);
				_permute(newStr, index + 1);
			}
		} else if (len == 1) {
			System.out.println(str);
		} else if (len == 0) {
			System.out.println("Empty input. Nothing to do");
		} else {
			// i.e. len == 2
			System.out.println(str);
			System.out.println(swapCharacters(str, index, index + 1));
		}
	}

	/**
	 * Swaps characters of the string
	 * 
	 * @param str
	 *            string to perform the swap in
	 * @param i
	 *            first index character of swap
	 * @param j
	 *            second index character of swap
	 * @return new string after swapping
	 */
	private static String swapCharacters(String str, int i, int j) {
		char[] charArray = str.toCharArray();
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return new String(charArray);
	}
}
