package selfpractice.stack;

/**
 * Runner for Towers of Hanoi class
 * 
 * @author nitinpasumarthy
 *
 */
public class TOHRunner {
	public static void main(String[] args) {
		TowerOfHanoi t = new TowerOfHanoi(4, true);
		t.move();

//		 t.printTowers();
	}
}
