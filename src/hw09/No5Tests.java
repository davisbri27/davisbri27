package hw09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class No5Tests {

	protected CS232Graph<String, Integer> graph;

	@Before
	public void setUp() {
		graph = new CS232UndirectedAdjacencyMatrixGraph<String, Integer>(10);
	}
	
	@Test
	public void testAddEdgeAddsBothDirections() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(2, 5, 3000);
		
		assertEquals("Incorrect number of edges", 2, graph.numEdges());
		assertEquals("Incorrect value for edge", (Integer)1000, graph.getEdge(3, 7));
		assertEquals("Incorrect value for edge", (Integer)1000, graph.getEdge(7, 3));
		
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(2, 5));
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(5, 2));
	}
	
	@Test
	public void testAddEdgeUpdatesBothDirections() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(2, 5, 3000);
		
		graph.addEdge(7, 3, 2000);

		assertEquals("Incorrect number of edges", 2, graph.numEdges());
		assertEquals("Incorrect value for edge", (Integer)2000, graph.getEdge(3, 7));
		assertEquals("Incorrect value for edge", (Integer)2000, graph.getEdge(7, 3));
		
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(2, 5));
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(5, 2));
	}
	
	@Test
	public void testRemoveRemovesBothDirections() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(7, 3, 2000);
		graph.addEdge(2, 5, 3000);
		
		graph.removeEdge(3, 7);
		
		assertEquals("Incorrect number of edges", 1, graph.numEdges());
		assertNull("Edge should not be present", graph.getEdge(3, 7));
		assertNull("Edge should not be present", graph.getEdge(7, 3));
		
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(2, 5));
		assertEquals("Incorrect value for edge", (Integer)3000, graph.getEdge(5, 2));
	}
}
