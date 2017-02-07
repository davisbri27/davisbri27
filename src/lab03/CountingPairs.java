package lab03;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 * @author Dickinson College
 * @author Briona Davis, Seongho Lee
 * @version Feb 14, 2017
 *
 */
public class CountingPairs {
	private int valN, valK; //
	private String[] numbers;
	private int[] data;
	private HashMap<Integer, Boolean> hashmap;
	public final static int MAX_K = 2500; // Maximum value of some integer K.

	/**
	 * Construct a new CountingPairs object and initialize an array of int with
	 * random size.
	 */
	public CountingPairs() {
		data = new int[10];
		hashmap = new HashMap<Integer, Boolean>();
	}

	/**
	 *
	 */
	public void readFile() {
		Scanner scr = new Scanner(System.in);
		String line = scr.nextLine();
		numbers = line.split(" ");
		// Call this method to initialize values of N and K.
		setFirstLine();

		while (scr.hasNextLine()) {
			line = scr.nextLine();
			numbers = line.split(" ");
		}

		setSecondLine();

		scr.close();
	}

	/**
	 * First line contains values of N and K. sets the values, respectively.
	 */
	public void setFirstLine() {
		valN = Integer.parseInt(numbers[0]);
		valK = Integer.parseInt(numbers[1]);
	}

	/**
	 * Set data with new length of the second line, put the values into data.
	 */
	public void setSecondLine() {

		data = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			data[i] = Integer.parseInt(numbers[i]);
		}

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
			hashmap.put(data[i], true);
		}

		for (int i = 0; i < valN; i++) {
			int x = data[i];
			if (x - valK >= 0 && hashmap.containsKey(x - valK))
				count++;
			if (x + valK < MAX_K && hashmap.containsKey(x + valK))
				count++;
			hashmap.remove(x); // redundancy
		}

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
