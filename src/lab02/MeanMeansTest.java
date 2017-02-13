package lab02;

import java.io.File;

import org.junit.Test;

import testbase.StdioTestBase;

/**
 * @author Briona Davis, Siddharth Batra
 * @author Dickinson College
 * @version February 7th, 2017
 *
 */
public class MeanMeansTest extends StdioTestBase {

	@Test
	public void testSample1() {
		String input = "-1\n";
		String output = "No lines.";

		runTest(MeanMeans.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void testSample2() {
		// Input from a text file
		File input = new File("src/lab02/meanmeans2.txt");
		// Output from an object the test
		Double output = 3.18;

		runTest(MeanMeans.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void testNegativeNumber() {
		// Input from a text file
		File input = new File("src/lab02/meanmeans3.txt");
		// Output from an object the test
		Double output = 4.57;

		runTest(MeanMeans.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void testAllSame() {
		// Input from a text file
		File input = new File("src/lab02/meanmeans4.txt");
		// Output from an object the test
		Double output = -2.0;

		runTest(MeanMeans.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void testNegativeOneStart() {
		// Input from a text file
		File input = new File("src/lab02/meanmeans5.txt");
		// Output from an object the test
		Double output = -2.0;

		runTest(MeanMeans.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
}
