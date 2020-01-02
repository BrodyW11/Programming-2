import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;

class SPTTest {

	SPT spt;
	
	
	void setUp() {
		spt = new SPT();
		}
	
	@Test
	public void testNullPointer() {
		int [][] graph = null;
		
		try {
			SPT.findSPT(graph, 0);
			fail("NullPointerException not thrown");
		} catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException | NullPointerException e) {
			}
	}
	
	 @Test
	public void testOutput() {
		try {
		
			int[][] graph = new int[][] {
		
		
			
		{-1, 5, 2},
		{4, -1, 4},
		{7, 1, -1},
	};
	int[] expected = new int[] {-1,2,0};
	int[] array = SPT.findSPT(graph, 0);
	assertArrayEquals(expected, array, "check correct output");
		} 
		catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
	  	}
	  	
	}
	
	
	
	
	@Test
	public void testInvalidSource(){
		int[][] graph = new int[][] {
			{-1, 5, 2},
			{4, -1, 4},
			{7, 1, -1},
		};
		
		try {
			SPT.findSPT(graph, -1);
			fail("InvalidSourceException not thrown");
		} catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			try {
				SPT.findSPT(graph, 7);
				fail("InvalidSourceException not thrown");
			} catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException ef) {
				if (!(e instanceof InvalidSourceException == true && ef instanceof InvalidSourceException == true)) {
						fail("InvalidSourceException not thrown");
						}
				}
			}
			
		}
		
	@Test
	public void testLoopDetected() {
		int [][] graph = new int[][] {
			{1, 5, 2},
			{4, -1, 4},
			{7, 1, -1},
		};
		
		try { 
			 SPT.findSPT(graph, 0);
			 fail("LoopDetectedException not thrown");
		} catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
			if (!(e instanceof LoopDetectedException == true)) {
				fail("LoopDetectedException not thrown");
			}
		}
	
	}
	
	@Test
	public void testInvalidGraph() {
		int[][] graph = new int[][] {
			{1, 5},
			{4, -1},
			{7, 1, -1},
			};
	
		try {
			SPT.findSPT(graph, 0);
			fail("InvalidGraphException not thrown");
			}
			catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
				if(!(e instanceof InvalidGraphException == true)) {
					fail("LoopDetectedException not thrown");
				}
			}
	}
	
	@Test
	public void testNoPath() {
		int[][] graph = new int[][] {
			{-1, -1, -1},
			{4, -1, 4},
			{7, 1, -1},
		};
		
		try {
			SPT.findSPT(graph, 0);
			fail("NoPathException not thrown");
			}
		    catch (InvalidSourceException | InvalidGraphException | LoopDetectedException | NoPathException e) {
		    	if(!(e instanceof NoPathException == true)) {
		    		fail("LoopDetectedException not thrown");
		    	}
		    }
		}
}
