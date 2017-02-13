package lab02;

import org.junit.Test;

import testbase.StdioTestBase;

public class RangeFinderTest extends StdioTestBase {

	@Test
	public void test1() {
		// Input from a string in the test.
		String input = "1 2 3 4 5";
		// Output from a string in the test
		String output = "The range is 4.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}

	@Test
	public void testAllSame() {
		// Input from a string in the test.
		String input = "5 5 5 5";
		// Output from a string in the test
		String output = "The range is 0.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}

	@Test
	public void testNegatives() {
		// Input from a string in the test.
		String input = "1 -2 3 4 -5";
		// Output from a string in the test
		String output = "The range is 9.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}

	@Test
	public void testTwoNumbers() {
		// Input from a string in the test.
		String input = "0 -1";
		// Output from a string in the test
		String output = "The range is 1.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}

	@Test
	public void testLargeNumbers() {
		// Input from a string in the test.
		String input = "234 678 -999 869 300";
		// Output from a string in the test
		String output = "The range is 1868.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}
	
	@Test
	public void testLargeNumberAtEnd() {
		// Input from a string in the test.
		String input = "234 678 -999 869 999";
		// Output from a string in the test
		String output = "The range is 1998.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}
	
	@Test
	public void testSnallNumberAtEnd() {
		// Input from a string in the test.
		String input = "234 678 -999 869 -1000";
		// Output from a string in the test
		String output = "The range is 1869.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");
	}
	
	@Test
	public void test0s() {
		// Input from a string in the test.
		String input = "0 0 0";
		// Output from a string in the test
		String output = "The range is 0.";

		runTest(RangeFinder.class, input, output,
				"Incorrect result for sample input.");

	}
}
