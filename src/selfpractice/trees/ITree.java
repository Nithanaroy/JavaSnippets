package selfpractice.trees;

public interface ITree<T> {
	public Node<T> search();

	public void insert(Node<T> n);

	public void update();

	public void delete();

	public void inOrder();
}
