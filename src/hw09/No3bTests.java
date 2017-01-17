package hw09;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

public class No3bTests extends No3aTests {

	protected static Random rnd = new Random();
	
	@Test
	public void testRemoveExistingEdge() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(7, 3, 1001);
		
		graph.removeEdge(3, 7);
		assertEquals("Incorrect number of vertices", 10, graph.numVertices());
		assertEquals("Incorrect number of edges", 1, graph.numEdges());
		assertNull("Incorrect edge was removed", graph.getEdge(3,7));
	}

	@Test
	public void testRemoveNonExistentEdge() {
		graph.addEdge(3, 7, 1000);
		graph.addEdge(7, 3, 1001);
		
		graph.removeEdge(2, 8);
		assertEquals("Incorrect number of vertices", 10, graph.numVertices());
		assertEquals("Incorrect number of edges", 2, graph.numEdges());
		assertNotNull("Incorrect edge removed", graph.getEdge(3,7));
		assertNotNull("Incorrect edge removed", graph.getEdge(7,3));
	}

	@Test
	public void testRandomAddRemoves() {
		boolean[][] ref = new boolean[10][10];
		for (int e = 0; e < 100000; e++) {
			int v1 = rnd.nextInt(10);
			int v2 = v1;
			while (v1 == v2) {
				v2 = rnd.nextInt(10);
			}

			if (rnd.nextBoolean()) {
				graph.addEdge(v1, v2, e);
				ref[v1][v2] = true;
			} else {
				graph.removeEdge(v1, v2);
				ref[v1][v2] = false;
			}

			for (int v1i = 0; v1i < ref.length; v1i++) {
				for (int v2i = 0; v2i < ref.length; v2i++) {
					if (ref[v1i][v2i]) {
						assertNotNull("Missing edge that should be present.",
								graph.getEdge(v1i, v2i));
					} else {
						assertNull("Edge exists that should not be present",
								graph.getEdge(v1i, v2i));
					}
				}
			}

		}
	}
	
	@Test
	public void testRemoveEdgeWihtBadVertex() {
		try {
			graph.removeEdge(-1, 0);
			fail("removeEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("removeEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.removeEdge(0, -1);
			fail("removeEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("removeEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.removeEdge(10, 0);
			fail("removeEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("removeEdge should throw IllegalArgumentException with bad vertex");
		}

		try {
			graph.removeEdge(0, 10);
			fail("removeEdge should throw exception with bad vertex");
		} catch (IllegalArgumentException e) {
			// pass
		} catch (Exception e) {
			fail("removeEdge should throw IllegalArgumentException with bad vertex");
		}
	}
}
