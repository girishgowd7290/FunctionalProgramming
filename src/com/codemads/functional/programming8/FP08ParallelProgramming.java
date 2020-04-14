/**
 * 
 */
package com.codemads.functional.programming8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author girishgowda
 *
 */
public class FP08ParallelProgramming {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		
		//System.out.println(LongStream.rangeClosed(1, 1000000000).sum());
		//System.out.println(LongStream.rangeClosed(1, 1000000000).parallel().sum());
		System.out.println(System.currentTimeMillis()-time);
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");
		List<String> coursesCopy = new ArrayList<String>(courses); 
		
		System.out.println("Uppercase list ::");
		List<String> coursesCopy2 = courses.stream().map(str -> str.toUpperCase()).collect(Collectors.toList());
		
		
		coursesCopy.replaceAll(str -> str.toUpperCase());
		System.out.println("Uppercase list :replaceAll :" + coursesCopy);
		
		// throws unsuppoted exception
		//courses.replaceAll(str -> str.toUpperCase());
		System.out.println("Uppercase list :Originial :" + courses);
		System.out.println("Uppercase list :Map - uppercase:" + coursesCopy2);
		
	}

}
