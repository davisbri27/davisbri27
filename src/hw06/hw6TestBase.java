package hw06;

import static org.junit.Assert.*;
import hw06.CS232LinkedAVLTree.AVLNode;
import hw06.CS232LinkedBinaryTree.BTNode;

import org.junit.Test;

public class hw6TestBase {
	/*
	 * Helper method that traverses the tree and checks that every node is
	 * linked back to its proper parent.
	 */
	protected void checkTreeStructure(BTNode<Integer, String> node) {

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

	protected void checkTreeValuesInOrder(BTNode<Integer, String> node,
			String expKeys) {
		/*
		 * Check the keys in the nodes of the tree against those in keys using
		 * an in-order traversal.
		 */
		String treeKeys = getValuesInOrder(node);
		assertEquals("Keys are not in proper locations in inorder traversal",
				expKeys, treeKeys);
	}

	protected String getValuesInOrder(BTNode<Integer, String> root) {
		if (root != null) {
			String keys = getValuesInOrder(root.left);
			keys = keys + root.value;
			keys = keys + getValuesInOrder(root.right);
			return keys.trim();
		} else {
			return "";
		}
	}

	/**
	 * Get the height of a given node. If the node is null, we'll define the
	 * height as -1. This works with the getNodeHeightFromChildren method so
	 * that the height of a leaf node is set to 0.
	 */
	protected int getNodeHeight(AVLNode<Integer, String> node) {
		if (node == null) {
			return 0;
		} else {
			return node.height;
		}
	}

	/**
	 * Get the height of a node as one more than the height of its highest
	 * child. This method assumes that the height of any child of node has
	 * already been set.
	 * 
	 * @param root
	 *            a non-null node.
	 * @return the height of the node.
	 */
	protected int computeNodeHeightFromChildren(AVLNode<Integer, String> node) {
		return Math.max(getNodeHeight((AVLNode<Integer, String>) node.left),
				getNodeHeight((AVLNode<Integer, String>) node.right)) + 1;
	}

	/**
	 * Get the balance of a node as the difference in height between its
	 * children. This method assumes that the height of any child of node has
	 * already been set.
	 * 
	 * @param root
	 *            a non-null node.
	 * @return the balance of node.
	 */
	protected int computeNodeBalance(AVLNode<Integer, String> node) {
		return getNodeHeight((AVLNode<Integer, String>) node.left)
				- getNodeHeight((AVLNode<Integer, String>) node.right);
	}

	protected void checkHeightAndBalance(AVLNode<Integer, String> subTreeRoot) {
		/*
		 * Do a post order traversal and check the height and balance at each
		 * node against what we compute here. Also check that every node is
		 * balanced.
		 */

		if (subTreeRoot != null) {
			checkHeightAndBalance((AVLNode<Integer, String>) subTreeRoot.left);
			checkHeightAndBalance((AVLNode<Integer, String>) subTreeRoot.right);

			int correctHeight = computeNodeHeightFromChildren(subTreeRoot);
			int correctBalance = computeNodeBalance(subTreeRoot);

			assertEquals("Height of node with key " + subTreeRoot.key
					+ " is not correct", correctHeight, subTreeRoot.height);
			assertEquals("Balance of node with key " + subTreeRoot.key
					+ " is not correct", correctBalance, subTreeRoot.balance);

			assertTrue(
					"Node with key " + subTreeRoot.key + " is not balanced.",
					subTreeRoot.balance >= -1 && subTreeRoot.balance <= 1);
		}
	}
	
	@Test
	public void testAddToEmptyTree() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "A");

		assertEquals("Root should have key 10", new Integer(10), avl.root.key);
		assertEquals("Root should have value A", "A", avl.root.value);
		assertEquals("Tree should have size 1", 1, avl.size());
	}

	@Test
	public void testAddToRootOnlyTree() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>(
				10, "A");
		avl.add(5, "B");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BA");
	}

	@Test
	public void testAddWithoutUnbalancing() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "A");
		avl.add(5, "B");
		avl.add(15, "C");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BAC");

		avl.add(20, "G");
		avl.add(13, "F");
		avl.add(8, "E");
		avl.add(3, "D");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "DBEAFCG");
	}

	protected CS232LinkedAVLTree<Integer, String> getTestTree() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();

		// Does not require any rebalancing.

		avl.add(20, "F");

		avl.add(10, "D");
		avl.add(30, "H");

		avl.add(5, "B");
		avl.add(15, "E");
		avl.add(25, "G");
		avl.add(35, "J");

		avl.add(2, "A");
		avl.add(7, "C");
		avl.add(33, "I");
		avl.add(38, "K");

		return avl;
	}

	@Test
	public void testAddCreatesCaseRROnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(5, "A");
		avl.add(10, "B");
		avl.add(15, "C");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABC");
	}

	@Test
	public void testAddCreatesCaseRRManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();
		avl.add(40, "Z");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDEFGHIJKZ");
	}
}
