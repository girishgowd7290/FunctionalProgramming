/**
 * 
 */
package com.codemads.functional.programming6;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author girishgowda
 *
 */
public class FP06Streams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> numbers =List.of(12,9,13,4,6,2,4,12,15);

		// Stream referencing to Reference type
		System.out.println(numbers.stream());

		// Stream referencing to Reference type
		System.out.println(Stream.of(12,9,13,4,6,2,4,12,15));

		// Stream is of type Int
		int [] numArray = {12,9,13,4,6,2,4,12,15};
		System.out.println(Arrays.stream(numArray));
		System.out.println("Count :: " +Arrays.stream(numArray).count());
		System.out.println("SUM ::  " +Arrays.stream(numArray).sum());



		// Primitive Streams
		System.out.println("Range :: " +IntStream.range(1, 10));

		System.out.println("Closed Range " + IntStream.rangeClosed(1, 10));


		System.out.println("Incremental of 2 :: " + IntStream.iterate(1, e -> e+2).limit(10));


		System.out.println("IntSteam to Boxed to List" + IntStream.iterate(1, e -> e+2).limit(10).boxed().collect(Collectors.toList()));



		// Use of Big INteger
		System.out.println("Long Stream ::: " +
		IntStream.rangeClosed(1, 25)
		.reduce(1, (x,y) -> x*y));
		
		System.out.println("Big Integer ::: " +
		LongStream.rangeClosed(1,50)
		.mapToObj(BigInteger::valueOf)
		.reduce(BigInteger.ONE, BigInteger::multiply));

	}

}
