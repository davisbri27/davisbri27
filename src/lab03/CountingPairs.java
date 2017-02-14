package lab03;

import java.util.*;

/**
 * Given N integers, count the number of pairs of those integers that have a
 * difference equal to another integer K.
 * 
 * The first line of input will contain 2 space delimited integers giving the
 * values of N and K with the following constraints:
 * 
 * 0 <= N <= 5000 0 <= K <= 2500
 * 
 * The second line of input will contain N space delimited integers. The value
 * of each integer will be in the range [0...2500].
 * 
 * @author Dickinson College
 * @author Briona Davis, Seongho Lee
 * @version Feb 14, 2017
 *
 */
public class CountingPairs {
	private int valN, valK; // value of K and N
	private ArrayList<Integer> nums; // contain the second line integers.
	private HashMap<Integer, Integer> hashmap;

	/**
	 * Construct a new CountingPairs object and initialize an ArrayList of
	 * Integer and create Hashmap of Integer key and Integer value.
	 */
	public CountingPairs() {
		nums = new ArrayList<Integer>();
		hashmap = new HashMap<Integer, Integer>();
	}

	/**
	 * The first line with integer values is read and stored into valN and valK,
	 * respectively. The second line with integer values is read and stored in
	 * an arraylist.
	 */
	public void readFile() {
		Scanner scr = new Scanner(System.in);

		valN = scr.nextInt();
		valK = scr.nextInt();

		// read off all elements in the file until it reaches the end.
		for (int i = 0; i < valN; i++) {
			nums.add((Integer) scr.nextInt());
		}

		scr.close();
	}

	/**
	 * Find the number of pairs of integers with difference K.
	 * 
	 * @return a single integer indicating the number of pairs of integers with
	 *         difference K.
	 */
	public int countPairs() {
		readFile();
		int count = 0;

		for (int i = 0; i < valN; i++) {
			if (hashmap.containsKey(nums.get(i))) {
				// increase the frequency by 1 if it already contains the key.
				hashmap.put(nums.get(i), hashmap.get(nums.get(i)) + 1);
			} else {
				// add this new key into hashmap.
				hashmap.put(nums.get(i), (Integer) 1);
			}
		}

		Set<Integer> key = hashmap.keySet();
		for (Integer x : key) {
			if (valK == 0) {
				// frequency of the number = n
				// (n) * (n-1) / 2
				count += hashmap.get(x) * (hashmap.get(x) - 1) / 2;
			} else if (x - valK >= 0 && hashmap.containsKey(x - valK)) {
				// (frequency of the number) * (frequency of the other pair with the number)
				count += hashmap.get(x) * hashmap.get(x - valK);
			}
		}

		return count;
	}

	/**
	 * Print the number of pairs of integers with difference K.
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {
		CountingPairs cp = new CountingPairs();
		System.out.println(cp.countPairs());
	}
}
