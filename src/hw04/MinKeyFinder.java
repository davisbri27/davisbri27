package hw04;

/**
 * Find the key associated with the minimum value in a tree.
 */
public class MinKeyFinder implements CS232Visitor<String, Integer> {
	private int minValue;
	private String minKey;

	public MinKeyFinder() {
		minValue= Integer.MAX_VALUE;
		minKey= null;
	}
	
	

	/**
	 * {@inheritDoc}
	 */
	public void visit(String key, Integer value) {
		if (value < minValue) {
			minValue = value;
			minKey = key;
			}

	}

	/**
	 * Get the key associated with the minimum value in the tree.
	 * 
	 * @return the key associated with the minimum value.
	 */
	public String getMinKey() {
		return minKey;
	}
	
	public static void main(String[] args) {
		String[] keys = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J" };
		Integer[] vals = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		CS232LinkedBinaryTree<String, Integer> t = new
		CS232LinkedBinaryTree<String, Integer>(keys, vals);
		MinKeyFinder mkf = new MinKeyFinder();
		t.visitPreOrder(mkf);
		System.out.println("Key associated with the min value is: " +
		mkf.getMinKey());

	}
}
