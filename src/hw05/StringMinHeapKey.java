package hw05;

public class StringMinHeapKey implements Comparable<StringMinHeapKey> {

	private String key;

	public StringMinHeapKey(String key) {
		this.key = key;
	}

	public int compareTo(StringMinHeapKey o) {
		/*
		 * The line below just uses the compareTo method in String to compare
		 * the keys. This means "B" has higher priority than "A".
		 * 
		 * Fix this so that the keys as specified below form a valid heap in the
		 * given order. I.e. So that "A" has higher priority than "B", etc...
		 */

		return key.compareTo(o.key);
	}

	public static void main(String[] args) {

		String[] keys = new String[] { "A", "B", "C", "D", "E", "F", "G" };
		Integer[] vals = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };

		// Build StringMinHeapKeys from the keys.
		StringMinHeapKey[] smhKeys = new StringMinHeapKey[keys.length];
		for (int i = 0; i < keys.length; i++) {
			smhKeys[i] = new StringMinHeapKey(keys[i]);
		}

		// Make a heap from the smhKeys and vals.
		CS232ArrayHeap<StringMinHeapKey, Integer> heap = new CS232ArrayHeap<StringMinHeapKey, Integer>(
				smhKeys, vals);

		// Print out the values in priority order.
		// When the solution is correct the values should print in order:
		// 1 (because "A" has highest priority)
		// 2
		// 3
		// ... etc.
		while (heap.size() > 0) {
			System.out.println(heap.remove());
		}
	}
}
