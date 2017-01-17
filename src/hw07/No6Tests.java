package hw07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class No6Tests {

	private static Random rnd = new Random();

	@Test
	public void testOneItemList() {
		Integer[] keys = new Integer[] { 3 };
		Integer[] vals = new Integer[] { 2 };

		CS232ArrayHeap<Integer, Integer> heap = new CS232ArrayHeap<Integer, Integer>(
				keys, vals);

		assertTrue("Single element heap was not properly heapified",
				heap.checkHeapProperty());
	}

	@Test
	public void testStartWithValidHeap() {
		Integer[] keys = new Integer[] { 10, 8, 4, 2, 6, 3, 1 };
		Integer[] vals = new Integer[] { 5, 4, 2, 1, 3, 1, 0 };

		CS232ArrayHeap<Integer, Integer> heap = new CS232ArrayHeap<Integer, Integer>(
				keys, vals);

		assertTrue("Valid heap was de-heapified?!?!?", heap.checkHeapProperty());
	}

	@Test
	public void startWithNotValidHeap() {
		Integer[] keys = new Integer[] { 1, 3, 6, 2, 4, 8, 10 };
		Integer[] vals = new Integer[] { 5, 4, 2, 1, 3, 1, 0 };

		CS232ArrayHeap<Integer, Integer> heap = new CS232ArrayHeap<Integer, Integer>(
				keys, vals);

		assertTrue("Anti-heap was not heapified", heap.checkHeapProperty());
	}

	@Test
	public void testRandomOrderLists() {
		for (int t = 0; t <= 100; t++) {
			StringBuffer buf = new StringBuffer();
			ArrayList<Integer> list = new ArrayList<Integer>();
			int len = rnd.nextInt(1000);
			for (int i = 0; i < len; i++) {
				list.add(i);
				buf.append(i + " ");
			}
			Collections.shuffle(list);

			Integer[] keys = new Integer[len];
			Integer[] vals = new Integer[len];
			for (int i = 0; i < len; i++) {
				keys[i] = list.get(i);
				vals[i] = keys[i] / 2;
			}

			CS232ArrayHeap<Integer, Integer> heap = new CS232ArrayHeap<Integer, Integer>(
					keys, vals);

			assertTrue("Random list was not properly heapified",
					heap.checkHeapProperty());
		}
	}
}
