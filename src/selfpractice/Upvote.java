package selfpractice;

public class Upvote {
	public static void main(String[] args) {
		// int a[] = { 3, 7, 4, 6, 2, 5 };
		int a[] = { 1, 2, 3, 1, 1 };
		slideWindow(a, 3);
	}

	public static int slideWindow(int a[], int w) {
		int increasing = 0, decreasing = 0;
		// 1st window => Scan the window to compute the number of increasing and decreasing trends
		printWindow(a, w, 0);
		int currentTrend = -1;
		for (int i = 1; i < w; i++) {
			if (a[i] > a[i - 1]) {
				if (currentTrend != 0) {
					increasing++;
					currentTrend = 0; // set current trend flag to increasing
				}
			} else if (a[i] < a[i - 1]) {
				if (currentTrend != 1) {
					decreasing++;
					currentTrend = 1; // set current trend flag to decreasing
				}
			}
		}
		System.out.println(increasing + " " + decreasing + "\n");

		for (int i = 1; i <= a.length - w; i++) {
			printWindow(a, w, i);
			// Testing first element of the window
			int cornerType = getCornerType(a, i); // 1 => ^ 2 => V 0 => not a corner
			if (cornerType == 1) {
				increasing--; // we lost an increasing trend due to this shift
			} else if (cornerType == 2) {
				decreasing--; // we lost a decreasing trend due to this shift
			}

			// Testing last element of the window
			cornerType = getCornerType(a, i + w - 2);
			if (cornerType == 1) {
				decreasing++; // we got a new decreasing trend because of this shift
			} else if (cornerType == 2) {
				increasing++; // we got a new increasing trend because of this shift
			}

			System.out.println(increasing + " " + decreasing + "\n");
		}

		return increasing - decreasing;
	}

	private static int getCornerType(int[] a, int i) {
		// if this is not the last element of the array find the corner type
		if (i + 1 < a.length) {
			if (a[i] - a[i - 1] > 0 && a[i + 1] - a[i] < 0)
				return 1;
			if (a[i] - a[i - 1] < 0 && a[i + 1] - a[i] > 0)
				return 2;
		}
		return 0;
	}

	private static void printWindow(int[] a, int w, int i) {
		for (int j = i; j < w + i; j++) {
			System.out.print(a[j] + " ");
		}
		System.out.println();
	}
}
