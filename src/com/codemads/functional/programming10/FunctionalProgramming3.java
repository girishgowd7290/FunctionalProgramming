package com.codemads.functional.programming10;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class FunctionalProgramming3 {

	public static void main(String[] args) throws IOException {

		/**
		 * Streams
		 */
		// Primitive Streams
		System.out.println("Range :: " +IntStream.range(1, 10));
		System.out.println("Closed Range " + IntStream.rangeClosed(1, 10));

		System.out.println("Incremental of 2 :: " + IntStream.iterate(1, e -> e+2).limit(10));
		System.out.println("Int Stream to Boxed to List" + 
				IntStream
				.iterate(1, e -> e+2)
		.limit(10)
		.boxed()
		.collect(Collectors.toList()));


		// Use of Big INteger
		System.out.println("Long Stream ::: " +
				IntStream.rangeClosed(1, 25)
		.reduce(1, (x,y) -> x*y));

		System.out.println("Big Integer ::: " +
				LongStream.rangeClosed(1,50)
		.mapToObj(BigInteger::valueOf) // used for Big numbers
		.reduce(BigInteger.ONE, BigInteger::multiply));



		/**
		 * Parallel Programming
		 */
		System.out.println(LongStream.rangeClosed(1, 1000000000).sum()); // without parallelism
		System.out.println(LongStream.rangeClosed(1, 1000000000).parallel().sum());


		/**
		 * Immutability
		 */
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");
		//courses.replaceAll(str -> str.toUpperCase()); // Throws unsuppoted exception due to immutability

		// Change to uppercase for all lsit elements
		List<String> coursesCopy = new ArrayList<String>(courses); 
		coursesCopy.replaceAll(str -> str.toUpperCase()); // .replaceAll is used on child list created from parent
		System.out.println("Uppercase list :replaceAll :" + coursesCopy);


		/**
		 * File Operations
		 */
		//Print all lines of file
		Files.lines(Paths.get("resources/file.txt")).forEach(System.out::println);
		System.out.println("**************");

		// Directory listings
		Files.list(Paths.get("./"))
		//.filter(Files::isDirectory)
		.forEach(System.out::println);

		

	}

}
