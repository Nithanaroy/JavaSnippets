package selfpractice.trees;

import java.util.Comparator;

public class TreeRunner {
	public static void main(String[] args) {
		// ITree t = createTree();
		// t.inOrder();

		char letters[] = { 'A', 'B', 'C', 'D' };
		float freqs[] = { 0.65f, 0.3f, 0.15f, 0.1f };
		Huffman.encode(letters, freqs);
	}

	@SuppressWarnings("unused")
	private static ITree<Integer> createTree() {
//		Node<Integer> head = new Node<Integer>(15);
//		BinaryTree t = new BinaryTree(head);
//		t.insert(new Node<Integer>(6));
//		t.insert(new Node<Integer>(18));
//		t.insert(new Node<Integer>(3));
//		t.insert(new Node<Integer>(7));
//		t.insert(new Node<Integer>(17));
//		t.insert(new Node<Integer>(20));
//		t.insert(new Node<Integer>(2));
//		t.insert(new Node<Integer>(4));
//		t.insert(new Node<Integer>(13));
//		t.insert(new Node<Integer>(9));

//		return t;
		return null;
	}
}
