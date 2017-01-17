package hw09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class No4aTests {

	protected CS232DirectedAdjacencyMatrixGraph<String, Integer> graph;

	@Before
	public void setUp() {
		graph = new CS232DirectedAdjacencyMatrixGraph<String, Integer>(10);
		buildGraph();
	}
	
	protected void buildGraph() {
		graph.addEdge(2, 1, 1000);
		
		graph.addEdge(1, 9, 2000);
		graph.addEdge(3, 9, 2001);
		
		graph.addEdge(0, 8, 3000);
		graph.addEdge(1, 8, 3001);
		graph.addEdge(2, 8, 3002);
		
		graph.addEdge(0, 3, 4000);
		graph.addEdge(1, 3, 4001);
		graph.addEdge(2, 3, 4002);
		graph.addEdge(4, 3, 4003);
		
		graph.addEdge(5, 4, 5000);
		graph.addEdge(5, 7, 5001);
	}
	
	@Test
	public void testInDegreeNone() {
		assertEquals("Should be no incoming edges", 0, graph.inDegree(0));
		assertEquals("Should be no incoming edges", 0, graph.inDegree(5));
	}
	
	@Test
	public void testInDegreeSome() {
		assertEquals("Incorrect number of incoming edges", 1, graph.inDegree(1));
		assertEquals("Incorrect number of incoming edges", 2, graph.inDegree(9));
		assertEquals("Incorrect number of incoming edges", 3, graph.inDegree(8));
		assertEquals("Incorrect number of incoming edges", 4, graph.inDegree(3));
	}
}
