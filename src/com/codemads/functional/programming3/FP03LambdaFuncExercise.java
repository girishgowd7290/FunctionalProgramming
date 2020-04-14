/**
 * 
 */
package com.codemads.functional.programming3;

import java.util.List;
import java.util.function.BinaryOperator;

/**
 * @author girishgowda
 *
 */
public class FP03LambdaFuncExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);
		
		
		BinaryOperator<Integer> accumulator = Integer::sum;
		
		int sum = numbers.stream()
				.reduce(0, accumulator);
		System.out.println("Sum of List elements with Integer static func Sum :: " + sum);
		

		
		
		BinaryOperator<Integer> accumulator2 = new BinaryOperator<Integer> () {
			@Override
			public Integer apply(Integer initial, Integer listElement) {
				return initial += listElement;
			}
			
		};
		
		int sum2 = numbers.stream()
				.reduce(0, accumulator2);
		
		System.out.println("Sum of List elements with Binary Operator:: " + sum2);
		
	}

}
