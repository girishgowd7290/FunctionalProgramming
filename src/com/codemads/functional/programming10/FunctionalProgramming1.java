/**
 * 
 */
package com.codemads.functional.programming10;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * FunctionalProgramming contains the overall summary of the Lambdas and Streams usage
 * 
 * Will try to combine all the features available with Streams in one place 
 * 
 * 1. Streams
 * 2. Filter
 * 3. Map
 * 4. reduce
 * 5. distinct
 * 6. sorted - reverse order, Comparator.comparing(exp)
 * 7. collect
 * 8. Predicate(Objet, Boolean), MapperFunctions(InObject,OutObject), Consumer(Object, Void)
 * 9. Behavioural approach
 * 
 * @author girishgowda
 *
 */
public class FunctionalProgramming1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Functional Programming Baics
		funcProgBasics();


		// Prediccates , Functions , Consumer
		predicatesFunctionsConsumer();
		
		
		// Behaviourial Approach - passing the behaviour as parameter
		behavioralApproach();
		
	}

	/**
	 * 
	 */
	private static void behavioralApproach() {
		List<Integer> numbers =List.of(7,2,90,31,10,93,1,13,19, 7, 2);
		
		Predicate<Integer> predicate = num -> num < 25;
		Function<Integer, Integer> mapper = num -> num * num;
		
		// pass the behavior to method
		List<Integer> processedNumbers = passIntBehaviour(numbers, predicate, mapper);
		System.out.println("Behaviour method  ::" + processedNumbers);
		
		// return the behaviour. ?
	}

	/**
	 * @param numbers
	 * @param predicate
	 * @param mapper
	 */
	private static List<Integer> passIntBehaviour(List<Integer> numbers, Predicate<Integer> predicate, Function<Integer, Integer> mapper) {
		return numbers
		.stream()
		.filter(predicate)
		.map(mapper)
		.collect(Collectors.toList());
	}

	/**
	 * 
	 */
	private static void predicatesFunctionsConsumer() {
		List<String> friends = List.of("Girish","Sumana","Sushmihta","Chandana","Amitha","Roy","Rak","Lohit");

		// With Lambda 
		friends
		.stream()
		.filter(names -> names.length()>2)
		.map(name -> "Hello "+ name)
		.forEach(System.out::println);


		// With Predicates, Functions  & Consumer
		System.out.println("With Predicates, Consumer & Functions to define Lambda::");
		
		
		/*
		 * Predicates test method is overriden 
		 */
		// Accepts a single param and returns boolean value
		Predicate<String> predicate1 = names -> names.length()>2;
		
		
		/*
		 * Functions Apply method is overridden
		 */
		// <Input param, Output param> Accepts a param n returns a value
		Function<String, String> mapper1 = name -> "Hello "+ name;
		
		
		/*
		 * Consumers accept method is overidden 
		 */
		// <param> accepts a param n returns void
		Consumer<String> action1 = System.out::println;
		
		
		// apply predicate, function & Consumer
		friends
		.stream()
		.filter(predicate1)
		.map(mapper1)
		.forEach(action1);
	}

	private static void funcProgBasics() {
		List<Integer> numbers =List.of(7,2,90,31,10,93,1,13,19, 7, 2);

		List<String> friends = List.of("Girish","Sumana","Sushmihta","Chandana","Amitha","Roy","Rak","Lohit");

		// Method reference with Default Static class methods
		System.out.println("Method reference with Default Static class methods :: ");
		numbers
		.stream()
		.forEach(System.out::println);

		// Method reference with custom self class methods
		System.out.println("Method reference with custom self class methods :: ");
		numbers
		.stream()
		.forEach(FunctionalProgramming1::print);

		// use of FILTER to filter List items 
		System.out.println("Use of Filters on List :: ");
		numbers
		.stream()
		.filter(num -> num%2==0)
		.forEach(System.out::println);


		// Use of map function to derive something
		System.out.println("Use of Map functions :: ");
		numbers
		.stream()
		.filter(num -> num %2 !=0)
		.map(num -> num*num)
		.forEach(System.out::println);

		System.out.println("Use of Map functions on String:: ");
		friends
		.stream()
		.filter(name -> name.length() >4)
		.map(name -> "Hello " + name)
		.forEach(System.out::println);


		//Reduce function 
		System.out.println("Sum of all the elements in a list using Reduce func : "+
				numbers
				.stream()
		.reduce(0, (x,y)-> (x+y)));

		// With Static func - sum of odd numbers
		numbers
		.stream()
		.filter(num -> num%2!=0)
		.reduce(0, Integer:: sum);

		// collect - Create a new list of elements 
		// Collectors.toList() to create a new list
		System.out.println("Usage of collect :: "+
				friends
				.stream()
		.filter(names -> names.length() <5)
		.collect(Collectors.toList()));

		// distinct
		System.out.println("Use of distinct on list of numbers : ");
		numbers
		.stream()
		.distinct()
		.forEach(System.out::println);

		//Use of Sorted method on list of numbers and strings


		// Sort numbers
		System.out.println("Sort numbers :");
		numbers
		.stream()
		.distinct()
		.sorted()
		//.sorted(Comparator.naturalOrder())
		.forEach(System.out::println);

		// Using standard methods of Comparator to reverse the order
		System.out.println("Sort numbers in reverse order :");
		numbers
		.stream()
		.distinct()
		.sorted(Comparator.reverseOrder())
		.forEach(System.out::println);

		// Defining a new custom comparator using Comparator.comparing
		System.out.println("Custom sort of names in ascendig order");
		friends
		.stream()
		.distinct()
		.sorted(Comparator.comparing(name -> name.length()))
		.forEach(System.out::println);
	}

	private static void print(int args) {
		System.out.println(args);
	}
}
