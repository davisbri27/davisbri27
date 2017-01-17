package hw07;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import org.junit.Test;

public class BonusTests {
	private static final Random rnd = new Random();

	@Test
	public void testEmptyList() {
		CS232SortableLinkedList<Integer> list = new CS232SortableLinkedList<Integer>();

		list.mergeSortList();

		String result = list.toString();
		String expResult = "";

		assertEquals("Empty list should be empty after sorting too.",
				expResult, result);
	}

	@Test
	public void testOneItemList() {
		CS232SortableLinkedList<Integer> list = new CS232SortableLinkedList<Integer>();
		list.add(8);

		list.mergeSortList();

		String result = list.toString();
		String expResult = "8";

		assertEquals("One item list not sorted correctly!?!?!.", expResult,
				result);
	}

	@Test
	public void testInOrderList() {
		CS232SortableLinkedList<Integer> list = new CS232SortableLinkedList<Integer>();
		for (int i = 1; i <= 10; i++) {
			list.add(i);
		}

		list.mergeSortList();

		String result = list.toString();
		String expResult = "1 2 3 4 5 6 7 8 9 10";

		assertEquals("List not properly sorted", expResult, result);
	}

	@Test
	public void testRevOrderList() {
		CS232SortableLinkedList<Integer> list = new CS232SortableLinkedList<Integer>();
		for (int i = 10; i >= 1; i--) {
			list.add(i);
		}
		
		list.mergeSortList();

		String result = list.toString();
		String expResult = "1 2 3 4 5 6 7 8 9 10";

		assertEquals("List not properly sorted", expResult, result);
	}

	@Test
	public void testListWithDuplicates() {
		CS232SortableLinkedList<Integer> list = new CS232SortableLinkedList<Integer>();
		Integer[] vals = new Integer[7];
		vals[0] = new Integer(2);
		list.add(vals[0]);

		vals[1] = new Integer(3);
		list.add(vals[1]);

		vals[2] = new Integer(1);
		list.add(vals[2]);

		vals[3] = new Integer(2);
		list.add(vals[3]);

		vals[4] = new Integer(2);
		list.add(vals[4]);

		vals[5] = new Integer(3);
		list.add(vals[5]);

		vals[6] = new Integer(1);
		list.add(vals[6]);

		list.mergeSortList();

		Integer[] sortedVals = new Integer[] { vals[2], vals[6], vals[0],
				vals[3], vals[4], vals[1], vals[5] };
		
		for (int i = 0; i < vals.length; i++) {
			assertTrue("Sort is not stable", sortedVals[i] == list.get(i));
		}
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

			CS232SortableLinkedList<Integer> dllist = new CS232SortableLinkedList<Integer>();
			for (int v : list) {
				dllist.add(v);
			}
			
			dllist.mergeSortList();

			String result = dllist.toString();
			String expResult = buf.toString().trim();

			assertEquals("Randomly generated list not properly sorted",
					expResult, result);
		}
	}
}
