package lab06;

import org.junit.Test;

import testbase.StdioTestBase;

public class ParadeShuffleTest extends StdioTestBase {

	@Test
	public void testSampleInput1() {
		String input = "4\n1 2 3 4\n1 3 2 4";
		String output = "Yes.";

		runTest(ParadeShuffle.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void testSampleInput2() {
		String input = "4\n1 2 3 4\n1 4 2 3";
		String output = "No.";

		runTest(ParadeShuffle.class, input, output,
				"Incorrect result for sample input 2.");
	}
}
