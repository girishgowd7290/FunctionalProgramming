/**
 * 
 */
package com.codemads.functional.programming10;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author girishgowda
 *
 */
public class FunctionalProgramming4 {

	
	/*
	 * FunctionalProgramming4 Contains
	 * 1. Collectors.joining("<>") - Merges all elements to a String
	 * 2. Split every Item of a list - USe flatMap(Arrays::stream)
	 * 3. Nested Loops / Streams
	 * 4. Intermediary functions - findFirst(), findAny(), Peek() - elements while streaming
	 */
	public static void main(String[] args) {

		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");
		
		List<String> courses2 = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");


		// Split items on space/comma collect :: 
		System.out.println(" Split items on space/comma collect :: " +
				courses
				.stream()
				.collect(Collectors.joining(","))
				);
		
		String items = courses
				.stream()
				.collect(Collectors.joining(","));
		System.out.println();
		
		
		// Split every character of an item :: this doesn work
		System.out.println(
		courses
		.stream()
		.map(course -> course.split(""))
		.collect(Collectors.toList()));
		
		
		// Using Flat map to split every individual element
		System.out.println();
		System.out.println(" Split items on using flatmap to collect :: " +
				courses
				.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList())
				);
		System.out.println();
		
		
		// Creating tuples - elements with same length 
		System.out.println(" Split items on using flatmap to  collect tuples :: " +
				courses
				.stream()
				.flatMap(course -> courses2
									.stream()
									.filter(course2 -> course2.length()==course.length())
									.map(course2 -> List.of(course, course2)))
				.filter(listElement -> !listElement.get(0).equals(listElement.get(1)))
				.collect(Collectors.toList())
				);
		System.out.println();
		
		//Intermediary functions
		System.out.println("Intermediary functions :findAny() : " + 
		courses
		.stream()
		.filter(course -> course.length() > 8)
		.map(String::toUpperCase)
		.findAny());
		System.out.println();
		
		System.out.println("Intermediary functions without terminalObject:: " +
		courses
		.stream()
		.filter(course -> course.length() > 8)
		.map(String::toUpperCase));
		System.out.println();
		
		//peeek
		System.out.println("Intermediary functions :: " + 
		courses.stream()
		.peek(System.out::println)
		.filter(course -> course.length() >11)
		.peek(System.out::println)
		.map(String::toUpperCase)
		.peek(System.out::println)
		.findAny());
		
		
		
	}

}
