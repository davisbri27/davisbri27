package lab02;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This program finds the average of the trials in each set is computed 
 * and then the final result is found by averaging the set averages.
 * 
 * The input will consist of zero or more lines of comma delimited 
 * decimal values followed by a line containing only the value -1. 
 * Each comma delimited values indicate the result of a single trial. 
 * 
 * Each line contains the results of each trial in a set. 
 * The result of each trial will be a decimal value between positive 
 * and negative one million and representable in a double value. 
 * 
 * Lines will consist of no more than 50 values. There will be no more than 1000 lines. 
 * The line containing only -1 indicates the end of the input.
 *
 * @author Briona Davis, Siddharth Batra
 * @author Dickinson College
 * @version February 7th, 2017
 *
 */
public class MeanMeans {

	private ArrayList<Double> avgs;

	/**
	 * This constructor initializes the arrayList avgs, which stores all the averages of trials from each set.
	 */
	public MeanMeans() {
		avgs = new ArrayList<Double>();
	}
	
	/**
	 * This wrapper method calls the methods to compute the final result after averaging the set of averages.
	 * @return the final average! WOOHOO!
	 */
	public Double findMean() {
		return returnFinalAvg(avgOfLines());
	}
	
	/** This method returns an arrayList of the averages of each line.
	 * @return arrayList of averages of sets.
	 */
	public ArrayList<Double> avgOfLines() {
		Scanner scnr = new Scanner(System.in);
		String curLine = scnr.nextLine();
		String[] tokens = curLine.split(","); //create array of trial values in a line
		
		while (!(tokens[0].equals("-1") && tokens.length == 1)) {
			double lineTotal= 0;
			for (int i=0; i < tokens.length; i++){
				double d= Double.parseDouble(tokens[i]); // convert strings to doubles in tokens array
				lineTotal= lineTotal+d; //add totals of each line
			}
			avgs.add(lineTotal/tokens.length); // calculates average of values in a line, and adds them to arrrayList avgs
			curLine=scnr.nextLine(); 
			tokens=curLine.split(",");
		}
		scnr.close();
		return avgs;
		
	}
	
	/**
	 * This method computes the final average of all the sets, and returns this value as a double.
	 * @param avgs the arrayList of averages of all the sets
	 * @return final result after averaging the set of averages.
	 */
	public Double returnFinalAvg(ArrayList<Double> avgs) {
		double finalTotal=0; 
		for(int i=0; i<avgs.size(); i++){
			finalTotal= finalTotal+ avgs.get(i); // adds all line averages
		}
			return finalTotal/avgs.size();	// returns final average of averages
	}
	
	public static void main(String[] args) {
		MeanMeans meanOfMeans = new MeanMeans();
		Double mean = meanOfMeans.findMean();
				
		if (meanOfMeans.avgs.size() == 0) {
			System.out.println("No lines.");
		}
		else {
			System.out.println(Math.round(mean * 100.00)/100.00); // rounds average to 2 decimal places.
		}
		
	}
}
