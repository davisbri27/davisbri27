package hw06;

import hw06.CS232LinkedAVLTree.AVLNode;

import org.junit.Test;

public class No5Tests extends No4Tests {

	@Test
	public void testAddCreatesCaseRLOnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "A");
		avl.add(15, "C");
		avl.add(13, "B");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABC");
	}

	@Test
	public void testAddCreatesCaseRLManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();
		avl.add(31, "Z");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDEFGHZIJK");
	}

}
