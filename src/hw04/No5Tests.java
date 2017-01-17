package hw04;

import static org.junit.Assert.*;
import hw04.CS232LinkedBinaryTree.BTNode;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class No5Tests {

	private static Random rnd = new Random();

	@Test
	public void testInOrderTraversal() {
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
			
			//System.out.println(t.size());

			KeyStringVisitor<String, Integer> v = new KeyStringVisitor<String, Integer>();
			t.visitInOrder(v);
			String hwSolnInOrder = v.getKeys();

			String corredInOrder = getKeysInOrder(t.root);

			assertEquals("Incorrect inorder traversal", hwSolnInOrder,
					corredInOrder);
		}

	}

	private String getKeysInOrder(BTNode<String, Integer> root) {
		if (root != null) {
			String keys = getKeysInOrder(root.left);
			keys = keys + root.key;
			keys = keys + getKeysInOrder(root.right);
			return keys;
		} else {
			return "";
		}
	}

	private static class KeyStringVisitor<K, V> implements CS232Visitor<K, V> {

		private String list;

		public KeyStringVisitor() {
			list = "";
		}

		public void visit(K key, V value) {
			list = list + key;
		}

		public String getKeys() {
			return list;
		}
	}
}
