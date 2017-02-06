package hw01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * Determine if the elements of an array can be split into two groups such that
 * the sum of one group is a non-zero multiple of 10 and the sum of the other group is
 * odd. <code> 
 * Example:
 *   Given: {1, 2, 6, 3, 1}
 *   Result: true		because {1,2,6,1}, {3} is one possibility.
 *   
 * Example:
 *   Given: {4, 3, 5, 2}  
 *   Result: false
 * </code>
 */
public class SplitOddTen {

	/**
	 * Determine if the values in nums can be split into two groups where
	 * the sum of one is a non-zero multiple of 10 and the sum of the other
	 * is odd.
	 * 
	 * @param nums the numbers.
	 * @return true if it is possible, false if not.
	 */
	public static boolean splitOdd10(int[] nums) {

		ArrayList<Integer> gp1List = new ArrayList<Integer>();
		ArrayList<Integer> gp2List = new ArrayList<Integer>();

		return splitOdd10(nums, 0, 0, gp1List, 0, gp2List) ;

	}
	
	
	public static boolean splitOdd10(int[] nums, int start, int gp1Sum,ArrayList<Integer> gp1List, int gp2Sum,ArrayList<Integer> gp2List
			){
		if (start >= nums.length && gp1Sum == gp2Sum) {
			// No numbers left and the sums are equal - solution!

			return true;

		}else if(gp1Sum%10==0 && gp2Sum%2!=0 ){
			return true;


		}else if(gp2Sum%10==0 && gp1Sum%2!=0){
			return true;
			

		} else if (start >= nums.length) {
			// No numbers left and the sums are not equal - no solution!
			return false;
		} else {
			// try putting nums[start] in group 1.
			if (splitOdd10(nums, start + 1, gp1Sum + nums[start], gp1List, gp2Sum, gp2List)) {
				// Found a solution with nums[start] in group 1!

				gp1List.add(nums[start]);
				gp1Sum+=nums[start];
				return true;
			}
			// no solution with nums[start] in group 1, so backtrack.

			// nums[start] didn't work in group 1 so now try it in group 2
			if (splitOdd10(nums, start + 1, gp1Sum, gp1List, gp2Sum + nums[start], gp2List)) {
				// Found a solution with nums[start] in group 2!
				gp2List.add(nums[start]);
				gp2Sum+= nums[start];
				return true;
			}
			// no solution with nums[start] in group 2, so backtrack.

			// nums[start] didn't work in either group... so no solution.
			return false;
		}



	}

	@Test
	public void testNoMult10() {
		assertFalse("Incorrect result with no way to make a non-zero multiple of 10", 
				splitOdd10(new int[] {1, 1, 2, 3}));
	}

	@Test
	public void testNoOdd() {
		assertFalse("Incorrect result with no way to make odd sum", 
				splitOdd10(new int[] {2, 12, 6, 4}));
	}

	@Test
	public void testWorks1NumEachTenFirst() {
		assertTrue("Incorrect result when possible with 1 number each", 
				splitOdd10(new int[] {10, 3}));
	}

	@Test
	public void testWorks1NumEachOddFirst() {
		assertTrue("Incorrect result when possible with 1 number each", 
				splitOdd10(new int[] {3, 10}));
	}

	@Test
	public void testWorksSeveralTo10() {
		assertTrue("Incorrect result when several numbers make 10", 
				splitOdd10(new int[] {1, 5, 3, 2}));
	}

	@Test
	public void testWorksSeveralToMultipleOf10() {
		assertTrue("Incorrect result when several numbers make multiple of 10", 
				splitOdd10(new int[] {1, 5, 3, 2, 7, 3}));
	}

	@Test
	public void testWorksSeveralInOdd() {
		assertTrue("Incorrect result when several numbers must be in odd group", 
				splitOdd10(new int[] {1, 10, 3, 2, 3}));
	}

	@Test
	public void testWorksSeveralEach() {
		assertTrue("Incorrect result when several numbers must be each group", 
				splitOdd10(new int[] {1, 4, 3, 2, 3, 3, 2, 1}));
	}
}
