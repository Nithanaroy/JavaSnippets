package selfpractice;

/**
 * Class for Huffman encoding
 * 
 * @author Nitin Pasumarthy
 *
 */
public class CodeFreq implements Comparable<CodeFreq> {
	private char letter;
	private float frequency;

	public CodeFreq(char letter, float frequency) {
		super();
		this.letter = letter;
		this.frequency = frequency;
	}

	public char getLetter() {
		return letter;
	}

	public float getFrequency() {
		return frequency;
	}

	public void setLetter(char letter) {
		this.letter = letter;
	}

	public void setFrequency(float frequency) {
		this.frequency = frequency;
	}

	@Override
	public int compareTo(CodeFreq o) {
		if (this.frequency - o.frequency > 0)
			return 1;
		else if (this.frequency - o.frequency < 0)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		return this.letter + " " + this.frequency;
	}

}
