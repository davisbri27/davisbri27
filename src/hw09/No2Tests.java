package hw09;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class No2Tests {

	protected CS232Graph<String, Integer> graph;

	@Before
	public void setUp() {
		graph = new CS232DirectedAdjacencyMatrixGraph<String, Integer>(10);
	}
	
	@Test
	public void testGetNeighborsNone() {
		graph.addEdge(2, 3, 1000);
		graph.addEdge(5, 3, 1001);
		graph.addEdge(7, 3, 1002);
		graph.addEdge(9, 3, 1003);
		
		ArrayList<Integer> neighbors = graph.getNeighbors(3);
		assertEquals("Incorrect number of neighbors", 0, neighbors.size());
		
		ArrayList<Integer> neighbors2 = graph.getNeighbors(6);
		assertEquals("Incorrect number of neighbors", 0, neighbors2.size());
	}

	@Test
	public void testGetNeighbors() {
		graph.addEdge(3, 1, 1000);
		graph.addEdge(3, 4, 1001);
		graph.addEdge(3, 5, 1002);
		graph.addEdge(3, 7, 1003);
		
		graph.addEdge(2, 3, 2000);
		graph.addEdge(2, 5, 2001);
		graph.addEdge(2, 7,	2002);
		
		graph.addEdge(6, 3, 3001);
		graph.addEdge(6, 1, 3001);
		
		graph.addEdge(9, 3, 4000);
		graph.addEdge(4, 5, 5000);
		graph.addEdge(7, 8, 6000);

		ArrayList<Integer> neighbors = graph.getNeighbors(3);
		assertEquals("Incorrect number of neighbors", 4, neighbors.size());
		assertTrue("Missing a neighbor", neighbors.contains(1));
		assertTrue("Missing a neighbor", neighbors.contains(4));
		assertTrue("Missing a neighbor", neighbors.contains(5));
		assertTrue("Missing a neighbor", neighbors.contains(7));
		
		ArrayList<Integer> neighbors2 = graph.getNeighbors(2);
		assertEquals("Incorrect number of neighbors", 3, neighbors2.size());
		assertTrue("Missing a neighbor", neighbors2.contains(3));
		assertTrue("Missing a neighbor", neighbors2.contains(5));
		assertTrue("Missing a neighbor", neighbors2.contains(7));

		ArrayList<Integer> neighbors3 = graph.getNeighbors(6);
		assertEquals("Incorrect number of neighbors", 2, neighbors3.size());
		assertTrue("Missing a neighbor", neighbors3.contains(3));
		assertTrue("Missing a neighbor", neighbors3.contains(1));
	
		ArrayList<Integer> neighbors4 = graph.getNeighbors(9);
		assertEquals("Incorrect number of neighbors", 1, neighbors4.size());
		assertTrue("Missing a neighbor", neighbors4.contains(3));
	}

	@Test
	public void testGetNeighborsBadVertex() {
		try {
			graph.getNeighbors(-1);
			fail("getNeighbors should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("getNeighbors should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.getNeighbors(10);
			fail("getNeighbors should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("getNeighbors should throw IllegalArgumentException with bad vertex");
		}
	}
}
