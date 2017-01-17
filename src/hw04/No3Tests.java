package hw04;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.Test;

public class No3Tests {

	@Test
	public void testFindMin() {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J",
				"K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
				"W", "X", "Y", "Z" };
		
		ArrayList<Integer> vals = new ArrayList<Integer>();
		for (int i=0; i<keys.length; i++) {
			vals.add(i);
		}

		for (int trial = 0; trial < 100; trial++) {
			Collections.shuffle(vals);
			
			CS232LinkedBinaryTree<String, Integer> t = new CS232LinkedBinaryTree<String, Integer>(
					keys, vals.toArray(new Integer[] {}));

			MinKeyFinder mkf = new MinKeyFinder();
			t.visitPreOrder(mkf);
			
			int mindex = getMinIndex(vals);
			String minKey = keys[mindex];
			
			assertEquals("Incorrect minimum key.", minKey, mkf.getMinKey());
		}
	}
	
	private static int getMinIndex(ArrayList<Integer> vals) {
		int mindex = 0;
		int min = vals.get(0);
		for (int i=1; i<vals.size(); i++) {
			if (vals.get(i) < min) {
				min = vals.get(i);
				mindex = i;
			}
		}
		return mindex;
	}
}
