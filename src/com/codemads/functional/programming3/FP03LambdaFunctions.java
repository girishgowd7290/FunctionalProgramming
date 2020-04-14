/**
 * 
 */
package com.codemads.functional.programming3;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author girishgowda
 *
 */
public class FP03LambdaFunctions {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);
		//List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");
		
		
		System.out.println("With Lambda Funcstions");
		numbers.stream()
			.filter(num -> num%2 == 0)
			.distinct()
			.sorted()
			.map(num -> num * num)
			.forEach(System.out::println);
		
		
		System.out.println("With Predicates, Consumer & Functions");
		
		
		Predicate<Integer> predicate = num -> num%2 == 0;
		Predicate<Integer> predicate2 = new Predicate<Integer>() {

			@Override
			public boolean test(Integer num) {
				return num%2==0;
			}
			
		};
		
		Function<Integer, Integer> mapper = num -> num * num;
		Function<Integer, Integer> mapper2 = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer num) {
				return num * num;
			}
			
		};
		
		Consumer<Integer> action = System.out::println;
		Consumer<Integer> action2 = new Consumer<Integer>() {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
			
		};
			
		numbers.stream()
		.filter(predicate)
		.distinct()
		.sorted()
		.map(mapper)
		.forEach(action);
	
		System.out.println("With Predicates, Consumer & Functions :: In traditional Approach");
		
		numbers.stream()
		.filter(predicate2)
		.distinct()
		.sorted()
		.map(mapper2)
		.forEach(action2);
	
	
		
	}
	
}
