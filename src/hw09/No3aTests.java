package hw09;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class No3aTests {

	protected CS232Graph<String, Integer> graph;
	
	@Before
	public void setUp() {
		graph = new CS232DirectedAdjacencyListGraph<String, Integer>(10);
	}

	@Test
	public void testAddNewEdgeAndGetEdge() {
		// add all possible edges,
		// check each one as we go
		// and then again at the end.

		int edgeCount = 0;
		for (int v1 = 0; v1 <= 9; v1++) {
			for (int v2 = 0; v2 <= 9; v2++) {
				if (v1 != v2) {
					edgeCount++;
					graph.addEdge(v1, v2, edgeCount);

					assertEquals("Incorrect number of vertices", 10,
							graph.numVertices());
					assertEquals("Number of edges not correct", edgeCount,
							graph.numEdges());
					assertEquals("getEdge gave back wrong edge",
							(Integer) edgeCount, graph.getEdge(v1, v2));
				}
			}
		}

		assertEquals("Number of edges not correct", (10 * 9), graph.numEdges());

		edgeCount = 0;
		for (int v1 = 0; v1 <= 9; v1++) {
			for (int v2 = 0; v2 <= 9; v2++) {
				if (v1 == v2) {
					assertNull("Graph should not have self-edges",
							graph.getEdge(v1, v2));
				} else {
					edgeCount++;

					assertEquals("getEdge gave back wrong edge",
							(Integer) edgeCount, graph.getEdge(v1, v2));
				}
			}
		}
	}

	@Test
	public void testAddedEdgesAreDirected() {
		graph.addEdge(3, 7, 1000);
		assertNull("Edges seem not to be directed", graph.getEdge(7, 3));
	}

	@Test
	public void testAddEdgeReplacesExistingEdge() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(7, 3, 1001);

		graph.addEdge(3, 7, 2000);

		assertEquals("setEdge did not replace existing edge", (Integer) 2000,
				graph.getEdge(3, 7));
		assertEquals("setEdge replaced incorrect edge", (Integer) 1001,
				graph.getEdge(7, 3));

		assertEquals("Incorrect number of vertices", 10, graph.numVertices());
		assertEquals("Incorrect number of edges", 2, graph.numEdges());
	}

	@Test
	public void testAddEdgeWithBadVertex() {
		try {
			graph.addEdge(-1, 0, 1000);
			fail("addEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("addEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.addEdge(0, -1, 1000);
			fail("addEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("addEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.addEdge(10, 0, 1000);
			fail("addEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("addEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.addEdge(0, 10, 1000);
			fail("addEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("addEdge should throw IllegalArgumentException with bad vertex");
		}
	}

	@Test
	public void testAddEdgeWithNullValue() {
		try {
			graph.addEdge(0, 10, null);
			fail("addEdge should throw exception with null value");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("addEdge should throw IllegalArgumentException with null value");
		}
	}
}
