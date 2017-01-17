package hw09;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class No8Tests {

	protected CS232Graph<String, String> graph;

	@Before
	public void setUp() {
		graph = new CS232DirectedAdjacencyMatrixGraph<String, String>(10);
		graph.addEdge(1, 2, "1-2");
		graph.addEdge(1, 4, "1-4");
		graph.addEdge(2, 1, "2-1");
		graph.addEdge(2, 3, "2-3");
		graph.addEdge(2, 4, "2-4");
		graph.addEdge(3, 5, "3-5");
		graph.addEdge(4, 9, "4-9");
		graph.addEdge(5, 1, "5-1");
		graph.addEdge(5, 2, "5-2");
		graph.addEdge(6, 7, "6-7");
		graph.addEdge(6, 8, "6-8");
		graph.addEdge(7, 3, "7-3");
		graph.addEdge(7, 5, "7-5");
		graph.addEdge(8, 4, "8-4");
		graph.addEdge(8, 5, "8-5");
		graph.addEdge(8, 6, "8-6");
		graph.addEdge(8, 9, "8-9");

		graph.setVertexObject(0, "0");
		graph.setVertexObject(1, "1");
		graph.setVertexObject(2, "2");
		graph.setVertexObject(3, "3");
		graph.setVertexObject(4, "4");
		graph.setVertexObject(5, "5");
		graph.setVertexObject(6, "6");
		graph.setVertexObject(7, "7");
		graph.setVertexObject(8, "8");
		graph.setVertexObject(9, "9");
	}

	@Test
	public void testBFS() {
		PrintStream out = System.out;

		ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
		System.setOut(new PrintStream(actualOutput));
		
		CS232GraphAlgorithms.BFS(graph);
		
		String output = actualOutput.toString().trim();
		
		System.setOut(out);
		
		assertEquals("Incorrect BFS order.", "0\n1\n2\n4\n3\n9\n5\n6\n7\n8", output);
	}
}
