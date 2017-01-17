package hw06;

import static org.junit.Assert.*;
import hw06.CS232LinkedAVLTree.AVLNode;

import java.util.Random;

import org.junit.Test;

public class BonusTests extends No6Tests {

	@Test
	public void testRemoveNoRebalancing() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();

		avl.remove(2);
		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BCDEFGHIJK");

		avl.remove(7);
		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BDEFGHIJK");

		avl.remove(33);
		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BDEFGHJK");

		avl.remove(38);
		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BDEFGHJ");
	}

	@Test
	public void testRemoveCreatesLLOnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "D");
		avl.add(5, "B");
		avl.add(15, "C");
		avl.add(1, "A");

		avl.remove(15); // creates LL imbalance.

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABD");
	}

	@Test
	public void testRemoveCreatesLLManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();

		avl.remove(15); // creates LL imbalance

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDFGHIJK");
	}

	@Test
	public void testRemoveCreatesRROnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "A");
		avl.add(8, "B");
		avl.add(12, "C");
		avl.add(20, "D");

		avl.remove(8); // creates RR imbalance.

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ACD");
	}

	@Test
	public void testRemoveCreatesRRManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();

		avl.remove(25); // creates LL imbalance

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDEFHIJK");
	}

	@Test
	public void testRemoveCreatesRLOnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "B");
		avl.add(15, "D");
		avl.add(8, "A");
		avl.add(13, "C");

		avl.remove(8); // Creates RL imbalance

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BCD");
	}

	@Test
	public void testRemoveCreatesRLManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();

		avl.remove(38);
		avl.remove(25); // creates RL imbalance

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDEFHIJ");
	}

	@Test
	public void testRemoveCreatesLROnly3Nodes() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(10, "C");
		avl.add(5, "A");
		avl.add(15, "D");
		avl.add(8, "B");

		avl.remove(15); // creates LR imbalance.

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABC");
	}

	@Test
	public void testRemoveCreatesLRManyNodes() {
		CS232LinkedAVLTree<Integer, String> avl = getTestTree();

		avl.remove(2);
		avl.remove(15); // creates LR imbalance

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BCDFGHIJK");
	}

	@Test
	public void testRemoveCreatesRipplingImbalance1() {
		/*
		 * Example from:
		 * http://stackoverflow.com/questions/20912461/more-than-one
		 * -rotation-needed-to-balance-an-avl-tree
		 */

		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(50, "E");
		avl.add(25, "B");
		avl.add(75, "J");
		avl.add(15, "A");
		avl.add(40, "D");
		avl.add(60, "G");
		avl.add(80, "K");
		avl.add(35, "C");
		avl.add(55, "F");
		avl.add(65, "I");
		avl.add(90, "L");
		avl.add(62, "H");

		avl.remove(15);

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "BCDEFGHIJKL");
	}

	@Test
	public void testRemoveCreatesRipplingImbalance2() {
		/*
		 * Example from:
		 * http://www.mathcs.emory.edu/~cheung/Courses/323/Syllabus
		 * /Trees/AVL-delete.html
		 */
		
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		avl.add(50,"H");
		avl.add(25,"E");
		avl.add(75,"K");
		avl.add(10,"C");
		avl.add(30,"G");
		avl.add(60,"J");
		avl.add(80,"L");
		avl.add(5,"B");	
		avl.add(15,"D");
		avl.add(27,"F");
		avl.add(55,"I");
		avl.add(1,"A");		

		avl.remove(80);

		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		checkTreeValuesInOrder(avl.root, "ABCDEFGHIJK");
		
	}

	@Test
	public void testLotsOfRandomRemoves() {
		CS232LinkedAVLTree<Integer, String> avl = new CS232LinkedAVLTree<Integer, String>();
		for (int i = 0; i < 1000; i++) {
			avl.add(i, "" + i);
		}
		
		checkTreeStructure(avl.root);
		checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		
		Random rnd = new Random();
		for (int i = 0; i < 1000; i++) {
			int key = rnd.nextInt(1000);
			avl.remove(key);
			
			checkTreeStructure(avl.root);
			checkHeightAndBalance((AVLNode<Integer, String>) avl.root);
		}
	}

}
