/**
 * 
 */
package com.codemads.functional.programming1;

import java.util.List;

/**
 * @author girishgowda
 *
 */
public class FP01FucntionalExercise {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> numbers =List.of(12,4,5,7,2,8,9);
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");

		//printOddNumbersFromList(numbers);
		
		//printCoursesIndividually(courses);
		
		//printCoursesWithSpring(courses);
		
		//printCoursesWith4Letters(courses);
		
		//printCubesOfOddNumbers(numbers);
		
		printNumberOfCharactersInCourse(courses);
		
	}

	// exercise 6 : Print number of characters in each Course
	private static void printNumberOfCharactersInCourse(List<String> courses) {
		courses.stream()
		.map(course -> course + "::" +course.length())
		.forEach(System.out::println);
	}

	// exercise 5 : Print cubes of Odd numbers
	private static void printCubesOfOddNumbers(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2 != 0)
		.map(num -> num * num * num)
		.forEach(System.out::println);
	}

	// exercise 4 : Print only those courses having 4 letters
	private static void printCoursesWith4Letters(List<String> courses) {
		courses.stream()
		.filter(course -> course.length()<=4)
		.forEach(System.out::println);
	}

	//exercise 3 - print only those courses containing spring
	private static void printCoursesWithSpring(List<String> courses) {
		courses.stream()
		.filter(course -> course.contains("Spring"))
		.forEach(System.out::println);
	}


	//exercise 1 - print only odd
	private static void printOddNumbersFromList(List<Integer> numbers) {
		numbers.stream()
		.filter(number -> number%2!=0)
		.forEach(System.out::println);
	}
	
	//exercise 2 - print courses individually
	private static void printCoursesIndividually(List<String> courses) {
		courses.stream()
		.forEach(System.out::println);
	}

}
