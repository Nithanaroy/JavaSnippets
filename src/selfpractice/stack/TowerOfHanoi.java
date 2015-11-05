package selfpractice.stack;

public class TowerOfHanoi {
	private Tower a, b, c;
	private int n; // number of beads
	private int step = 1;

	public boolean DEBUG = false;

	public TowerOfHanoi(int _n) {
		a = new Tower();
		b = new Tower();
		c = new Tower();
		this.n = _n;

		this.initializeTower();
	}

	public TowerOfHanoi(int _n, boolean debug) {
		a = new Tower();
		b = new Tower();
		c = new Tower();
		this.n = _n;
		this.DEBUG = debug;

		this.initializeTower();
	}

	private void initializeTower() {
		for (int i = n; i > 0; i--) {
			a.push(i);
		}
	}

	public void move() {
		move(this.n, a, c, b);
	}

	private void move(int n, Tower s, Tower d, Tower b) {
		if (n == 1) {
			d.push(s.pop());
			if (DEBUG)  printTowers();
		} else if (n == 2) {
			b.push(s.pop());
			if (DEBUG)  printTowers();
			d.push(s.pop());
			if (DEBUG)  printTowers();
			d.push(b.pop());
			if (DEBUG)  printTowers();
		} else {
			move(n - 1, s, b, d);
			d.push(s.pop());
			if (DEBUG)  printTowers();
			move(n - 1, b, d, s);
		}
	}

	public void printTowers() {
		System.out.format("Step %d\na: %s\nb: %s\nc: %s\n\n", step, a, b, c);
		step++;
	}
}
