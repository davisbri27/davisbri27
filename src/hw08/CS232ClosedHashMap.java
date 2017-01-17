package hw08;

/**
 * An implementation of the HashMap interface that uses closed hashing (open
 * addressing).
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version April 17, 2016
 */
public class CS232ClosedHashMap<K, V> implements CS232HashMap<K, V> {

	private static final int INITIAL_CAPACITY = 16;
	
	/*
	 * Special value that is inserted into the hash table in place of a
	 * key,value pair that has been removed. This allows such locations to be
	 * skipped over during probing.
	 */
	private final KeyValuePair<K, V> DEL = new KeyValuePair<K, V>(null, null);

	private int currentSize;
	private KeyValuePair<K, V>[] hashTable;

	public CS232ClosedHashMap() {
		/*
		 * NOTE: Java does not support the creation of arrays of a generic type.
		 * So instead we create an array of type Object cast it to the
		 * appropriate specified type.
		 */
		hashTable = (KeyValuePair<K, V>[]) new KeyValuePair<?, ?>[INITIAL_CAPACITY];
		currentSize = 0;
	}

	/*
	 * Helper method to compute an index into the hash table from the hash code.
	 */
	private int getIndex(K key) {
		return key.hashCode() % hashTable.length;
	}

	/**
	 * Probe function. This implementation performs linear probing. Can be
	 * overridden in sub-classes to implement different types of probing.
	 * 
	 * @param key
	 *            the key
	 * @param i
	 *            the number of the probe.
	 * @return the offset from the home index to the ith probe location.
	 */
	protected int probeFunction(K key, int i) {
		return i;
	}

	/**
	 * {@inheritDoc}
	 */
	public void put(K key, V value) {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	public V get(K key) {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	public V remove(K key) {
		// Intentionally not implemented - see homework assignment.
		throw new UnsupportedOperationException("Not yet implemented");
	}

	/**
	 * {@inheritDoc}
	 */
	public int size() {
		return currentSize;
	}

	/**
	 * {@inheritDoc}
	 */
	public int capacity() {
		return hashTable.length;
	}

	/*
	 * Class defining the objects that holds the key,value pairs in the hash
	 * table.
	 */
	private static class KeyValuePair<K, V> {
		public K key;
		public V value;

		public KeyValuePair(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
}
