package selfpractice;

import java.util.ArrayList;
import java.util.Vector;

public class TryingVectors {
	public static void main(String[] args) {
		// Vector v = new Vector();
		// v.add("Awesome");
		// v.add(11);
		// v.add(4.3);
		// v.add(new int[] { 1, 2, 3 });
		//
		// System.out.println(((int[]) v.get(3)));

		ArrayList<Integer> a = new ArrayList<>();
		a.add(0, 1);
		a.add(0, 2);
		a.add(2, 3);
		System.out.println(a);
	}
}
