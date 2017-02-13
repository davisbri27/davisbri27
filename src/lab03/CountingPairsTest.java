package lab03;

import java.io.File;

import org.junit.Test;

import testbase.StdioTestBase;

public class CountingPairsTest extends StdioTestBase {

	@Test
	public void testSample1() {
		// Input from a string in the test.
		String input = "5 2\n1 5 3 4 2";
		Integer output = 3;
		runTest(CountingPairs.class, input, output,
				"Incorrect result for sample input 1.");
	}
	
	@Test
	public void testSample2() {
		// Input from a text file in the package.
		File input = new File("src/lab03/input2.txt");
		Integer output = 0;
		runTest(CountingPairs.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void testSamePositiveTwoNums() {
		File input = new File("src/lab03/input3.txt");
		Integer output = ;
		runTest(CountingPairs.class, input, output,
				"Incorrect result for sample input 3.");
	}
	
	@Test
	public void testSamePositiveMultipleNums() {
		File input = new File("src/lab03/input4.txt");
		Integer output = ;
		runTest(CountingPairs.class, input, output,
				"Incorrect result for sample input 4.");
	}
	
	
	//N == 0, 2digits
	//K == 0, some # in b/w, 2500 (2500, 0 elements)
	//all same # in the 2nd line
	//N == 5000
	
	//all zeros
	//long # with 50000
	
}
