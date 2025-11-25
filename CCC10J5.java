package dmoj;

/*
 * Author: Eric Cai
 * Date: Nov 25 2025
 * Problem: CCC '10 J5 - Knight Hop
 * Description: BFS graph traversal using queue
 */

import java.util.*;

public class CCC10J5 {
	
	static Queue<int[]> q = new LinkedList<>(); // a queue is used to store coordinates for BFS
	static HashSet<int[]> visited = new HashSet<int[]>(); // HashSet to keep track of what coords already visited
	static int[][] movement = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}}; 
	// 2d array of possible movements
	
	/*
	 * Returns an integer value of the shortest amount of moves to move from a initial position to a designated end position.
	 * @param sX an integer denoting the X value of the start position
	 * @param sY an integer denoting the Y value of the start position
	 * @param eX an integer denoting the X value of the end position
	 * @param eY an integer denoting the Y value of the end position
	 * @return   an integer denoting the shortest amount of moves for the piece to arrive at the end position
	 */
	
	public static int bfs(int sX, int sY, int eX, int eY) {
		int numMoves = 0;
		int[] startCoords = {sX, sY, numMoves};
		q.add(startCoords);
		// adding first location to the queue and history to start BFS
		visited.add(new int[] {sX,sY}); //visited does not store # of moves so program does not get stuck in infinite loop
		// if visited stores # of moves, then a situation might occur where the algorithm paths to a previously visited position but with a different numMoves.
		while(!q.isEmpty()) {
			
			int[] currPos = q.poll(); // deletes and pulls the front of the queue
			int currX = currPos[0];
			int currY = currPos[1];
			int currMoves = currPos[2];
			
			if(currX == eX && currY == eY) {
				return currMoves;
			}
			for(int i = 0; i < 8; i++) {
				int newX = currX + movement[i][0];
				int newY = currY + movement[i][1];
				int[] currentCoords = {newX, newY, currMoves+1};
				int[] c = {newX,newY};
				// c is needed to check previously visited location, as visited does not include numMoves
				if(newX >= 0 && newX < 8 && newY >= 0 && newY < 8 && !visited.contains(c)) {
					q.add(currentCoords);
					visited.add(c);
				}
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		int startX = input.nextInt()-1;
		int startY = input.nextInt()-1;
		
		int endX = input.nextInt()-1;
		int endY = input.nextInt()-1;
		// -1 from input to change to 0-based indexing
		
	
		
		System.out.println(bfs(startX,startY,endX,endY));
		
	}

}
