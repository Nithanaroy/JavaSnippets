package selfpractice.trees;

import java.util.Arrays;

import selfpractice.CodeFreq;

public class Huffman {
	/**
	 * Encode the letters based on frequency using Huffman's encoding
	 * 
	 * @param letters
	 *            letters to encode
	 * @param freqs
	 *            corresponding frequencies of the letters
	 */
	public static void encode(char letters[], float freqs[]) {
		CodeFreq codes[] = new CodeFreq[letters.length];
		for (int i = 0; i < letters.length; i++) {
			codes[i] = new CodeFreq(letters[i], freqs[i]);
		}
		Arrays.sort(codes);
		System.out.println();
		
	}
	
	/**
	 * Merges the given node by creating a new internal node
	 * @param c left child of the internal node
	 * @param d right child of the internal node
	 * @return new node with C and D as children
	 */
	public static Node merge(Node c, Node d) {
//		Node n = new Node("D");
		return null;
	}
}
