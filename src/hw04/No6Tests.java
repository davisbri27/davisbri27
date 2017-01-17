package hw04;

import static org.junit.Assert.*;
import hw04.CS232LinkedBinaryTree.BTNode;

import org.junit.Test;

public class No6Tests {

	@Test
	public void testSubTreeConstructorEmptySubTrees() {
		CS232LinkedBinaryTree<String, String> rTree = new CS232LinkedBinaryTree<String, String>();
		CS232LinkedBinaryTree<String, String> lTree = new CS232LinkedBinaryTree<String, String>();
		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				lTree, "A", "1", rTree);

		assertEquals("Incorrect size", 1, t.size());
		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "A");
	}

	@Test
	public void testSubTreeConstructorEmptyLeftTree() {
		String[] rKeys = { "A", "B", "C" };
		String[] rVals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> rTree = new CS232LinkedBinaryTree<String, String>(
				rKeys, rVals);

		CS232LinkedBinaryTree<String, String> lTree = new CS232LinkedBinaryTree<String, String>();

		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				lTree, "D", "4", rTree);

		assertEquals("Incorrect size", 4, t.size());

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "DBAC");
	}

	@Test
	public void testSubTreeConstructorEmptyRightTree() {

		CS232LinkedBinaryTree<String, String> rTree = new CS232LinkedBinaryTree<String, String>();

		String[] lKeys = { "A", "B", "C" };
		String[] lVals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> lTree = new CS232LinkedBinaryTree<String, String>(
				lKeys, lVals);

		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				lTree, "D", "4", rTree);

		assertEquals("Incorrect size", 4, t.size());

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "BACD");
	}

	@Test
	public void testSubTreeConstructorTwoNonEmptyTrees() {
		String[] rKeys = { "A", "B", "C" };
		String[] rVals = { "1", "2", "3" };
		CS232LinkedBinaryTree<String, String> rTree = new CS232LinkedBinaryTree<String, String>(
				rKeys, rVals);
		
		String[] lKeys = { "D", "E", "F" };
		String[] lVals = { "4", "5", "6" };
		CS232LinkedBinaryTree<String, String> lTree = new CS232LinkedBinaryTree<String, String>(
				lKeys, lVals);

		CS232LinkedBinaryTree<String, String> t = new CS232LinkedBinaryTree<String, String>(
				lTree, "G", "7", rTree);

		assertEquals("Incorrect size", 7, t.size());

		checkTreeStructure(t.root);
		checkTreeKeysInOrder(t.root, "EDFGBAC");
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
		assertEquals("Keys were not in proper order during an inorder traversal",
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
