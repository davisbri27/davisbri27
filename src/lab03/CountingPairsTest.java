package lab03;

import java.io.*;
import org.junit.Test;

import testbase.StdioTestBase;

public class CountingPairsTest extends StdioTestBase {

	@Test
	public void testSample1() {
		// Input from a string in the test.
		String input = "5 2\n1 5 3 4 2";
		Integer output = 3;
		runTest(CountingPairs.class, input, output, "Incorrect result for sample input 1.");
	}

	@Test
	public void testSample2() {
		// Input from a text file in the package.
		File input = new File("src/lab03/input2.txt");
		Integer output = 0;
		runTest(CountingPairs.class, input, output, "Incorrect result for sample input 2.");
	}

	/*
	 * test if it returns the correct output when N = 2 and K = 0.
	 */
	@Test
	public void testSameTwoNumsWithDifference0() {
		File input = new File("src/lab03/input3.txt");
		Integer output = 1;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 3.");
	}

	/*
	 * test if it returns the correct output when K = 0 with the same multiple
	 * elements.
	 */
	@Test
	public void testSameMultipleNumsWithDifference0() {
		File input = new File("src/lab03/input4.txt");
		Integer output = 45;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 4.");
	}

	/*
	 * test if it returns the correct output when it contains no elements on the
	 * second line.
	 */
	@Test
	public void testNequals0() {
		File input = new File("src/lab03/input5.txt");
		Integer output = 0;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 5.");
	}

	/*
	 * test if it returns the correct output when it contains maximum number of
	 * integers in the second line.
	 */
	@Test
	public void testNequalsMax() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input6.txt", false));
			pw.println("5000 1");
			for (int i = 0; i < 2500; i++) {
				pw.print("4 ");
			}
			for (int i = 2500; i < 5000; i++) {
				pw.print("5 ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input6.txt");
		Integer output = 2500 * 2500;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 6.");
	}

	/*
	 * test if it returns the correct output when it contains maximum number of
	 * integers in the second line and the difference equals 0.
	 */
	@Test
	public void testNequalsMaxWithKequalTo0() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input7.txt", false));
			pw.println("5000 0");
			for (int i = 0; i < 5000; i++) {
				pw.print("0 ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input7.txt");
		Integer output = 5000 * 4999 / 2;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 7.");
	}

	/*
	 * test if it returns the correct output when it contains large integers.
	 * Note that even though the value of each integer will be in the range
	 * [0...2500], this test will still pass because it's in the range of
	 * integer.
	 */
	@Test
	public void testLargeIntegers() {
		PrintWriter pw = null;
		int n = (int) (Math.random() * 10000000 + 2000000000);
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input8.txt", false));
			pw.println("3745 1");
			for (int i = 0; i < 3745; i++) {
				pw.print(n + " ");
				n++;
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input8.txt");
		Integer output = 3744;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 8.");
	}

	/*
	 * test if it returns the correct output when it contains few elements and K
	 * is max. The difference of the integers will not equal 0, which means that
	 * output should be 0.
	 */
	@Test
	public void testMaxKWithFewElementsOutputEquals0() {
		File input = new File("src/lab03/input9.txt");
		Integer output = 0;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 9.");
	}

	/*
	 * test if it returns the correct output when it contains few elements and K
	 * is max.
	 */
	@Test
	public void testMaxKWithFewElements() {
		File input = new File("src/lab03/input10.txt");
		Integer output = 2;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 10.");
	}

	/*
	 * test if it returns the correct output when it contains few 0s and 2500s
	 * and K equals 2500.
	 */
	@Test
	public void testMaxK() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input11.txt", false));
			pw.println("2340 2500");
			pw.print("0 0 1 0 2 3 0 0 0 1030 ");
			for (int i = 0; i < 2320; i++) {
				int n = (int) (Math.random() * 2400 + 1);
				pw.print(n + " ");
			}
			pw.print("302 1934 2500 2500 1293 2500 2030 440 2500 123 444");
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input11.txt");
		Integer output = 24;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 11.");
	}

	/*
	 * test if it returns the correct output when it contains all same numbers
	 * but k is not 0.
	 */
	@Test
	public void testAllSameNums() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input12.txt", false));
			pw.println("2300 1234");
			for (int i = 0; i < 2300; i++) {
				pw.print("3 ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input12.txt");
		Integer output = 0;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 12.");
	}

	/*
	 * test if it returns the correct output when the values of N and K are at
	 * the max and the values of each integer are made up of 0s and 2500s.
	 */
	@Test
	public void testMaxForBothNandK() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileOutputStream("src/lab03/input13.txt", false));
			pw.println("5000 2500");
			for (int i = 0; i < 2500; i++) {
				pw.print("0 ");
			}
			for (int i = 2500; i < 5000; i++) {
				pw.print("2500 ");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Unable to open file");
		} finally {
			pw.close();
		}

		File input = new File("src/lab03/input13.txt");
		Integer output = 2500 * 2500;
		runTest(CountingPairs.class, input, output, "Incorrect result for input 13.");
	}

}
