package selfpractice.trees2;

public class Main {

	public static void main(String[] args) {
		BinaryTree b = new BinaryTree();
		b.insert(4);
		b.insert(3);
		b.insert(2);
		b.insert(5);
		b.insert(14);
		b.insert(12);
		b.insert(10);
		b.insert(16);

		System.out.print("In Order: ");
		b.inOrder();
		System.out.println();

		System.out.print("Level Order: ");
		b.levelOrder();
		System.out.println();

		System.out.println("Height: " + b.height());
		System.out.println("Balanced?: " + b.isBalanced());
		System.out.println("Done");
	}

}
