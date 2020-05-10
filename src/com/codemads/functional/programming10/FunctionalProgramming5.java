package com.codemads.functional.programming10;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class FunctionalProgramming5 {


	/*
	 * FunctionalProgramming5 contains,
	 * 1. Filters
	 * 2. allMatch, noneMatch, anyMatch
	 * 3. Sorting : Increasing, Decreasing, Multiple Sorting Conditions
	 * 4. Comparator.comparing(exp).thenComapring(exp2)
	 * 5. skip (int) & Limit(int)
	 * 6. Take while(lambda)  - checks the condition, as long its true it will print. If it gets any element not matching then it drops rest
	 * 7. drop while(lambda) - Check for the condition, as long as its true it will drop the elements 
	 * 8. min, max with Comparator:: stream.min(Comparator.comparing(exp)), stream.max(Comparator.comparing(exp))
	 * 9. findFirst() on Sorted Stream:: stream.sorted(numofStudComparatorInc).findFirst();
	 * 10.findAny() on Sorted Stream :: stream.sorted(numofStudComparatorInc).findAny();
	 * 11. Stream().findFirst().orElse(new Object());
	 * 12. count() - To find the count of elements in a list (satisfying some condition may be)
	 * 13. sum() - get the sum of some field after mapping the field
	 * 14. average() - get the average of some field after mapping the field
	 * 15. GroupingBy() - stream().collect(Collectors.groupingBy(Object :: Field));
	 * 16. GroupingBy & Tolist - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.mapping(Object::Field, Collectors.toList())));
	 * 17. GroupingBy & Summ - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.summingInt(Object::Field)));
	 * 18. GroupingBy & Count - stream().collect(Collectors.groupingBy(Object :: Field, Collectors.counting()));
	 */
			
	public static void main(String[] args) {
		List<Course> courses = List.of(new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000), new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000), new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 99, 21000), new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000));


		// print the courses with review score greater than 90
		courses.stream().filter(x -> x.getReviewScore()>=90).forEach(System.out::println);
		System.out.println("***********");
		
		// allMatch, noneMatch, anyMatch
		Predicate<Course> reviewScoreGT90 = course -> course.getReviewScore() >90;
		Predicate<Course> reviewScoreLT90 = course -> course.getReviewScore() <90;
		Predicate<Course> reviewScoreGT95 = course -> course.getReviewScore() >95;
		Predicate<Course> reviewScoreLT92 = course -> course.getReviewScore() <92;

		System.out.println(courses.stream().allMatch(reviewScoreGT90));
		System.out.println(courses.stream().noneMatch(reviewScoreLT90));
		System.out.println(courses.stream().allMatch(reviewScoreGT95));
		System.out.println(courses.stream().noneMatch(reviewScoreGT90));
		System.out.println(courses.stream().anyMatch(reviewScoreLT92));
		System.out.println("***********");		


		// Sorting Increasing order : Num of Students
		Comparator<Course> numofStudComparatorInc = Comparator.comparing(Course :: getNoOfStudents);
		courses.stream().sorted(numofStudComparatorInc).forEach(System.out::println);
		courses.stream().sorted(Comparator.comparing(Course :: getNoOfStudents)).forEach(System.out::println);
		System.out.println("***********");		

		// Sorting Decreasing order
		Comparator<Course> numofStudComparatorDec = Comparator.comparing(Course :: getNoOfStudents).reversed();
		courses.stream().sorted(numofStudComparatorDec).forEach(System.out::println);
		System.out.println("***********");		

		// Sorting Decreasing order
		Comparator<Course> numofStudComparatorReviewFirst = Comparator.comparing(Course :: getReviewScore).reversed();
		courses.stream()
		.sorted(numofStudComparatorReviewFirst)
		.sorted(numofStudComparatorInc)
		.forEach(System.out::println);
		System.out.println("***********");		

		// Multiple Sorting conditions
		Comparator<Course> numofStudComparatorReviewFirst2 = Comparator.comparing(Course :: getReviewScore).thenComparing(Course :: getNoOfStudents).reversed();
		courses.stream()
		.sorted(numofStudComparatorReviewFirst2)
		.forEach(System.out::println);
		System.out.println("***********");


		// Skip & limit
		courses.stream()
		.sorted(numofStudComparatorReviewFirst2)
		.skip(2)
		.limit(4)
		.forEach(System.out::println);
		System.out.println("***********");		

		// Take while  - checks the condition, as long its true it will print. If it gets any element not matching then it drops rest
		System.out.println(courses);
		System.out.println("***********");	
		courses.stream()
		.sorted(numofStudComparatorInc)
		.takeWhile(course -> course.getNoOfStudents() < 20000)
		.forEach(System.out::println);
		System.out.println("***********");

		// drop while - Check for the condition, as long as its true it will drop the elements 
		courses.stream()
		.sorted(numofStudComparatorInc)
		.dropWhile(course -> course.getNoOfStudents() < 20000)
		.forEach(System.out::println);
		System.out.println("***********");	

		courses.stream().sorted(numofStudComparatorInc).forEach(System.out::print);
		System.out.println();

		// Finding Top, Max Min FindFirst FindAny
		System.out.println( "Min of :::" +
				courses
				.stream()
		.min(numofStudComparatorInc));

		System.out.println( "Max of :::" +
				courses
				.stream()
		.max(numofStudComparatorInc));


		System.out.println( "Find First  of :::" +
				courses.stream()
		.sorted(numofStudComparatorInc)
		.findFirst()
				);

		System.out.println( "Find any of :::" +
				courses.stream()
		.filter(reviewScoreGT95)
		.sorted(numofStudComparatorInc)
		.findAny()
				);

		// Find First().orElse()
		System.out.println( "Optional of :::" +
				courses.stream()
		.filter(course -> course.getReviewScore() >99)
		.findFirst()
		.orElse(new Course("Java", "Tech", 95, 1))
				);

		
		// Sum Count Avg
		// FullStack:14000:91Spring Boot:18000:95Spring:20000:98Docker:20000:92Kubernetes:20000:91AWS:21000:92Azure:21000:99API:22000:97Microservices:25000:96
		System.out.println( "SUM of :::" +
				(courses
						.stream()
						.filter(reviewScoreLT92)
						.mapToInt(Course::getNoOfStudents))
						.sum());


		System.out.println( "Average of :::" +
				courses
				.stream()
				.filter(reviewScoreLT90)
				.mapToDouble(Course::getReviewScore)
				.average()
				.orElse(0f));

		System.out.println( "Count of :::" +
				courses
				.stream()
				.filter(reviewScoreGT95)
				.count());

		System.out.println("***********");	

		// Group by
		System.out.println("Group By " +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory)));

		System.out.println("Group By - to listt : " +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, 
				Collectors.mapping(Course::getName, Collectors.toList()))));

		System.out.println("Group By - to summing : " +
				courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.summingInt(Course::getNoOfStudents))));

		System.out.println("Group By Count :: " + extracted(courses));
	
	}

	private static Map<String, Long> extracted(List<Course> courses) {
		return courses.stream()
				.collect(Collectors.groupingBy(Course::getCategory, Collectors.counting()));
	}

}


class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	public String toString() {
		return name + ":" + noOfStudents + ":" + reviewScore;
	}

}