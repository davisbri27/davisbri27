package hw05;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Test;

public class No10Tests {
	@Test
	public void testSetRoot() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		bst.set(30, "X");
		assertEquals("Should contain root node 30,X.", "X", bst.get(30));
	}

	@Test
	public void testSetInternalNode() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		bst.set(15, "X");
		assertEquals("Should contain internal node 15,X.", "X", bst.get(15));

		bst.set(45, "Y");
		assertEquals("Should contain internal node 45,Y.", "Y", bst.get(45));
	}

	@Test
	public void testSetLeafNode() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		bst.set(10, "W");
		assertEquals("Should contain leaf node 10,W.", "W", bst.get(10));

		bst.set(20, "X");
		assertEquals("Should contain leaf node 20,X.", "X", bst.get(20));

		bst.set(40, "Y");
		assertEquals("Should contain leaf node 40,Y.", "Y", bst.get(40));

		bst.set(50, "Z");
		assertEquals("Should contain leaf node 50,Z.", "Z", bst.get(50));
	}

	@Test
	public void testSetNodeNotInTree() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		int[] searchKeys = new int[] { 5, 12, 17, 22, 35, 42, 47, 52 };
		for (int k : searchKeys) {
			try {
				bst.set(k, "X");
				fail("Should have thrown exception.");
			} catch (NoSuchElementException e) {
				// pass
			} catch (Exception e) {
				fail("Threw incorrect exception type.");
			}
		}
	}
}
