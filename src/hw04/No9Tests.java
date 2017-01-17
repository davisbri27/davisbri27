package hw04;

import static org.junit.Assert.*;
import hw04.CS232LinkedBinaryTree.BTNode;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class No9Tests {

	private static Random rnd = new Random();
	
	@Test
	public void testCountLeavesInEmptyTree() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>();

		int leaves = t.countLeafNodes();
		assertEquals("Incorrect count in empty tree", 0, leaves);
	}
	
	@Test
	public void testCountLeavesInOneNodeTree() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				"A", "1");

		int leaves = t.countLeafNodes();
		assertEquals("Incorrect count in one node tree", 1, leaves);
	}

	@Test
	public void testCountLeavesInFullSmallTree() {
		String[] keys = { "A", "B", "C" };
		String[] vals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		int leaves = t.countLeafNodes();
		assertEquals("Incorrect count in small full tree", 2, leaves);
	}
	
	@Test
	public void testCountLeavesInFullLargerTree() {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		int leaves = t.countLeafNodes();
		assertEquals("Incorrect count in larger full tree", 4, leaves);
	}
	
	@Test
	public void testCountLeavesInLargerNonFullTree() {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		t.remove("D");
		int leaves = t.countLeafNodes();
		assertEquals("Incorrect count in larger non-full tree", 3, leaves);
		
		t.remove("G");
		leaves = t.countLeafNodes();
		assertEquals("Incorrect count in larger full tree", 2, leaves);
		
		t.remove("E");
		leaves = t.countLeafNodes();
		assertEquals("Incorrect count in larger full tree", 2, leaves);
	}
	
	@Test
	public void testGetNodesInRandomTree() {

		for (int trial = 0; trial < 100; trial++) {

			String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
					"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
					"W", "X", "Y", "Z" };

			ArrayList<Integer> vals = new ArrayList<Integer>();
			for (int i = 0; i < keys.length; i++) {
				vals.add(i);
			}

			CS232LinkedBinaryTree<String, Integer> t = new CS232LinkedBinaryTree<String, Integer>(
					keys, vals.toArray(new Integer[] {}));

			int rems = rnd.nextInt(15);
			for (int i = 0; i < rems; i++) {
				int rind = rnd.nextInt(keys.length);
				String rkey = keys[rind];
				t.remove(rkey);
			}

			int realCount = testHelper(t.root);
			int stuCount = t.countLeafNodes();
			
			assertEquals("Incorrect leaf count on a random tree", realCount, stuCount);
		}
	}
	
	private int testHelper(BTNode<String,Integer> subTreeRoot) {
		if (subTreeRoot == null) {
			return 0;
		}
		else if (subTreeRoot.left == null & subTreeRoot.right == null) {
			return 1;
		}
		else {
			return testHelper(subTreeRoot.left) + testHelper(subTreeRoot.right);
		}
	}

}
