package lab11;
import org.junit.Test;

import testbase.StdioTestBase;

public class PlayingWithWheelsTest extends StdioTestBase {
		
	@Test
	public void A1_SampleInput1() {
		String input = "1335\n2244\n3456\n4567";
		String output = "4";

		runTest(PlayingWithWheels.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void A2_SampleInput2() {
		String input = "1234\n1236\n1236";
		String output = "-1";

		runTest(PlayingWithWheels.class, input, output,
				"Incorrect result for sample input 2.");
	}
	
	@Test
	public void A3_SampleInput3() {
		String input = "1234\n1236\n1233\n1235\n1244\n1224\n1134\n1334\n0234\n2234";
		String output = "-1";

		runTest(PlayingWithWheels.class, input, output,
				"Incorrect result for sample input 3.");
	}
	
	@Test
	public void startEndSame(){
		String input = "1234\n1234";
		String output = "0";
		
		runTest(PlayingWithWheels.class, input, output,
				"It could not recognize that the start and end point were the same.");
	}
	
	@Test
	public void startEndForbiddenSame(){
		String input = "1234\n1234\n1234";
		String output = "-1";
		
		runTest(PlayingWithWheels.class, input, output,
				"It could not recognize that the start and end point were forbidden.");
	}
	
	@Test
	public void allNeighborsButOneForbidden(){
		String input = "1234\n9999\n2234\n0234\n1334\n1134\n1244\n1224\n1235\n2233\n1133\n1243\n1232\n1223\n1333\n0233";
		String output = "-1";
		
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not -1.");
	}
	@Test
	public void startForbidden(){
		String input = "1234\n9999\n1234";
		String output = "-1";
		
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not -1.");
	}
	
	@Test
	public void endForbidden(){
		String input = "1234\n9999\n9999";
		String output = "-1";
		
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not -1.");
	}
	
	@Test
	public void allNeighborsForbidden(){
		String input = "1234\n9999\n2234\n0234\n1334\n1134\n1244\n1224\n1235\n1233";
		String output = "-1";
		
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not -1.");
	}
	
	@Test
	public void noForbidden(){
		String input = "2345\n5127";
		String output = "9";
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not 9.");
	}
	
	@Test
	public void similarNumbers(){
		String input = "7777\n8888";
		String output = "4";
		
		runTest(PlayingWithWheels.class, input, output,
				"Result was not 4.");
	}
}