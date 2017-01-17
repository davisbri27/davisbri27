package hw06;

import hw06.CS232LinkedAVLTree.AVLNode;

import org.junit.Test;

public class No4Tests extends hw6TestBase {

	@Test
	public void testAddCreatesCaseLLOnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(15, "C");
		avl.add(10, "B");
		avl.add(5, "A");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABC");
	}

	@Test
	public void testAddCreatesCaseLLManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();
		avl.add(1, "Z");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ZABCDEFGHIJK");
	}

}
