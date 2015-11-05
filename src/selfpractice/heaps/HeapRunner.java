package selfpractice.heaps;

public class HeapRunner {

	public static void main(String[] args) {
		Heap h = createHeap();
		h.print();
		System.out.println();
		h.maxHeapify(2);
		h.print();
	}

	private static Heap createHeap() {
		Heap h = new Heap(10);
		h.insert(16);
		h.insert(4);
		h.insert(10);
		h.insert(14);
		h.insert(7);
		h.insert(9);
		h.insert(3);
		h.insert(2);
		h.insert(8);
		h.insert(1);

		return h;
	}

}
