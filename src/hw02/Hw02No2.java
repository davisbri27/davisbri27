package hw02;

/**
 * Snippets of code for problem #2 on homework #2.
 */
public class Hw02No2 {

	/**
	 * Given a square array of int values, sum up all values in all rows that
	 * begin with an even number (i.e. vals[i] is even).
	 * 
	 * @param vals
	 *            a square array integer values.
	 * @return the sum of all values in all rows that begin with an even number.
	 */
	public static int sumEvenRows(int[][] vals) {
		int total = 0;
		for (int row=0; row < vals.length; row++) {
			if (vals[row][0] % 2 == 0) {
				for (int col=0; col < vals[row].length; col++) {
					total = total + vals[row][col];
				}
			}
		}
		return total;
	}
}
