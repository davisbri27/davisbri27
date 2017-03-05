package lab04;

import java.util.*;

/**
 * Read in a textual description of a maze and either produces output that shows
 * the solution to the maze or indicates that the maze has no solution.
 * 
 * The first line of the input will contain 2 comma delimited integers that
 * indicate the number of rows and columns in the maze.
 * 
 * The remainder of the input contains one line for each row in the maze. The
 * line for each row contains one character for each column in the maze.
 * 
 * Each of these lines may contain only the following characters:
 * 
 * 'X' - a wall. 'S' - the starting point. 'E' - the ending point. ' ' - an
 * hallway.
 * 
 * @author Dickinson College
 * @author Briona Davis, Seongho Lee
 * @version Feb 21, 2017
 *
 */
public class MazeSolver {

	private char[][] maze; // contain the chars from the maze .txt file.
	private int rowLen, colLen; // length of row and column
	private int startRow, startCol; // row and column of 'S'

	/**
	 * The first line with integer values is read and stored into rowLen and
	 * colLen, respectively. The remainder of the input containing characters is
	 * read and stored in array.
	 */
	public void readFile() {
		Scanner scr = new Scanner(System.in);

		String firstLine = scr.nextLine();
		String[] seperateFirstLine = firstLine.split(",");

		rowLen = Integer.parseInt(seperateFirstLine[0]);
		colLen = Integer.parseInt(seperateFirstLine[1]);

		maze = new char[rowLen][colLen];
		// read off all elements in the file until it reaches the end.
		for (int r = 0; r < rowLen; r++) {
			String str = scr.nextLine();
			for (int c = 0; c < colLen; c++) {
				maze[r][c] = str.charAt(c);

				if (maze[r][c] == 'S') {
					startRow = r;
					startCol = c;
				}

			}
		}

		scr.close();
	}

	/**
	 * 
	 * 
	 * @param maze
	 *            2d array containing chars.
	 * @param curRow
	 *            int value of current row.
	 * @param curCol
	 *            int value of current column.
	 * @return true if current row and column of maze contains a hallway, else
	 *         return false.
	 */
	public boolean mazeSolver(char[][] maze, int curRow, int curCol) {

		if (curRow < 0 || curCol < 0 || curRow >= maze.length || curCol >= maze[0].length) {
			return false;
		} else if (maze[curRow][curCol] == 'X') {
			return false;
		} else if (maze[curRow][curCol] == '.') {
			return false;
		} else if (maze[curRow][curCol] == 'E') {
			return true;
		}
		
		// When you make a move, put in '.' for the path you just passed.
		if (maze[curRow][curCol] != 'S')
			maze[curRow][curCol] = '.';

		if (mazeSolver(maze, curRow + 1, curCol)) { // go down by 1
			return true;
		}
		if (mazeSolver(maze, curRow, curCol + 1)) { // go right by 1
			return true;
		}
		if (mazeSolver(maze, curRow - 1, curCol)) { // go up by 1
			return true;
		}
		if (mazeSolver(maze, curRow, curCol - 1)) { // go left by 1
			return true;
		}

		// If there are no more directions to move, replace '.' with ' '.
		if (maze[curRow][curCol] != 'S') {
			maze[curRow][curCol] = ' ';
		}
		return false;
	}

	/**
	 * Find a solution for a maze, which progresses directly from the start to
	 * the exit without ever entering a dead-end.
	 * 
	 * If the maze does not have a solution the output will be the single line:
	 * 
	 * No Solution!
	 * 
	 * If the maze does have a solution the output will display the maze exactly
	 * as in the input but with spaces (' ') replaced by periods ('.') to
	 * indicate the path taken. The output will not include the first line of
	 * the input indicating the number of rows and columns in the maze.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		MazeSolver ms = new MazeSolver();
		ms.readFile();
		if (ms.mazeSolver(ms.maze, ms.startRow, ms.startCol)) {
			for (int r = 0; r < ms.rowLen; r++) {
				for (int c = 0; c < ms.colLen; c++) {
					System.out.print(ms.maze[r][c]);
				}
				System.out.println();
			}
		} else {
			System.out.println("No Solution!");
		}
	}
}
