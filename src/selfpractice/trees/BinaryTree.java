package selfpractice.trees;

public class BinaryTree<T> implements ITree<T> {
	Node<T> head;

	public BinaryTree(Node<T> head, Comparable<T> comparator) {
		this.head = head;
	}

	public Node<T> search() {
		return null;
	}

	public void insert(Node<T> n) {
		doInsert(head, n);
	}

	private void doInsert(Node<T> curr, Node<T> n) {
		int result = curr.compareTo(n.getValue());
		if (result > 0) {
			if (curr.getLeft() == null) {
				curr.setLeft(n);
				return;
			} else {
				doInsert(curr.getLeft(), n);
			}
		}

		if (result <= 0) {
			if (curr.getRight() == null) {
				curr.setRight(n);
				return;
			} else {
				doInsert(curr.getRight(), n);
			}
		}
	}

	public void update() {
	}

	public void delete() {
	}
	
	public void inOrder() {
		doInoder(head);
	}
	private void doInoder(Node<T> n) {
		if (n != null) {
			doInoder(n.getLeft());
			System.out.print(n + " ");
			doInoder(n.getRight());
		}
	}
	
}
