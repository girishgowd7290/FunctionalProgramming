/**
 * 
 */
package com.codemads.functional.programming7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author girishgowda
 *
 */
public class FP07Strings {

	/**
	 * @param args
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
		
		
		// Split every character of an item :: 
		courses
		.stream()
		.map(course -> course.split(""))
		.collect(Collectors.toList());
		
		
		System.out.println(" Split items on using flatmap to collect :: " +
				courses
				.stream()
				.map(course -> course.split(""))
				.flatMap(Arrays::stream)
				.distinct()
				.collect(Collectors.toList())
				);
		
		// Creating tuples
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
		
		//Intermediary functions
		System.out.println("Intermediary functions :: " + courses.stream().filter(course -> course.length() > 8).map(String::toUpperCase).findAny());
		
		System.out.println("Intermediary functions without terminalObject:: " + courses.stream().filter(course -> course.length() > 8).map(String::toUpperCase));
		
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
