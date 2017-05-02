package lab10;
import org.junit.Test;

import testbase.StdioTestBase;

public class RegistrationSystemTest extends StdioTestBase {
		
	@Test
	public void A1_SampleInput1() {
		String input = "A benrush Benjamin Rush\nA johndickinson John Dickinson";
		String output = "OK\nOK";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void A2_SampleInput2() {
		String input = "A benrush Benjamin Rush\nI benrush";
		String output = "OK\nBenjamin Rush";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void A3_SampleInput3() {
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude";
		String output = "OK\nbenrush1";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample input 3.");
	}
	
	@Test
	public void testAskUserNotInSystem(){
		String input = "A benrush Benjamin Rush\nI andyiscool";
		String output = "OK\nAVAILABLE";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for available.");
	}
	@Test
	public void testAvailable1(){
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude\nI benrush1";
		String output = "OK\nbenrush1\nFake Dude";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for available1.");
	}
	@Test
	public void testAvailable2(){
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude\nA benrush BriBri\nD benrush2\nI benrush2";
		String output = "OK\nbenrush1\nbenrush2\nAVAILABLE";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample available2.");
	}
	@Test
	public void testDeleteAdd(){
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude\nD benrush2\nA benrush Bri\nI benrush2";
		String output = "OK\nbenrush1\nbenrush2\nBri";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample deleteAdd.");
	}
	@Test
	public void testbenrush11(){
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude\nA benrush1 Benji\nI benrush11";
		String output = "OK\nbenrush1\nbenrush11\nBenji";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample benrush11.");
	}
	@Test
	public void testbenrush12(){
		String input = "A benrush Benjamin Rush\nA benrush Fake Dude\nA benrush1 Benji\nA benrush1 LOL\nI benrush12";
		String output = "OK\nbenrush1\nbenrush11\nbenrush12\nLOL";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample benrush12.");
	}
	@Test
	public void testAddThenRemove(){
		String input = "A benrush Benjamin Rush\nI benrush\nD benrush\nI benrush";
		String output = "OK\nBenjamin Rush\nAVAILABLE";

		runTest(RegistrationSystem.class, input, output,
				"Incorrect result for sample test.");
	}
	
}
