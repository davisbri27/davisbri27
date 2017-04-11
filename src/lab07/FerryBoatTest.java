package lab07;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

	@Test
	/**
	 * Testing the case when all the cars are on the left side
	 */
	public void testAllOnLeft() {
		String input = "15 3\n1480 ABC left\n720 DEF left\n575 GHI left";
		String output = "1 : ABC\n2 : empty\n3 : DEF GHI\n4 : empty";

		runTest(FerryBoat.class, input, output,
				"Incorrect result when all cars are on the left bank.");
	}

	@Test
	/**
	 * Testing the case when all the cars are on the right side
	 */
	public void testAllOnRight() {
		String input = "15 4\n980 ABC right\n420 DEF right\n575 GHI right\n1200 JKL right";
		String output = "1 : empty\n2 : ABC DEF\n3 : empty\n4 : GHI\n5 : empty\n6 : JKL";

		runTest(FerryBoat.class, input, output,
				"Incorrect result when all cars are on the right bank.");
	}

	@Test
	/**
	 * Testing the case when there is no car on both sides
	 */
	public void testNoCar() {
		String input = "100 0";
		String output = "Day Off!";

		runTest(FerryBoat.class, input, output,
				"Incorrect result with no car at all.");
	}

	@Test
	/**
	 * Testing that the ferry will come back to the left side
	 */
	public void testBackToLeft() {
		String input = "100 1\n100 ABC left";
		String output = "1 : ABC\n2 : empty";

		runTest(FerryBoat.class, input, output,
				"The ferry didn't come back to the left bank.");
	}
	
	@Test
	/**
	 * Testing that the ferry will not underload
	 */
	public void testNotUnderLoad() {
		String input = "20 4\n980 ABC left\n420 DEF left\n575 GHI left\n300 JKL right";
		String output = "1 : ABC DEF GHI\n2 : JKL";

		runTest(FerryBoat.class, input, output, "The ferry underloads.");
	}

	@Test
	/**
	 * Testing that the ferry will not overload
	 */
	public void testNotOverLoad() {
		String input = "10 4\n980 ABC left\n420 DEF left\n575 GHI right\n300 JKL right";
		String output = "1 : ABC\n2 : GHI JKL\n3 : DEF\n4 : empty";

		runTest(FerryBoat.class, input, output, "The ferry overloads.");
	}


	@Test
	/**
	 * Testing the case when the ferry has the maximum length, i.e 100 meters
	 */
	public void testMaxLength() {
		String input = "100 4\n8980 ABC left\n1020 DEF left\n575 GHI left\n300 JKL right";
		String output = "1 : ABC DEF\n2 : JKL\n3 : GHI\n4 : empty";

		runTest(FerryBoat.class, input, output,
				"Incorrect result when the ferry has the maximum length");
	}
}