/**
 * 
 */
package com.codemads.functional.programming9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author girishgowda
 *
 */
public class FP09FileOperations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			
			//Print all lines of file
			Files.lines(Paths.get("resources/file.txt")).forEach(System.out::println);
			System.out.println("**************");
			
			// print distinct words
			Files.lines(Paths.get("resources/file.txt"))
			.map(str -> str.split(" "))
			.flatMap(Arrays::stream)
			.distinct()
			.sorted()
			.forEach(System.out::println);
			
			System.out.println("**************");
			
			// Directory listings
			Files.list(Paths.get("./"))
			//.filter(Files::isDirectory)
			.forEach(System.out::println);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
