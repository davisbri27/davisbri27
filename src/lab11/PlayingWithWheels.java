package lab11;
/**
 * In this problem we will be considering a game played with four wheels. Digits ranging from 0 to 9 are
 *  printed consecutively (clockwise) on the periphery of each wheel. The topmost digits of the wheels form 
 *  a four-digit integer. For example, in the following figure the wheels form the integer 8056. Each wheel 
 *  has two buttons associated with it. Pressing the button marked with a left arrow rotates the wheel one 
 *  digit in the clockwise direction and pressing the one marked with the right arrow rotates it by one digit 
 *  in the opposite direction. Each wheel operates independently of the others (i.e. if the first goes from 9 
 *  back around to 0, the second wheel is not affected.) 
 *  
 *  The game starts with an initial configuration of the wheels. Say, in the initial configuration the topmost digits 
 *  form the integer S1S2S3S4. You will be given some (say, n) forbidden configurations Fi1Fi2Fi3Fi4 (1<=i<=n) and a 
 *  target configuration T1T2T3T4. Your job will be to write a program that can calculate the minimum number of button 
 *  presses required to transform the initial configuration to the target configuration by never passing through a forbidden one. 
 * 
 * @author Briona & Tommy
 * @version 21st March, 2017
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PlayingWithWheels {
	private static CS232DirectedAdjacencyMatrixGraph<?, Integer> numGraph;
	private static ArrayList<Integer> forbidden;
	private static int startNum;
	private static int endNum;
	private static boolean possible;

	/**
	 * Constructs private variables and takes user input
	 * creates the graph, a variable for the startNum endNum and an ArrayList of forbidden vertices
	 * @param scr 
	 */
	public PlayingWithWheels(Scanner scr){
		numGraph = new CS232DirectedAdjacencyMatrixGraph(10000);
		startNum = Integer.parseInt(scr.next());
		endNum = Integer.parseInt(scr.next());
		forbidden = new ArrayList<Integer>();
		while(scr.hasNext()){
			forbidden.add(Integer.parseInt(scr.next()));
		}
		if(forbidden.contains(endNum)){
			possible = false;
		}else if(startNum == endNum){

		}
		else{
			possible = true;
		}
	}
	/**
	 * uses the object numGraph and adds all possibilities of vertices
	 */
	public void genGraph(){
		for(int i = 0000; i <= 9999; i++){
			//			System.err.println(i);
			numGraph.addEdge(i, changeDigit(i,1000, false), 1);
			numGraph.addEdge(i, changeDigit(i,1000, true), 1);
			numGraph.addEdge(i, changeDigit(i,100, false), 1);
			numGraph.addEdge(i, changeDigit(i,100, true), 1);
			numGraph.addEdge(i, changeDigit(i,10, false), 1);
			numGraph.addEdge(i, changeDigit(i,10, true), 1);
			numGraph.addEdge(i, changeDigit(i,1, false), 1);
			numGraph.addEdge(i, changeDigit(i,1, true), 1);
		}
		for(int i = 0; i < forbidden.size(); i++){
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),1000, false));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),1000, true));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),100, false));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),100, true));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),10, false));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),10, true));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),1, false));
			numGraph.removeEdge(forbidden.get(i),changeDigit(forbidden.get(i),1, true));
		}
	}
	/**
	 * searches the object numGraph for a vertex v2 while adding a depth to each vertex.
	 * 
	 * @param v1 the staring vertex of the search
	 * @param v2 the vertex to be found
	 * @return the depth/distance between the start vertex v1 and end vertex v2
	 */
	public int bfs(int v1, int v2){
		for(int v =0; v < numGraph.numVertices();v++){
			numGraph.setVertexMark(v, CS232Graph.UNVISITED);
		}


		Queue<Integer> verts = new LinkedList<Integer>();
		verts.add(v1);
		numGraph.setVertexMark(v1, 1);
		while(!verts.isEmpty()){
			int curV = verts.poll();


			ArrayList<Integer> neighbors = numGraph.getNeighbors(curV);
			for(int i=0; i < neighbors.size();i++){
				if(numGraph.getVertexMark(neighbors.get(i)) == CS232Graph.UNVISITED){
					numGraph.setVertexMark(neighbors.get(i), numGraph.getVertexMark(curV) + 1);
					if(neighbors.get(i) == v2){
						return numGraph.getVertexMark(neighbors.get(i)) - 1;
					}
					verts.add(neighbors.get(i));
				}
			}
		}
		return -1;
	}

	/**
	 * changes a digit in the four digit number. Since the digits range from 0-9 the 
	 * method checks for increasing from 9 or decreasing from 0
	 * @param i the int value to be changed
	 * @param digit the requested digit place
	 * @param forward a boolean that if true the i will increase if false the i will decrease
	 * @return the changed i value according to the digit and forward values
	 */
	public int changeDigit(int i, int digit, boolean forward){
		int d = (i % (digit*10))/digit;

		if(forward){//increases i
			if(d == 9){//i needs to have a 0 value
				return i - (9*digit);
			}else{
				return i + digit;
			}
		}else{
			if(d == 0){//i needs to have a 9 value
				return i + (9 * digit);
			}else{
				return i - digit;
			}
		} 
	}

	public static void main(String[] args) {
		Scanner scr = new Scanner(System.in);
		PlayingWithWheels pww = new PlayingWithWheels(scr);
		pww.genGraph();
		
		if(startNum == endNum && possible){//the start and numbers are the same
			System.out.println(0);
		}else if(!possible){//either start or end values are forbidden
			System.out.print(-1);
		}
		else if(possible){//start and end values are not forbidden
			System.out.print(pww.bfs(startNum, endNum));
		}

	}

}
