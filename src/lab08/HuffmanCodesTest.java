package lab08;

import static org.junit.Assert.assertEquals;

import java.util.PriorityQueue;

import org.junit.Before;
import org.junit.Test;

import testbase.StdioTestBase;

public class HuffmanCodesTest extends StdioTestBase {

	@Before
	public void setUp() {
		HuffmanCodes huffMan = new HuffmanCodes();
	}


	@Test
	public void testSampleInput1() {
		String input = "F\nAABBBCDDDDEE";
		String output = "A:2\nB:3\nC:1\nD:4\nE:2\n";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect result for sample input 1.");
	}

	@Test
	public void testSampleInput2() {
		String input = "T\nAABBBCDDDDEE";
		String output = "A:12\nB:7\nA:5\nD:4\nB:3\nA:3\nE:2\nA:2\nC:1";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect result for sample input 2.");
	}

	@Test
	public void testSampleInput3() {
		String input = "H\nAABBBCDDDDEE";
		String output = "A:100\nB:01\nC:101\nD:00\nE:11";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect result for sample input 3.");
	}

	@Test
	public void testSampleInput4() {
		String input = "M\nAABBBCDDDDEE";
		String output = "100100010101101000000001111";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect result for sample input 4.");
	}

	@Test
	public void testFrequencyTab(){
		String input = "F\nAA\tBBB\tCDDDDEE";
		String output = "\\t:2\nA:2\nB:3\nC:1\nD:4\nE:2";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of tabs in the output");
	}

	@Test
	public void testFrequencyNewLine(){
		String input = "F\n\nAA\nBBB\nCDDDDEE";
		String output = "\\n:3\nA:2\nB:3\nC:1\nD:4\nE:2";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of new lines in the output");
	}

	@Test
	public void testFrequencySpace(){
		String input = "F\nAA BBB CDD DD EE";
		String output = " :4\nA:2\nB:3\nC:1\nD:4\nE:2";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of spaces in the output");
	}

	@Test
	public void testTreeNodeTab() {
		String input = "T\nA\tAAAB";
		String output = "\\t:6\nA:4\n\\t:2\nB:1\n\\t:1";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of tabs in the treeNode");
	}

	@Test
	public void testTreeNodeTab2() {
		String input = "T\n\nA\tAB\tBBCDDDDEE";
		String output = "\\t:15\nA:8\n\\t:7\nD:4\nA:4\n\\t:4\nB:3\nE:2\nA:2\n\\n:2\n\\t:2\nC:1\n\\n:1";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of tabs in the output for treeNode");
	}

	@Test
	public void testTreeNodeNewLine(){
		String input = "T\n\nAA\nBBB\nCDDDDEE";
		String output = "\\n:15\n\\n:9\nA:6\n\\n:5\nD:4\nB:3\nA:3\n\\n:3\nE:2\nA:2\nC:1";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of new lines in the output for treeNode");
	}

	@Test
	public void testTreeNodeSpace(){
		String input = "T\nAA BBB CDD DD EE";
		String output = " :16\nA:9\n :7\nA:5\nD:4\n :4\nB:3\nA:3\nE:2\nA:2\nC:1";
		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of spaces in the output for treeNode");	
	}

	@Test
	public void testHuffmanCodeTab(){
		String input = "H\n\tAAA\tB";
		String output = "\\t:10\nA:0\nB:11";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of tabs in the huffmanCode output");
	}

	@Test
	public void testHuffmanCodeNewLine(){
		String input = "H\n\nA\nBBB\nE";
		String output = "\\n:00\nA:011\nB:1\nE:010";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of new lines in the huffmanCode output");
	}

	@Test
	public void testHuffmanCodeSpace(){
		String input = "H\nAA BBB C";
		String output = " :000\nA:01\nB:1\nC:001";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of spaces in the huffmanCode output");
	}

	@Test
	public void testHuffmanTextTab(){
		String input = "M\n\tAAA\tB";
		String output = "100001011";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of tabs in the huffmanCode output");
	}

	@Test
	public void testHuffmanTextNewLine(){
		String input = "M\n\nA\nBBB\nE";
		String output = "000110011100010";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of new lines in the huffmanCode output");
	}

	@Test
	public void testHuffmanTextSpace(){
		String input = "M\nAA BBB C";
		String output = "0101000111000001";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect number of spaces in the huffmanCode output");
	}

	@Test
	public void testTTreeOnlyRoot(){
		String input = "T\nAAA";
		String output = "A:3";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect in the treeNode output when there is only one root");
	}

	@Test
	public void testTreeNodeAllKeyEqual(){
		String input = "T\nABCDDCBA";
		String output = "A:8\nC:4\nA:4\nD:2\nC:2\nB:2\nA:2";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect in the treeNode same key output");

	}
	
	@Test
	public void testHuffmanCodeAllKeyEqual(){
		String input = "H\nABCDDCBA";
		String output = "A:11\nB:10\nC:01\nD:00";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect in the HuffmanCode same key output");
	}
	
	@Test
	public void testHuffmanTextKeyEqual(){
		String input = "M\nABCDDCBA";
		String output = "1110010000011011";

		runTest(HuffmanCodes.class, input, output,
				"Incorrect in the HuffmanText same key output");
	}

	@Test
	public void testHuffmanCodeOneInput(){
		String input = "M\nm";
		String output = "";
		
		runTest(HuffmanCodes.class, input, output,
				"Incorrect output in the HuffmanText one input test");
	}


}

