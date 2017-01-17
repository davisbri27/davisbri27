package hw08;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class No8aTests extends No5Tests {

	@Before
	public void setUp() {
		hm = new CS232ClosedHashMap<Integer, Character>();
	}

	@Test
	public void testResizesOnceAtRightSize() {
		/*
		 * Override because HW does not ask for implementation of resize for
		 * CS232ClosedHashMap.  This prevents the inherited test method from
		 * running and failing.
		 */
	}

	@Test
	public void testResizesSeveralTimes() {
		/*
		 * Override because HW does not ask for implementation of resize for
		 * CS232ClosedHashMap.  This prevents the inherited test method from
		 * running and failing.
		 */
	}

	@Test
	public void testLinearProbeingWrapsAround() {
		hm.put(15, 'A');
		hm.put(30, 'B');
		hm.put(45, 'C');
		hm.put(60, 'D');

		assertEquals("Did not find value for key: 15", (Character) 'A',
				hm.get(15));
		assertEquals("Did not find value for key: 30", (Character) 'B',
				hm.get(30));
		assertEquals("Did not find value for key: 45", (Character) 'C',
				hm.get(45));
		assertEquals("Did not find value for key: 60", (Character) 'D',
				hm.get(60));
	}
}
