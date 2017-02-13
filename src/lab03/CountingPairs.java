package lab03;

import java.util.*;

/**
 * 
 * @author Dickinson College
 * @author Briona Davis, Seongho Lee
 * @version Feb 14, 2017
 *
 */
public class CountingPairs {
	private int valN, valK; // value of K and N
	private ArrayList<Long> nums;	// Number elements of the second line into an arraylist.
	private HashMap<Long, Long> hashmap;

	/**
	 * Construct a new CountingPairs object and initialize an array of int with
	 * random size.
	 */
	public CountingPairs() {
		nums = new ArrayList<Long>();
		hashmap = new HashMap<Long, Long>();
	}

	/**
	 *
	 */
	public void readFile() {
		Scanner scr = new Scanner(System.in);
		//First the first line contains two integers, values of N and K, respectively..
		valN = scr.nextInt();
		valK = scr.nextInt();

		//read off all elements in the file until it reaches the end.
		for (int i = 0; i < valN; i++) {
			nums.add((long) scr.nextInt());
		}

		scr.close();
	}

	/**
	 * Does calculation + comparison + returns the output.
	 * 
	 * @return
	 */
	public int countPairs() {
		readFile();
		int count = 0;

		for (int i = 0; i < valN; i++) {
			if (hashmap.containsKey(nums.get(i))) {
				hashmap.put(nums.get(i), hashmap.get(nums.get(i)) + 1);
			} else {
				hashmap.put(nums.get(i), (long) 1);
			}
		}

		Set<Long> key = hashmap.keySet();
		for (Long x : key) {
			if (valK == 0) {
				count += hashmap.get(x) * (hashmap.get(x) - 1) / 2;
			}
			else if (x - valK >= 0 && hashmap.containsKey(x - valK)) {
				count += hashmap.get(x) * hashmap.get(x - valK);
			}
		}
		/*
		 * Deleted 2/12/2017
		for (int i = 0; i < valN; i++) {
			int x = data[i];
			if (valK == 0) {

			}
			if (x - valK >= 0 && hashmap.containsKey(x - valK)) {
				count++;
				hashmap.remove(x);
			}
			if (x + valK < MAX_K && hashmap.containsKey(x + valK)) {
				count++;
				hashmap.remove(x); // redundancy
			}
		}
		*/

		return count;
	}

	/**
	 * 
	 * @param args
	 *            none
	 */
	public static void main(String[] args) {
		CountingPairs cp = new CountingPairs();
		System.out.println(cp.countPairs());
	}
}
