package crackingcodinginterview;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list, arrange all the elements less than a given element in the list to the left of it
 * and the greater ones to the right of it.
 * 
 * @author nitinpasumarthy
 *
 */
public class PivotInALinkedList {
	public static void main(String[] args) {
		ArrayList<Integer> l = getList();
		List<Integer> l1 = rearrange(l, 10);
		printList(l1);
	}

	private static void printList(List<Integer> l1) {
		for(Integer i : l1) {
			System.out.format("%d ", i);
		}
		System.out.println();
	}

	private static ArrayList<Integer> rearrange(ArrayList<Integer> l, int pivot) {
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> left = new ArrayList<>();
		ArrayList<Integer> right = new ArrayList<>();
		a.add(pivot);

		for (Integer p : l) {
			if (p < pivot) {
				left.add(p);
			} else if (p > pivot) {
				right.add(p);
			}
			// Ignore the pivot
		}

		left.addAll(a);
		left.addAll(right);

		return left;
	}

	private static ArrayList<Integer> getList() {
		int elements[] = { 6, 8, 4, 10 };
		ArrayList<Integer> l = new ArrayList<>();
		for (Integer e : elements) {
			l.add(e);
		}
		return l;
	}
}
