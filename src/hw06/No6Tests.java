package hw06;

import hw06.CS232LinkedAVLTree.AVLNode;

import java.util.Random;

import org.junit.Test;

public class No6Tests extends No5Tests {

	@Test
	public void testAddCreatesCaseLROnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "C");
		avl.add(5, "A");
		avl.add(8, "B");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABC");
	}

	@Test
	public void testAddCreatesCaseLRManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();
		avl.add(8, "Z");

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCZDEFGHIJK");
	}

	@Test
	public void testLotsOfRandomAdds() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();

		Random rnd = new Random();
		for (int i = 0; i < 1000; i++) {
			int key = rnd.nextInt();
			avl.add(key, "" + key);

			checkTreeStructure(avl.root);
			checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		}
	}

}
