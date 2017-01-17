package hw05;

import static org.junit.Assert.*;

import org.junit.Test;

public class No9Tests {

	@Test
	public void testGetRoot() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		assertEquals("Should contain root node 30,D.", "D", bst.get(30));
	}

	@Test
	public void testGetInternalNode() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		assertEquals("Should contain internal node 15,B.", "B", bst.get(15));
		assertEquals("Should contain internal node 45,F.", "F", bst.get(45));
	}

	@Test
	public void testGetLeafNode() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		assertEquals("Should contain leaf node 10,A.", "A", bst.get(10));
		assertEquals("Should contain leaf node 20,C.", "C", bst.get(20));
		assertEquals("Should contain leaf node 40,E.", "E", bst.get(40));
		assertEquals("Should contain leaf node 50,G.", "G", bst.get(50));
	}

	@Test
	public void testGetNodeNotInTree() {
		Integer[] keys = { 30, 15, 45, 10, 20, 40, 50 };
		String[] vals = { "D", "B", "F", "A", "C", "E", "G" };

		CS232LinkedBinarySearchTree<Integer, String> bst = new CS232LinkedBinarySearchTree<Integer, String>(
				keys, vals);

		assertNull("Should not contain node with key 5", bst.get(5));
		assertNull("Should not contain node with key 12", bst.get(12));

		assertNull("Should not contain node with key 17", bst.get(17));
		assertNull("Should not contain node with key 22", bst.get(22));

		assertNull("Should not contain node with key 35", bst.get(35));
		assertNull("Should not contain node with key 42", bst.get(42));

		assertNull("Should not contain node with key 47", bst.get(47));
		assertNull("Should not contain node with key 52", bst.get(52));
	}
}
