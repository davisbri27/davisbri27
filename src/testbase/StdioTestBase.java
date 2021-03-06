package testbase;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.Method;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;

import static org.junit.Assert.*;

/**
 * Base class for simplifying testing of programs that read input from stdin and
 * write results to stdout.
 * 
 * @author Grant Braught
 * @author Dickinson College
 * @version December 16, 2015
 */
public class StdioTestBase {

	private ByteArrayOutputStream actualOutput;
	private ByteArrayInputStream input;

	private InputStream stdin;
	private PrintStream stdout;

	private String output;

	/*
	 * NOTE: JUnit ensures that all @Before and @After methods are invoked even
	 * if they are overridden in sub-classes. Thus, a sub-class of this one may
	 * define setUp as an @Before and tearDown as an @After. In that case the
	 * the @Before and @After methods here bracket those in the sub-class. I.e.
	 * this setUp is run, then the sub-class one, then at the end the sub-class
	 * tearDown is run and then this one.
	 * 
	 * It is not necessary to invoke super.setUp() or super.tearDown().
	 */

	@Before
	public void setUp() {
		output = null;
		stdout = System.out;
		stdin = System.in;
	}

	@After
	public void tearDown() {
		System.setOut(stdout);
		System.setIn(stdin);
	}

	private void setupOutputStream() {
		actualOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(actualOutput));
	}

	private void setupInputStream(String s) {
		input = new ByteArrayInputStream(s.getBytes());
		System.setIn(input);
	}

	private String getDataFromFile(File f) {
		try (Scanner scr = new Scanner(new FileInputStream(f))) {
			scr.useDelimiter("");
			StringBuffer s = new StringBuffer();
			while (scr.hasNext()) {
				s = s.append(scr.next());
			}
			return s.toString();
		} catch (IOException e) {
			fail("Unable to read the file " + f.getAbsolutePath() + ".");
			return null; // Silly compiler!
		}
	}

	private String getData(Object src) {
		if (src instanceof File) {
			return getDataFromFile((File) src);
		} else {
			return src.toString();
		}
	}
	
	private String stripCR(String s) {
		return s.replaceAll("\r\n", "\n");				
	}

	/**
	 * Run a test. When a test is run:
	 * <UL>
	 * <LI>The main method of theClass will be invoked.
	 * <LI>The specified input will be made available via standard input
	 * (System.in). If input is a File Object then the contents of the file will
	 * become the input. If input is any other type of Object then the results
	 * of invoking toString on the object becomes the input.
	 * <LI>The output sent to standard output (System.out) by the program will
	 * be compared to expOutput using the assertEquals method. If expOutput is a
	 * File Object then the contents of the file will become the expected
	 * output. If expOutput is any other type of Object then the results of
	 * invoking toString on the object becomes the expected output. Leading and
	 * trailing whitespace are ignored in the comparison. If the comparison
	 * fails the provided message will be returned with the JUnit test failure
	 * information.
	 * </UL>
	 * 
	 * @param theClass
	 *            the class containing the main method to be invoked.
	 * @param input
	 *            the input to provide via standard input.
	 * @param expOutput
	 *            the output that is expected to be generated.
	 * @param message
	 *            the failure message to include if the test does not pass.
	 */
	protected void runTest(Class<?> theClass, Object input, Object expOutput,
			String message) {
		runTest(theClass, input, expOutput, message, true);
	}

	/**
	 * Run a test.
	 * 
	 * @See this{@link #runTest(Class, Object, Object, String)}
	 * 
	 * @param trim
	 *            true to ignore leading and trailing whitespace in the
	 *            comparison of actual output with expected output. False to
	 *            include leading and trailing whitespace in the comparison.
	 */
	protected void runTest(Class<?> theClass, Object input, Object expOutput,
			String message, boolean trim) {

		String expOut = stripCR(getData(expOutput));
		String actOut = stripCR(runMain(theClass, input));
		
		if (trim) {
			assertEquals(message, expOut.trim(), actOut.trim());
		} else {
			assertEquals(message, expOut, actOut);
		}
	}
	
	/**
	 * Run the main method in the specified class and return the output generated. 
	 * If input is a File object then the contents of the file will be made available
	 * to the program via standard input (System.in). Otherwise the result of invoking
	 * toString on input is made available to the program via standard input.
	 * 
	 * @param theClass the class containing the main method to be run.
	 * @param input the input to be made available to the program via standard input.
	 * @return the output generated by calling the main method.
	 */
	protected String runMain(Class<?> theClass, Object input) {
		String testIn = stripCR(getData(input));

		setupInputStream(testIn);
		setupOutputStream();

		try {
			Method m = theClass.getDeclaredMethod("main", String[].class);
			m.invoke(null, (Object) null);
			output = actualOutput.toString();
			return output;
		} catch (Exception e) {
			e.printStackTrace();
			fail("Error executing main in class " + theClass.getCanonicalName()
					+ ".");
			return null; // Silly compiler!
		}
	}

	/**
	 * Get the output generated by the most recently run test.
	 * 
	 * @return the output generated by the most recently run test.
	 */
	protected String getLastOutput() {
		return output;
	}
}
