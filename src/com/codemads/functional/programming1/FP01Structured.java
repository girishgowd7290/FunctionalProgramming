/**
 * 
 */
package com.codemads.functional.programming1;

import java.util.List;

/**
 * @author girishgowda
 *
 */
public class FP01Structured {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printAllDataInList(List.of(12,4,5,7,2,8,9));
		printEvenDataInList(List.of(12,4,5,7,2,8,9));
	}

	/**
	 * 
	 * @param of
	 */
	private static void printAllDataInList(List<Integer> numbers) {
		// How to loop
		
		for(Integer num : numbers) {
			System.out.println("Number :" + num);
		}
	}
	
	private static void printEvenDataInList(List<Integer> numbers) {
		// How to loop
		
		for(Integer num : numbers) {
			if(num%2==0) {
				System.out.println("Even Number :" + num);
			}
			
		}
	}

}
