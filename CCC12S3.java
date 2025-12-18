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
	
	// finds the max and min of the most frequent in int[] count
	public static int[] mostFreq(int[] count, int freq) { 
		int maxFreq = 1;
		int maxVal = 1; // largest value of the most frequent
		int minVal = Integer.MAX_VALUE; // min value of the most frequent
		for(int i = 0; i < 1001; i++) {
			if(count[i] < freq) {
				if(count[i] > maxFreq) {
					maxFreq = count[i];
					maxVal = i;
					minVal = i;
				}
				else if(count[i] == maxFreq) {
					maxVal = Math.max(maxVal, i);
					minVal = Math.min(minVal, i);
				}
			}
		}
		int[] output = {maxVal, minVal, maxFreq};
		return output;
	}
	
	public static void main(String args[]) {
		int[] c = countReps();
		int[] most = mostFreq(c, Integer.MAX_VALUE);
		int[] secondMost = mostFreq(c, most[2]);
		
		System.out.println(most[0] + " " + most[1]);
 		System.out.println(secondMost[0] + " " + secondMost[1]);
 		
 		if(most[0] == most[1]) { // most frequent max and min are same value, means only 1 most frequent value
 			System.out.println(Math.max(Math.abs(most[0]-secondMost[0]), Math.abs(most[0] - secondMost[1])));
 		}
 		else {
 			System.out.println(most[0] - most[1]);
 		}
 		
	}
	
}
