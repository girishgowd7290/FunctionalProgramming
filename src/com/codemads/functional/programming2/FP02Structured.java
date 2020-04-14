/**
 * 
 */
package com.codemads.functional.programming2;

import java.util.List;

/**
 * @author girishgowda
 *
 */
public class FP02Structured {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers = List.of(12,4,5,7,2,8,9);
		
		System.out.println("Sum of List elements  :: "+ addListElements(numbers));
	}

	private static int addListElements(List<Integer> numbers) {
		int sum = 0; 
		
		for(int num : numbers) {
			sum += num;
		}
		
		return sum;
	}


}
