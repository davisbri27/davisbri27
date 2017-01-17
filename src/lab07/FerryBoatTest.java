package lab07;

import org.junit.Test;

import testbase.StdioTestBase;

public class FerryBoatTest extends StdioTestBase {

	@Test
	public void A1_SampleInput1() {
		String input = "20 3\n380 ABC left\n720 DEF left\n1340 GHI right";
		String output = "1 : ABC DEF\n2 : GHI";

		runTest(FerryBoat.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void A2_SampleInput2() {
		String input = "20 3\n1480 ABC left\n720 DEF right\n575 GHI left";
		String output = "1 : ABC\n2 : DEF\n3 : GHI\n4 : empty";

		runTest(FerryBoat.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void A3_SampleInput3() {
		String input = "20 0";
		String output = "Day Off!";

		runTest(FerryBoat.class, input, output,
				"Incorrect result for sample input 3.");
	}
}
