/**
 * 
 */
package com.codemads.functional.programming2;

import java.util.List;

/**
 * @author girishgowda
 *
 */
public class FP02Fucntional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,4,5,7,2,8,9);
		
		System.out.println("Sum of lit elements :"+  addlistElements(numbers));

		System.out.println("Sum of lit elements with lambda :"+  addlistElementsWithLambda(numbers));
		
		System.out.println("Sum of lit elements with INteger :"+  addlistElementsWithInteger(numbers));
	}

	//with lambda
	private static int addlistElementsWithLambda(List<Integer> numbers) {
		return numbers.stream()
		.reduce(0, (x,y) -> x+y);
	}
	
	//with Integer
		private static int addlistElementsWithInteger(List<Integer> numbers) {
			return numbers.stream()
			.reduce(0, Integer :: sum);
		}
		
		
	private static int addlistElements(List<Integer> numbers) {
		return numbers.stream()
		.reduce(0,FP02Fucntional::addition);
	}

	private static int addition(int a, int b) {
		return a+b;
	}
}
