package lab09;

import org.junit.Test;

import testbase.StdioTestBase;

public class SalesDataTest extends StdioTestBase {
	
	
	@Test
	public void A1_SampleInput1() {
		String input = "A 3/1/2015 3.45\nA 3/4/2016 1.23\nA 4/1/2015 6.78\nS\n";
		String output = "$1.23";

		runTest(SalesData.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void A2_SampleInput2() {
		String input = "A 3/1/2015 3.45\nA 3/4/2016 1.23\nA 4/1/2015 6.78\nK 2\n";
		String output = "$8.01";

		runTest(SalesData.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void testKEmptyTree() {
		String input = "A 3/1/2015 3.45\nD 3/1/2015\nK 3\n";
		String output = "$0.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	@Test
	public void testGetWithinRange() {
		String input = "A 3/2/2015 3.45\nR 3/1/2015 3/5/2015\n";
		String output = "$3.45";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	
	@Test
	public void testGetTotalSalesInEmptyTree() {
		String input = "A 3/1/2015 3.45\nD 3/1/2015\nG 3/1/2015 3\n";
		String output = "$0.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}

	@Test
	public void testDeleteMiddleDate() {
		String input = "A 3/1/2015 3.45\nA 3/4/2016 1.23\nA 4/1/2015 6.78\nD 4/1/2015\nS\n";
		String output = "$1.23";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}

	@Test
	public void testNoMostRecentDate() {
		String input = "A 3/1/2015 3.45\nD 3/1/2015\nS\n";
		String output = "$0.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	
	@Test
	public void testDeleteMostRecentDate() {
		String input = "A 3/1/2015 3.45\nA 3/4/2016 1.23\nA 4/1/2015 6.78\nD 3/4/2016\nS\n";
		String output = "$6.78";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	@Test
	public void testGetTotalAmountOfSalesForKDays() {
		String input = "A 3/1/2015 1.00\nA 3/2/2015 2.00\nA 3/20/2015 5.00\nG 3/1/2015 5\n";
		String output = "$3.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	@Test
	public void testGetTotalAmountOfSalesForKDaysWithConsecutiveDays() {
		String input = "A 3/1/2015 1.00\nA 3/2/2015 2.00\nA 3/3/2015 3.00\nA 3/4/2015 4.00\nG 3/1/2015 3\n";
		String output = "$6.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	@Test
	public void testGetSalesWithinRange() {
		String input = "A 3/1/2015 1.00\nA 3/2/2015 2.00\nA 3/3/2015 3.00\nA 3/4/2015 4.00\nA 3/5/2015 5.00\nR 3/2/2015 3/4/2015\n";
		String output = "$9.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	@Test
	public void testKeysNotInRange() {
		String input = "A 3/1/2015 1.00\nA 3/2/2015 2.00\nA 3/3/2015 3.00\nA 3/4/2015 4.00\nA 3/5/2015 5.00\nR 3/2/2013 3/4/2014\n";
		String output = "$0.00";

		runTest(SalesData.class, input, output,
				"Incorrect result for this input.");
	}
	
	@Test
	public void testFormattingS(){
		String input = "A 3/1/2017 1.2\nS\n";
		String output = "$1.20";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingS.");
	}
	
	@Test 
	public void testFormattingK(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nK 1\n";
		String output = "$1.20";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingK.");
	}
	@Test 
	public void testFormattingK2(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nK 2\n";
		String output = "$2.40";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingK2.");
	}
	@Test 
	public void testFormattingK3(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nA 3/3/2017 1.2\nA 3/4/2017 1.2\nK 3\n";
		String output = "$3.60";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingK3.");
	}
	@Test 
	public void testFormattingG2(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nA 3/3/2017 1.2\nA 3/4/2017 1.2\nG 3/2/2017 2\n";
		String output = "$2.40";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingG2.");
	}
	
	@Test 
	public void testFormattingR(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nA 3/3/2017 1.2\nA 3/4/2017 1.2\nR 3/2/2017 3/3/2017\n";
		String output = "$2.40";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingR.");
	}
	@Test 
	public void testFormattingR1(){
		String input = "A 3/1/2017 1.2\nA 3/2/2017 1.2\nA 3/3/2017 1.2\nA 3/4/2017 1\nR 3/2/2017 3/4/2017\n";
		String output = "$3.40";

		runTest(SalesData.class, input, output,
				"Incorrect result for testFormattingR1.");
	}
}