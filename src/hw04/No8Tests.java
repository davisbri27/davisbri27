package hw04;

import static org.junit.Assert.*;

import org.junit.Test;

import hw04.CS232LinkedBinaryTree;
import hw04.CS232LinkedBinaryTree.BTNode;

public class No8Tests {

	@Test
	public void testAddNewNodeAsRoot() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>();
		t.add("A", "1");

		assertEquals("Incorrect size", 1, t.size());
		assertNotNull("Tree does not contain added key", t.get("A"));
		assertEquals("Incorrect value associated with key", "1", t.get("A"));

		checkTreeStructure(t.root);
	}

	@Test
	public void testAddNewNodeAsLeftChildOfRoot() {
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				"A", "1");
		t.add("B", "2");

		assertEquals("Incorrect size", 2, t.size());
		assertNotNull("Tree does not contain added key", t.get("B"));
		assertEquals("Incorrect value associated with key", "2", t.get("B"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "BA");
	}

	@Test
	public void testAddNewNodeAsRightChildOfRoot() {
		String[] keys = new String[] { "A", "B" };
		String[] vals = new String[] { "1", "2" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);
		t.add("C", "3");

		assertEquals("Incorrect size", 3, t.size());
		assertNotNull("Tree does not contain added key", t.get("C"));
		assertEquals("Incorrect value associated with key", "3", t.get("C"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "BAC");
	}

	@Test
	public void testAddNewNodeAsLeftChild() {
		String[] keys = new String[] { "A", "B", "C", "D", "E" };
		String[] vals = new String[] { "1", "2", "3", "4", "5" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);
		t.add("F", "6");

		assertEquals("Incorrect size", 6, t.size());
		assertNotNull("Tree does not contain added key", t.get("F"));
		assertEquals("Incorrect value associated with key", "6", t.get("F"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "DBEAFC");
	}

	@Test
	public void testAddNewNodeAsRightChild() {
		String[] keys = new String[] { "A", "B", "C", "D", "E", "F" };
		String[] vals = new String[] { "1", "2", "3", "4", "5", "6" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);
		t.add("G", "7");

		assertEquals("Incorrect size", 7, t.size());
		assertNotNull("Tree does not contain added key", t.get("G"));
		assertEquals("Incorrect value associated with key", "7", t.get("G"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "DBEAFCG");
	}

	@Test
	public void testAddNewNodeAsLeftChildNotLast() {
		String[] keys = new String[] { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);
		t.remove("F");
		t.add("H", "8");

		assertEquals("Incorrect size", 7, t.size());
		assertNotNull("Tree does not contain added key", t.get("H"));
		assertEquals("Incorrect value associated with key", "8", t.get("H"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "DBEAHCG");
	}

	@Test
	public void testAddNewNodeAsRightChildNotLast() {
		String[] keys = new String[] { "A", "B", "C", "D", "E", "F", "G" };
		String[] vals = new String[] { "1", "2", "3", "4", "5", "6", "7" };
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				keys, vals);
		t.remove("E");
		t.add("H", "8");

		assertEquals("Incorrect size", 7, t.size());
		assertNotNull("Tree does not contain added key", t.get("H"));
		assertEquals("Incorrect value associated with key", "8", t.get("H"));

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "DBHAFCG");
	}

	/*
	 * Helper method that traverses the tree and checks that every node is
	 * linked back to its proper parent.
	 */
	private void checkTreeStructure(BTNode<String, String> node) {
		if (node.left != null) {
			assertEquals("left child of " + node.key
					+ " has incorrect parent pointer", node, node.left.parent);
			checkTreeStructure(node.left);
		}

		if (node.right != null) {
			assertEquals("right child of " + node.key
					+ " has incorrect parent pointer", node, node.right.parent);
			checkTreeStructure(node.right);
		}
	}
	
	private void checkTreeKeysInOrder(BTNode<String, String> node,
			String expKeys) {
		/*
		 * Check the keys in the nodes of the tree against those in keys using
		 * an in-order traversal.
		 */
		String treeKeys = getKeysInOrder(node);
		assertEquals("Keys are not in proper locations in inorder traversal",
				expKeys, treeKeys);
	}

	private String getKeysInOrder(BTNode<String, String> root) {
		if (root != null) {
			String keys = getKeysInOrder(root.left);
			keys = keys + root.key;
			keys = keys + getKeysInOrder(root.right);
			return keys;
		} else {
			return "";
		}
	}
}
