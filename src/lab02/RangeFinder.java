package lab02;

import java.util.Scanner;

/**
 * This program finds the range in a given set of integers. The input will consist of 
 * a single line of space delimited integer values. 
 * The integers are not necessarily ordered and will be in the range [-1000...1000]. 
 * There will be at least 2 integers on the line. 
 * There is no stated limit to the number of integers on the line.
 *
 * @author Briona Davis, Siddharth Batra
 * @author Dickinson College
 * @version February 7th, 2017
 *
 */
public class RangeFinder {
	
	/**
	 * Default constructor for RangeFinder program.
	 */
	public RangeFinder() {
		
	}
	
	/**
	 * This wrapper method is used to execute the program in order to find the range of the given integers.
	 * @return the range of the given values
	 */
	public int findRange() {
		Scanner scnr = new Scanner(System.in); 
		int first = scnr.nextInt();
		int min = first;
		int max = first;
		while (scnr.hasNext()){
			int nextNum = scnr.nextInt();	
			if (nextNum < min){
				min = nextNum; 
			}
			if (nextNum > max) {
				max = nextNum;
			}
		}
		scnr.close();
		return max - min;
	}
		
	public static void main(String[] args) {
		RangeFinder rf = new RangeFinder();
		System.out.println("The range is " + rf.findRange() + ".");
		
	}
}
