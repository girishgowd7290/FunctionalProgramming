/**
 * 
 */
package com.codemads.functional.programming1;

import java.util.List;

/**
 * @author girishgowda
 *
 */
public class FP01Fucntional {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,4,5,7,2,8,9);
		printAllDataInList(numbers);
		printEvenDataInList(numbers);
		printSquaresOfList(numbers);
	}

	
	private static void printSquaresOfList(List<Integer> numbers) {
		
		System.out.println("Print Squares of the numbers");
		numbers.stream()
		.map(num -> num*num)
		.forEach(System.out::println);
	}

	/**
	 * 
	 * @param of
	 */
	private static void printAllDataInList(List<Integer> numbers) {
		
		// Stream  a list using .stream() and for every number we get call method print 
		System.out.println("Method Reference within class");
		numbers.stream()
		.forEach(FP01Fucntional::print); // method reference
		
		System.out.println("Method Reference with Default class");
		numbers.stream()
		.forEach(System.out::println); // method reference

	}

	private static void printEvenDataInList(List<Integer> numbers) {
		System.out.println("Stream data with filters");
		numbers.stream()
		.filter(FP01Fucntional::isEven) // Filters
		.forEach(System.out::println); // method reference
		
		System.out.println("Stream data with Lambda");
		numbers.stream()
		.filter(number -> number%2==0) // Filters
		.forEach(System.out::println); // method reference
		
	}
	
	private static void print(int number) {
		System.out.println(number);
	}
	
	private static boolean isEven(int number) {
		return number%2==0;
	}
}
