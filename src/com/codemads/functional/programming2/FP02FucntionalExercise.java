/**
 * 
 */
package com.codemads.functional.programming2;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author girishgowda
 *
 */
public class FP02FucntionalExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");
		
		exercises(numbers, courses);

		System.out.println("square every number in a list and find the sum of squares ::" + exercise7(numbers));
		System.out.println("Cube every number in a list and find the sum of squares ::" + exercise8(numbers));
		System.out.println("Sum of Odd Numbers in a list :: " + exercise9(numbers));
		
		System.out.println("Create a List with Even Numbers Filtered from the Numbers List :: " + exercise10(numbers));
		System.out.println("Create a List with lengths of all course titles. :: " + exercise11(courses));

		
	}
	

	//square every number in a list and find the sum of squares
	private static int exercise7(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x,y) -> x+(y*y));
	}

	// Exercise 8  Cube every number in a list and find the sum of cubes
	private static int exercise8(List<Integer> numbers) {
		return numbers.stream().reduce(0, (x,y) -> x+(y*y*y));
	}


	// Exercise 9 Find Sum of Odd Numbers in a list
	private static int exercise9(List<Integer> numbers) {
		return numbers.stream().filter(num -> num %2 != 0).reduce(0, (x,y) -> x+y);
	}


	// Create a List with lengths of all course titles
	private static List<String> exercise11(List<String> courses) {

		return courses.stream().sorted().map(course -> course + " : " + course.length()).collect(Collectors.toList());
	}

	// Exercise 10 Create a List with Even Numbers Filtered from the Numbers List
	private static List<Integer> exercise10(List<Integer> numbers) {
		return numbers.stream().distinct().sorted().filter(num -> num %2 == 0).collect(Collectors.toList());
	}

	// Distinct & Sorted
	private static void exercises(List<Integer> numbers, List<String> courses) {

		System.out.println("Distinct Numbers");
		numbers.stream().distinct().forEach(System.out::println);

		System.out.println("Sorted Numbers");
		numbers.stream().sorted().forEach(System.out::println);
		
		System.out.println("Distinct  & Sorted");
		numbers.stream().distinct().sorted().forEach(System.out::println);
		
		System.out.println("Sorted Courses :");
		courses.stream().sorted().forEach(System.out::println);
		System.out.println("");
	
		System.out.println("Sorted Courses :with comparator :: natural order");
		courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Sorted Courses : With Comparator ::reverse order:");
		courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Sorted Courses : With Custom Comparator ::");
		courses.stream().sorted(Comparator.comparing(str -> str.length())).forEach(System.out::println);
		System.out.println("");
	}
}
