package hw02;

import java.util.Arrays;

/**
 * Snippets of code for problem #1 on homework #2.
 */
public class Hw02No1 {

	/**
	 * a.
	 * 
	 * Count the occurrences of a character in a string..
	 * 
	 * @param str
	 *            the string to be searched.
	 * @param ch
	 *            the character to be searched for.
	 * @return the number of times val appears in arr.
	 */
	public static int countOccurances(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char cur = str.charAt(i);
			if (cur == ch) {
				count = count + 1;
			}
		}
		return count;
	}
	
	/**
	 * b.
	 * 
	 * Compute the factorial of the given value.
	 * 
	 * @param val
	 *            the value for which to compute the factorial.
	 * @return val!
	 */
	public static double factorial(int val) {
		double fact = 1;
		for (int i = val; val > 1; val--) {
			fact = fact * i;
		}
		return fact;
	}
	

	/**
	 * c.
	 * 
	 * Sum up the first 10 elements of arr.
	 * 
	 * @param arr
	 *            an array of values.
	 * @return the sum of the first 10 elements of arr or -1 if the array
	 *         contains less than 10 elements.
	 */
	public static int sumFirst10(int[] arr) {
		if (arr.length < 10) {
			return -1;
		} else {
			int sum = 0;
			for (int i = 0; i < 10; i++) {
				sum = sum + arr[i];
			}
			return sum;
		}
	}

	/**
	 * d.
	 * 
	 * Build a triangle string from the provided string. For example if the
	 * string is "abcd" the triangle string will be:
	 * 
	 * <code>
	 * a
	 * bb
	 * ccc
	 * dddd
	 * </code>
	 * 
	 * @param str
	 *            the string.
	 * @return the triangle string for str.
	 */
	public static String buildTriangleString(String str) {
		String triangle = "" + str.charAt(0) + "\n";
		for (int i = 1; i < str.length(); i++) {
			for (int j = 0; j < i; j++) {
				triangle = triangle + str.charAt(i);
			}
			triangle = triangle + "\n";
		}
		return triangle;
	}


	/**
	 * e.
	 * 
	 * Return the sum of the elements at the harmonic locations in vals. The
	 * harmonic locations are at 1/2, 1/4, 1/8, etc... of the length of the
	 * array.
	 * 
	 * @param vals the values, assume the length of this array is a power of 2.
	 * @return the sum of the elements at the harmonic locations.
	 */
	public static int sumHarmonics(int[] vals) {
		int total = 0;
		int i = vals.length / 2;
		while (i > 0) {
			total = total + vals[i];
			i = i / 2;
		}
		return total;
	}
	
	/**
	 * f.
	 * 
	 * Determine if any layer of the cube is homogeneous (i.e. all of its values
	 * are the same.)
	 * 
	 * @param cube
	 *            a cubic (all dimensions have equal size) 3-d array.
	 * @return true if one of the layers in the cube is homogeneous.
	 */
	public static boolean hasHomgeneousLayer(int[][][] cube) {
		for (int layer = 0; layer < cube.length; layer++) {
			int val = cube[layer][0][0];
			boolean layerIsHomogeneous = true;
			for (int row = 0; row < cube[layer].length; row++) {
				for (int col = 0; col < cube[layer][row].length; col++) {
					if (cube[layer][row][col] != val) {
						layerIsHomogeneous = false;
					}
				}
			}
			if (layerIsHomogeneous) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * g.
	 * 
	 * Return the sum of the largest half of the values in vals.
	 * 
	 * @param vals
	 *            the values.
	 * @return the sum of the largest half of the values.
	 */
	public static double topHalfTotal(double[] vals) {
		Arrays.sort(vals);
		double total = 0;
		for (int i = vals.length / 2; i < vals.length; i++) {
			total = total + vals[i];
		}
		return total;
	}
}
