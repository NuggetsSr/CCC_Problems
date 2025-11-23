package dmoj;

import java.util.*;

public class CCC10J5 {
	public static void main(String[] args) {
		Queue<int[]> q = new LinkedList<>(); // a queue is used to store coordinates for BFS
		HashSet<int[]> history = new HashSet<int[]>(); // HashSet to keep track of what coords already visited
		int[][] movement = {{1,2},{-1,2},{1,-2},{-1,-2},{2,1},{2,-1},{-2,1},{-2,-1}}; 
		// 2d array of possible movements
		
		Scanner input = new Scanner(System.in);
		
		int startX = input.nextInt()-1;
		int startY = input.nextInt()-1;
		
		int endX = input.nextInt()-1;
		int endY = input.nextInt()-1;
		// -1 from input to change to 0-based indexing
		
		int numMoves = 0;
		
		int[] startCoords = {startX, startY, numMoves};
		q.add(startCoords);
		history.add(startCoords);
		// adding first location to the queue and history to start BFS
		
		while(!q.isEmpty()) {
			if(q.peek()[0] == endX && q.peek()[1] == endY) {
				System.out.println(q.peek()[2]);
				return;
				// each element of q is composed of {x, y, number of steps taken}
			}
			for(int i = 0; i < 8; i++) {
				int currentX = q.peek()[0] + movement[i][0];
				int currentY = q.peek()[1] + movement[i][1];
				int[] currentCoords = {currentX,currentY, q.peek()[2]+1};
				int[] c = {currentX,currentY};
				// c is needed to check previously visited location
				if(currentX >= 0 && currentX < 8 && currentY >= 0 && currentY < 8 && !history.contains(c)) {
					q.add(currentCoords);
					history.add(c);
				}
			}
			q.remove();
			//remove the beginning of the queue because it has already been read and it isn't the final location
		}
		
	}

}
