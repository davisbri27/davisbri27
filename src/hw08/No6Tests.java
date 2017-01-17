package hw08;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class No6Tests extends No5Tests {
	@Test
	public void testRemoveKeyInMap() {
		ArrayList<Integer> keys = getShuffledList(12);
		for (int key : keys) {
			hm.put(key, (char) (key + 65));
		}

		for (int key : keys) {
			Character valCh = hm.remove(key);

			assertNotNull("Key " + key + " should be in map.", valCh);
			char val = valCh;

			assertEquals("Incorrect value for removed key: " + key, key + 65,
					val);
		}

		assertEquals("Incorrect size", 0, hm.size());
		assertEquals("Incorrect capacity, should not have changed", 16,
				hm.capacity());
	}

	@Test
	public void testRemoveKeyWithMultipleHashedToSameIndex() {
		hm.put(5, 'A');
		hm.put(20, 'B');
		hm.put(36, 'C');
		hm.put(52, 'D');

		hm.remove(36);

		assertEquals("Did not find value for key: 5", (Character) 'A',
				hm.get(5));
		assertEquals("Did not find value for key: 20", (Character) 'B',
				hm.get(20));
		assertNull("Should not find value for key: 36", hm.get(36));
		assertEquals("Did not find value for key: 52", (Character) 'D',
				hm.get(52));
	}

	@Test
	public void testRemoveNotInMap() {
		ArrayList<Integer> keys = getShuffledList(12);
		for (int key : keys) {
			hm.put(key, (char) (key + 65));
		}

		assertNull("Should not get value for key 13", hm.remove(13));
		assertNull("Should not get value for key 14", hm.remove(14));

		assertEquals("Incorrect size", 12, hm.size());
		assertEquals("Incorrect capacity, should not have grown", 16,
				hm.capacity());
	}
}
