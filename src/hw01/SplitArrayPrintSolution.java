package hw01;

import java.util.ArrayList;

public class SplitArrayPrintSolution {

	/**
	 * If the values in nums can be split into two groups with equal sum, print
	 * out two such groups. There may be more than one, but this method prints
	 * only one. If not such groups exist, print "No solution!".
	 * 
	 * @param nums
	 *            the numbers to be split.
	 */
	public static void splitArray(int[] nums) {
		ArrayList<Integer> gp1List = new ArrayList<Integer>();
		ArrayList<Integer> gp2List = new ArrayList<Integer>();

		if (splitArray(nums, 0, 0, gp1List, 0, gp2List)) {
			printList("gp1: ", gp1List);
			printList("gp2: ", gp2List);
		} else {
			System.out.println("No solution!");
		}
	}

	/**
	 * Recursive problem transformation:
	 * 
	 * Given a list of numbers, starting point in the list and initial values
	 * for gp1Sum and gp2Sum, determine if the values in nums beginning at index
	 * sum can be split into two groups such that when the values one group are
	 * added to gp1Sum and the values in the other are added to gp2Sum, the
	 * resulting totals are equal.
	 * 
	 * @param nums
	 *            the numbers
	 * @param start
	 *            the starting point in numbers.
	 * @param gp1Sum
	 *            initial sum for group 1.
	 * @param gp1List
	 *            a list of the numbers in group 1.
	 * @param gp2Sum
	 *            initial sum for group 2.
	 * 
	 * @param gp2List
	 *            a ilst of the numbers in group 2.
	 * 
	 * @return true if the nums can be split correctly, false if not.
	 */
	public static boolean splitArray(int[] nums, int start, int gp1Sum,
			ArrayList<Integer> gp1List, int gp2Sum, ArrayList<Integer> gp2List) {
		/*
		 * If there are no numbers left (i.e. start is too large) and the sums
		 * are equal then there is a solution.
		 * 
		 * If there are no numbers left and the sums are not equal then there is
		 * no solution.
		 * 
		 * Otherwise, try putting the number at start into group 1 and see if
		 * that leads to a solution. If so, then there is a solution! If not,
		 * try putting the number at start into group 2 and see if that leads to
		 * a solution. If so there is a solution! If not then there is no
		 * solution with the number at start in either group, thus there is no
		 * solution.
		 */
		if (start >= nums.length && gp1Sum == gp2Sum) {
			// No numbers left and the sums are equal - solution!
			return true;
		} else if (start >= nums.length) {
			// No numbers left and the sums are not equal - no solution!
			return false;
		} else {
			// try putting nums[start] in group 1.
			if (splitArray(nums, start + 1, gp1Sum + nums[start], gp1List, gp2Sum, gp2List)) {
				// Found a solution with nums[start] in group 1!
				return true;
			}
			// no solution with nums[start] in group 1, so backtrack.

			// nums[start] didn't work in group 1 so now try it in group 2
			if (splitArray(nums, start + 1, gp1Sum, gp1List, gp2Sum + nums[start], gp2List)) {
				// Found a solution with nums[start] in group 2!
				return true;
			}
			// no solution with nums[start] in group 2, so backtrack.

			// nums[start] didn't work in either group... so no solution.
			return false;
		}
	}

	/**
	 * Print the title followed by the elements of the list, all on a single
	 * line.
	 * 
	 * @param title
	 *            the title.
	 * @param list
	 *            the list.
	 */
	public static void printList(String title, ArrayList<?> list) {
		System.out.print(title);
		for (Object o : list) {
			System.out.print(o + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		splitArray(new int[] { 1, 2, 4, 1, 3, 1 });
	}
}
