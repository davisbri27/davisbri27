package hw04;

import static org.junit.Assert.*;
import hw04.CS232LinkedBinaryTree.BTNode;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class No7Tests {

	private static Random rnd = new Random();

	@Test
	public void testContainsKeyAtRootInOneNodeTree() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				"A", "1");

		assertTrue("contains() did not find key at root.", t.contains("A"));
	}

	@Test
	public void testContainsKeyNotThereOneNodeTree() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				"A", "1");

		assertFalse("contains() found when key not in tree.", t.contains("Z"));
	}

	@Test
	public void testContainsKeyAtRootOfSmallTree() {
		String[] keys = { "A", "B", "C" };
		String[] vals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		assertTrue("contains() did not find key at root.", t.contains("A"));
	}

	@Test
	public void testContainsKeyIsLeftChildOfRoot() {
		String[] keys = { "A", "B", "C" };
		String[] vals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		assertTrue("contains() did not find key at left child of root.", t.contains("B"));
	}

	@Test
	public void testContainsKeyIsRightChildOfRoot() {
		String[] keys = { "A", "B", "C" };
		String[] vals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		assertTrue("contains() did not find key at right child of root.", t.contains("C"));
	}

	@Test
	public void testContainsSmallTreeKeyNotThere() {
		String[] keys = { "A", "B", "C" };
		String[] vals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		assertFalse("contains() found when key not in tree.", t.contains("Z"));
	}

	@Test
	public void testContainsAllNodesInCompleteTree() {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		for (int i = 0; i < keys.length; i++) {
			assertTrue("contains() did not find key in complete tree.", t.contains(keys[i]));
		}
	}

	@Test
	public void testContainsNodeNotInCompleteTree() {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);

		assertFalse("contains() found when key not in complete tree.", t.contains("Z"));
	}

	@Test
	public void testContainsNodesInRandomTree() {

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

			for (int k = 0; k < keys.length; k++) {
				Integer val = t.get(keys[k]);

				if (val != null) {
					assertTrue("contains() did not find key in ful tree.", t.contains(keys[k]));
				} else {
					assertFalse("contains() found when key not in tree.", t.contains(keys[k]));
				}
			}
		}
	}
}
