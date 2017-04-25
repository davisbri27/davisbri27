package lab08;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 * Reads the input and prints out the different answers according to the input desires.
 * @author jeongj
 * @version April 11, 2017
 */

public class HuffmanCodes {

	private static String firstLetter; // Letter that tells which method should be ran
	private String inputString; // String of all the inputs
	private String tempString; // holds the line of input as a String 
	private HashMap<Character, Integer> numberHash; // holds the key and frequency of the input
	private static CS232ArrayHeap<Node, CS232LinkedBinaryTree<Integer, Character>> nodeQueue; // holds the "trees" 
	private String[] storeArr; // stores all the string value for method letter H and M (e.g 001, 0, 100)

	/**
	 *creates the "Node" that will be in the nodeQueue that will ultimately be combined to create tree
	 */
	public class Node implements Comparable<Node> {
		private int frequency;
		private char key;

		//constructor to create the Node
		public Node(Integer frequency, Character key) {
			this.frequency = frequency;
			this.key = key;
		}
		//returns frequency
		public int getFrequency() {
			return frequency;
		}
		
		//returns key
		public char getKey() {
			return key;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			if (frequency > o.frequency) {
				return -1;
			}
			//if the frequency is same, then compare the key values
			else if (frequency == o.frequency) {
				if (key > o.key) {
					return -1;
				} else if (key == o.key) {
					return 0;
				} else {
					return 1;
				}
			} else {
				return 1;
			}
		}
	}
	
	/**
	 * implement a visitor to print the tree in level order(character and frequency).
	 */
	private class PrintVisitor implements CS232Visitor<Integer, Character> {

		/**
		 * Print out the key,value pair at each node visited.
		 * 
		 * @param key
		 *            the key for the current node.
		 * @param value
		 *            the value at the current node.
		 */

		@Override
		public void visit(Integer key, Character value) {
			// speical case when there is a tab
			if (value.equals('\t')) {
				System.out.println("\\t" + ":" + key);
			}// special case when there is a new line 
			else if (value.equals('\n')) {
				System.out.println("\\n" + ":" + key);
			}// if no special case just print out value and key 
			else {
				System.out.println(value + ":" + key);
			}
		}

	}
	
	// constructor of the huffmanCodes, initializes the fields that we need
	public HuffmanCodes() {
		numberHash = new HashMap<Character, Integer>();
		nodeQueue = new CS232ArrayHeap<Node, CS232LinkedBinaryTree<Integer, Character>>();
		storeArr = new String[128];
	}

	//reads all the input
	public void inputReader() {
		Scanner in = new Scanner(System.in);
		firstLetter = in.next(); // finds out which method to run
		inputString = "";
		in.nextLine();
		while (in.hasNextLine()) {
			tempString = in.nextLine(); // puts the first line of the input as the tempString
			if (in.hasNextLine()) { // if there is an another line after tempString then add \n
				tempString += "\n";
			}
			for (int i = 0; i < tempString.length(); i++) {
				//reads each char of the tempString and add to the hashmap
				char curChar = tempString.charAt(i);
				Integer val = numberHash.get(new Character(curChar));
				//val+1 when there is already existing key
				if (numberHash.get(new Character(curChar)) != null) {
					numberHash.put(curChar, new Integer(val + 1));
				}// put into the hashmap if there is no existing key 
				else {
					numberHash.put(curChar, 1);
				}
			}
			//adds all the tempString to the inputString, this saves the whole input in one string
			inputString += tempString;
		}
		in.close();
	}
	
	//prints out the frequency table
	public void frequencyTable() {
		Map<Character, Integer> map = numberHash;
		// since the hashmap isn't sorted by the ASCII order, it needs to be sorted
		Object[] keys = map.keySet().toArray(); // puts everything into Array
		Arrays.sort(keys); // sorts key sets in ASCII order in the array

		//prints out in ASCII order
		for (int i = 0; i < keys.length; i++) {
			if (keys[i].equals('\t')) {
				//special case when there is a tab
				System.out.println("\\t" + ":" + map.get((char)keys[i]));
			} else if (keys[i].equals('\n')) {
				//special case when there is a new line
				System.out.println("\\n" + ":" + map.get((char)keys[i]));
			} else {
				System.out.println((char)keys[i] + ":" + map.get((char)keys[i]));
			}
		}
	}
	
	//adds all the "nodes" or "trees" to the NodeQueue, priority queue, from the hashmap. 
	public void addSingleNode() {

		for (Map.Entry<Character, Integer> entry : numberHash.entrySet()) {
			CS232LinkedBinaryTree<Integer, Character> singleNode = new CS232LinkedBinaryTree<Integer, Character>(
					entry.getValue(), entry.getKey());
			Node curNode = new Node(entry.getValue(), entry.getKey());
			nodeQueue.add(curNode, singleNode);
		}
	}

	//puts everything into the nodeQueue after combining the "nodes" or "trees" that are in the queue. 
	public void treeNode() {
		while (nodeQueue.size() > 1) {
			CS232LinkedBinaryTree<Integer, Character> tree1 = nodeQueue.remove();
			CS232LinkedBinaryTree<Integer, Character> tree2 = nodeQueue.remove();
			//reads which one has the higher frequency and decides which key will represent the new "node" or "tree"
			if (tree1.getRootValue() > tree2.getRootValue()) {
				CS232LinkedBinaryTree<Integer, Character> newTree = new CS232LinkedBinaryTree<Integer, Character>(tree2,
						tree1.getRootKey() + tree2.getRootKey(), tree2.getRootValue(), tree1);
				Node curNode = new Node(newTree.getRootKey(), newTree.getRootValue());
				nodeQueue.add(curNode, newTree);

			} else {
				CS232LinkedBinaryTree<Integer, Character> newTree = new CS232LinkedBinaryTree<Integer, Character>(tree2,
						tree1.getRootKey() + tree2.getRootKey(), tree1.getRootValue(), tree1);
				Node curNode = new Node(newTree.getRootKey(), newTree.getRootValue());
				nodeQueue.add(curNode, newTree);
			}
		}
	}
	
	//prints level order of the tree that was created by combining individual "node" or "tree"
	public void printLevelOrder() {
		String curString = null;
		while (nodeQueue.size() > 0) {
				CS232LinkedBinaryTree<Integer, Character> bt = nodeQueue.remove();
				bt.visitLevelOrder(new PrintVisitor());
		}
	}
	
	// finds the huffman code (e.g 100, 001, 01) for each leaves. 
	public void findHuffmanCode() {
		CS232LinkedBinaryTree<Integer, Character> tree = nodeQueue.peek();
		findHuffmanCodeRecHelper(tree.root, "", storeArr);
	}
	
	//recursion helper that will find the huffman code. 
	public void findHuffmanCodeRecHelper(CS232LinkedBinaryTree.BTNode<Integer, Character> node, String str, String[] storeArr) {
		if (node.isLeaf()) {
			storeArr[node.value] = str;
		} else {
			if (node.right != null) {
				// if the leaf is to the right then prints 1
				findHuffmanCodeRecHelper(node.right, str + "1", storeArr);
			}
			if (node.left != null) {
				// if the leaf is to the left then prints 0
				findHuffmanCodeRecHelper(node.left, str + "0", storeArr);
			}
		}
	}

	//prints the huffman code. It reads where the leaf is and prints 1 if the leaf is to the right and 0 otherwise. 
	public void printHuffmanCode() {
		for (int i = 0; i < 128; i++) {
			if (storeArr[i] != null) {
				if((char)i == '\n'){
					System.out.println("\\n:" + storeArr[i]);
				} else if ((char)i == '\t'){
					System.out.println("\\t:" + storeArr[i]);
				} else {
				System.out.println((char) i + ":" + storeArr[i]);
				}
			}
		}
	}

	// gets the huffman code for each character and prints the huffman code for each characters
	public void printHuffmanCodeForEachCharacter() {
		findHuffmanCode();
		for (int i = 0; i < inputString.length(); i++) {
			System.out.print(storeArr[inputString.charAt(i)]);
		}
	}

	public static void main(String[] args) {
		HuffmanCodes huffMan = new HuffmanCodes(); // initializes the huffman
		huffMan.inputReader(); // reads all the input
		huffMan.addSingleNode(); //adds all the single "nodes" or "trees" to the priority queue
		huffMan.treeNode(); // combines every "node" or "tree" into one big binary tree
		if (firstLetter.equals("F")) { //if the first letter is F
			huffMan.frequencyTable();
		} else if (firstLetter.equals("T")) { // if the first letter is T
			huffMan.printLevelOrder();
		} else if (firstLetter.equals("H")) { // if the first letter is H
			huffMan.findHuffmanCode();
			huffMan.printHuffmanCode();
		} else if (firstLetter.equalsIgnoreCase("M")) { // if the first letter is M
			huffMan.printHuffmanCodeForEachCharacter();
		}
	}
}