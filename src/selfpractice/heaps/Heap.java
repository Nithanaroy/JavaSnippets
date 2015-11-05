package selfpractice.heaps;

public class Heap {
	private int A[];
	private int index;

	public Heap(int size) {
		A = new int[size + 1];
		index = 1; // one based indexing
	}

	public int left(int i) {
		return 2 * i;
	}

	public int right(int i) {
		return 2 * i + 1;
	}

	public int parent(int i) {
		return (int) Math.ceil(i / 2);
	}

	public void insert(int i) {
		if (index >= A.length) {
			throw new ArrayIndexOutOfBoundsException("Heap full");
		}
		A[index++] = i;
	}

	public void maxHeapify(int index) {
		int max = index;
		// find max child
		if (left(index) < this.index && A[left(index)] >= A[index]) {
			max = left(index);
		} else if (right(index) < this.index && A[right(index)] > A[max])
			max = right(index);

		if (max != index) {
			int temp = A[index];
			A[index] = A[max];
			A[max] = temp;
			maxHeapify(max);
		}
	}

	public void print() {
		for (int i = 1; i < index; i++) {
			System.out.print(A[i] + " ");
		}
	}
}
