package dmoj;

/*
 * Author: Eric Cai
 * Date: Dec 11th 2025
 * Problem: CCC '12 S3 - Absolutely Acidic
 * Description: Determining the difference between the most and 2nd most repeated value in a list
 */

import java.util.*;

public class CCC12S3 {
	
	/*
	 * Stores the inputed sensor value and frequency into an integer array.
	 * @return an integer array with the index of the array denoting the sensor value, and the element denoting the frequency of that value
	 */
	
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
	
	/*
	 * Finds the max and min of the most frequent in int[] count, with respect to the frequency of the values
	 * @param count  An integer array that contains the sensor values and frequencies
	 * @param freq  An integer denoting the largest frequency the method will check
	 * @return an integer array of 3 values: the maximum value of the most frequent, the minimum value of the most frequent, and the largest frequency found
	 */
	
	public static int[] mostFreq(int[] count, int freq) { 
		int maxFreq = 1;
		int maxVal = 1; // largest value of the most frequent
		int minVal = Integer.MAX_VALUE; // min value of the most frequent
		for(int i = 0; i < 1001; i++) {
			if(count[i] < freq) {
				if(count[i] > maxFreq) { // update maxVal and minVal regardless of their current state if a higher frequency is discovered
					maxFreq = count[i];
					maxVal = i;
					minVal = i;
				}
				else if(count[i] == maxFreq) { // usage of Math.max and Math.min to compare current value and new value
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
		
//		System.out.println(most[0] + " " + most[1]);
// 		System.out.println(secondMost[0] + " " + secondMost[1]);
 		
 		if(most[0] == most[1]) { // most frequent max and min are same value, means only 1 most frequent value
 			System.out.println(Math.max(Math.abs(most[0]-secondMost[0]), Math.abs(most[0] - secondMost[1])));
 			// find max absolute difference of most frequent minus the 2nd most frequent
 		} 
 		else {
 			System.out.println(most[0] - most[1]);
 		}
 		
	}
	
}
