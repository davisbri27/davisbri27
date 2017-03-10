package lab04;

import java.io.File;

import org.junit.Test;

import testbase.StdioTestBase;

public class MazeSolverTest extends StdioTestBase {

	@Test
	public void testSample1() {
		File input = new File("src/lab04/maze1in.txt");
		File output = new File("src/lab04/maze1out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 1.");
	}

	@Test
	public void sampleInput2() {
		File input = new File("src/lab04/maze2in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 2.");
	}

	/*
	 * test if it returns the correct output when all of rows and columns
	 * contain only 'X's, S, and E.
	 * 
	 */
	@Test
	public void testAllWalls() {
		File input = new File("src/lab04/maze3in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 3.");
	}

	/*
	 * test if it returns the correct output when it contains only 'S' and 'E'
	 * vertically (2,1)
	 * 
	 */
	@Test
	public void testOnlySandEVertical() {
		File input = new File("src/lab04/maze4in.txt");
		File output = new File("src/lab04/maze4out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 4.");
	}

	/*
	 * test if it returns the correct output when it contains only 'S' and 'E'
	 * horizontally (1,2)
	 */
	@Test
	public void testOnlySandEHorizontal() {
		File input = new File("src/lab04/maze5in.txt");
		File output = new File("src/lab04/maze5out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 5.");
	}

	/*
	 * test if it returns the correct output when it contains only 'S' and 'E'
	 * diagonally (2,2)
	 */
	@Test
	public void testOnlySandEDiagonal() {
		File input = new File("src/lab04/maze6in.txt");
		File output = new File("src/lab04/maze6out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 6.");
	}

	/*
	 * test if it returns the correct output when it contains only 'S' and 'E'
	 * diagonally (2,2) with 'X's in-between.
	 */
	@Test
	public void testSandEDiagonalNoSolution() {
		File input = new File("src/lab04/maze7in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 7.");
	}

	/*
	 * test if it returns the correct output when it contains only one opening
	 * space in the middle of maze.
	 */
	@Test
	public void testOneOpening() {
		File input = new File("src/lab04/maze8in.txt");
		File output = new File("src/lab04/maze8out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 8.");
	}

	/*
	 * test if it returns the correct output when the maze is structured as
	 * U-shape. It also checks if it is out of bounds.
	 */
	@Test
	public void testUShape() {
		File input = new File("src/lab04/maze9in.txt");
		File output = new File("src/lab04/maze9out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 9.");
	}

	/*
	 * test if it returns the correct output when it contains no walls and 'S'
	 * and 'E' in different edges in the maze.
	 */
	@Test
	public void testNoWalls() {
		File input = new File("src/lab04/maze10in.txt");
		File output = new File("src/lab04/maze10out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 10.");
	}

	/*
	 * test if it returns the correct output when it contains vertical walls,
	 * and 'S' and 'E' at different edges in the maze.
	 */
	@Test
	public void testEdgeSandE() {
		File input = new File("src/lab04/maze11in.txt");
		File output = new File("src/lab04/maze11out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 11.");
	}

	/*
	 * test if it returns the correct output when it contains vertical empty
	 * spaces with 'S' and 'E' at the edges in the maze.
	 */
	@Test
	public void testSandEVertical() {
		File input = new File("src/lab04/maze12in.txt");
		File output = new File("src/lab04/maze12out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 12.");
	}

	/*
	 * test if it returns the correct output when it contains vertically blocked
	 * walls in the middle of column with 'S' and 'E' at the opposite edges in
	 * the maze.
	 */
	@Test
	public void testSandEVerticalBlockedWalls() {
		File input = new File("src/lab04/maze13in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 13.");
	}

	/*
	 * test if it returns the correct output when it contains horizontally
	 * blocked walls in the middle of row with 'S' and 'E' at the opposite edges
	 * in the maze.
	 */
	@Test
	public void testSandEHorizontalBlockedWalls() {
		File input = new File("src/lab04/maze14in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 14.");
	}

	/*
	 * test if it returns the correct output when it contains only 'E' and 'S'
	 * diagonally (5,5)
	 */
	@Test
	public void testSandEDiagonal() {
		File input = new File("src/lab04/maze15in.txt");
		File output = new File("src/lab04/maze15out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 15.");
	}

	/*
	 * test if it returns the correct output when it contains vertically blocked
	 * walls in the middle of column with 'E' and 'S' at the opposite edges in
	 * the maze.
	 */
	@Test
	public void testSandEVerticalBlockedWalls2() {
		File input = new File("src/lab04/maze16in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 16.");
	}

	/*
	 * test if it returns the correct output when it contains vertically blocked
	 * walls in the middle of column with 'S' and 'E' at the same row edges in
	 * the maze.
	 */
	@Test
	public void testSandEVerticalBlockedWalls3() {
		File input = new File("src/lab04/maze17in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 17.");
	}

	/*
	 * test if it returns the correct output when it contains vertically blocked
	 * walls in the middle of column and one empty space with 'E' and 'S' at the
	 * opposite edges in the maze.
	 */
	@Test
	public void testSandEVerticalBlocksOneOpening() {
		File input = new File("src/lab04/maze18in.txt");
		File output = new File("src/lab04/maze18out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 18.");
	}

	/*
	 * test if it returns the correct output when it contains empty
	 * spaces horizontally with 'E' and 'S' at the edges in the (!,5) maze.
	 */
	@Test
	public void testSandEHorizontal() {
		File input = new File("src/lab04/maze19in.txt");
		File output = new File("src/lab04/maze19out.txt");

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 19.");
	}
	
	/*
	 * test if it returns the correct output when it contains walls diagonally.
	 */
	@Test
	public void testDiagonalWalls() {
		File input = new File("src/lab04/maze20in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 20.");
	}
	
	/*
	 * test if it returns the correct output when it contains walls diagonally.
	 */
	@Test
	public void testHorizontalWalls() {
		File input = new File("src/lab04/maze21in.txt");
		String output = "No Solution!";

		runTest(MazeSolver.class, input, output, "Incorrect result for sample input 21.");
	}
	
}
