package selfpractice.elemsbook;

/**
 * Search in a cyclically sorted array. Problem 12.2
 * 
 * @author nitinpasumarthy
 *
 */
public class CyclicSortedArraySearch {
	public static void main(String[] args) {
		// int a[] = { 550, 631, 103, 203, 220, 234, 279, 368, 378, 478 };
		// int a[] = { 631, 103, 203, 220, 234, 279, 368, 378, 478, 550 }; // border case 1
		int a[] = { 203, 220, 234, 279, 368, 378, 478, 550, 631, 103 }; // border case 2
		System.out.println(findSplit(a));
		System.out.println("Done");
	}

	public static int findSplit(int a[]) {
		return findSplitHelper(a, 0, a.length - 1);
	}

	/**
	 * Finds split in an ascending cyclic sorted array
	 * 
	 * @param a
	 * @param l
	 * @param h
	 * @return
	 */
	private static int findSplitHelper(int a[], int l, int h) {
		if (h - l == 1) {
			// Only 2 elements in the array
			if (a[h] < a[l])
				return h;
			else
				return -1; // no cycle found
		}

		if (h == l) {
			return -1; // only one element
		}

		// 3 or more elements in the array
		int m = (l + h) / 2;
		if (a[m] < a[m - 1] && a[m] < a[m + 1]) {
			return m; // found the split
		} else {
			if (a[m - 1] < a[l]) {
				// System.out.println("Going Left");
				return findSplitHelper(a, l, m);
			} else {
				// System.out.println("Going Right");
				return findSplitHelper(a, m + 1, h);
			}
		}
	}
}
