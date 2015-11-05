package selfpractice;

public class MergeSort {

	static int inversions = 0;

	public static void main(String args[]) {
		int a[] = { 6, 5, 4, 3, 2, 1 };
		int b[] = mergesort(a);

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}
		System.out.println("\nInversions: " + inversions);
	}

	public static int[] mergesort(int[] a) {
		return _mergesort(a, 0, a.length - 1);
	}

	private static int[] _mergesort(int[] a, int s, int e) {
		if (a == null)
			return a;

		if (s > e)
			return null;
		else if (s == e)
			return new int[] { a[s] };
		else {
			int m = (s + e) / 2;
			int x[] = _mergesort(a, s, m);
			int y[] = _mergesort(a, m + 1, e);
			return merge(x, y);
		}
	}

	private static int[] merge(int[] a, int[] b) {
		int alen = a.length;
		int blen = b.length;
		int c[] = new int[alen + blen];
		int ai = 0, bi = 0, ci = 0;

		for (int i = 0; i < c.length; i++) {
			if (ai < alen && bi < blen) {
				if (a[ai] < b[bi]) {
					c[ci++] = a[ai];
					ai++;
				} else {
					c[ci++] = b[bi];
					bi++;
					inversions += (alen - ai);
				}
			} else
				break;
		}
		for (; ai < alen; ai++, ci++) {
			c[ci] = a[ai];
		}
		for (; bi < blen; bi++, ci++) {
			c[ci] = b[bi];
		}

		return c;
	}
}
