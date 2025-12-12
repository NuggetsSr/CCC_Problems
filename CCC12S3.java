package dmoj;

/*
 * Author: Eric Cai
 * Date: Dec 11th 2025
 * Problem: CCC '12 S3 - Absolutely Acidic
 * Description: Determining the difference between the most and 2nd most repeated value in a list
 */

import java.util.*;

public class CCC12S3 {
	
	public static int[] countReps() {
		Scanner sc = new Scanner(System.in);
		int[] valCount = new int[1001];
		int n = sc.nextInt();
		for(int i = 0; i < n; i++) {
			int value = sc.nextInt();
			valCount[value] ++;
		}
		return valCount;
	}
	
	public static int findMax(int[] sensorCount) {
		
		int largestIndex = 0;
		
		int largestCount = 0;
		
		for(int i = 0; i < 1001; i++) {
			if(sensorCount[i] >= largestCount) {
				largestCount = sensorCount[i];
				if(i > largestIndex){
//					System.out.println("found new largest: " + largestCount);
					largestIndex = i;
				}
				
			}
		}
		
		return largestIndex;
	}
	
	public static int findMin(int[] sensorCount, int maxNum) {
		int smallestIndex = 1002;
		int largestCount = 0;
		
		for(int i = 0; i < 1001; i++) {
			if(sensorCount[i] > largestCount && i != maxNum) {
				largestCount = sensorCount[i];
				if(i > smallestIndex ){
//					System.out.println("found new largest 2nd: " + i);
					smallestIndex = i;
				}
			}
			else if (sensorCount[i] == largestCount) {
				if(i < smallestIndex) {
					smallestIndex = i;
				}
			}
		}
		
		return smallestIndex;
	}
	
	public static void main(String args[]) {
		int[] c = countReps();
//		for(int i = 0; i < 1001; i++) {
//			if(c[i] > 0) {
//				System.out.println(i + " " + c[i]);
//			}
//		}
		System.out.println(findMax(c)-findMin(c, findMax(c)));
//		System.out.println(findMin(c, findMax(c)));
	}
	
}
