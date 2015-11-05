package selfpractice.trees;

import java.util.Comparator;

public class Node<T> implements Comparable<T> {
	private T value;
	private Node<T> left, right;
	private Comparator<T> c;

	public Node(T value, Comparator<T> c) {
		super();
		this.value = value;
		this.left = null;
		this.right = null;
		this.c = c;
	}

	public T getValue() {
		return value;
	}

	public Node<T> getLeft() {
		return left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return getValue() + "";
	}

	@Override
	public int compareTo(T o) {
		return c.compare(this.value, o);
	}

}
