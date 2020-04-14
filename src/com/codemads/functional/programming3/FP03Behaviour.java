/**
 * 
 */
package com.codemads.functional.programming3;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author girishgowda
 *
 */
public class FP03Behaviour {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);
		
		//Even Numbers
		System.out.println("Even Numbers ::");
		behaviorialoperation(numbers, x -> x%2 == 0);
		
		// Odd Numners
		System.out.println("Odd Numbers ::");
		behaviorialoperation(numbers, x -> x%2 != 0);
		
		// Functions to bheaviourial pattern
		System.out.println("Functions :: Behavioural :Squared :");
		Function<Integer, Integer> mapper = num -> num * num;
		mapperOperation(numbers, mapper);
		
		System.out.println("Functions :: Behavioural :Cubes :");
		mapperOperation(numbers, num -> num*num*num);
	}

	//exercice 12
	private static void mapperOperation(List<Integer> numbers, Function<Integer, Integer> mapper) {
		numbers.stream()
			.map(mapper)
			.distinct()
			.sorted()
			.forEach(System.out::println);
	}

	
	private static void behaviorialoperation(List<Integer> numbers, Predicate<Integer> predicate) {
		numbers.stream()
		.filter(predicate)
		.forEach(System.out::println);
	}
	
	
	
	

}
