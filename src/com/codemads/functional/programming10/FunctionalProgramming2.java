package com.codemads.functional.programming10;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import com.codemads.functional.programming4.Couples;
import com.codemads.functional.programming4.FP04FunctionalInterfaces;



public class FunctionalProgramming2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");


		// Supplier
		// Zero args but returns a value of <T>
		Supplier<Integer> randomInteger = () -> {
			Random random = new Random();
			return random.nextInt(10);
		};
		System.out.println("RandomIntegers ::  " + randomInteger.get());

		Supplier<Date> date = () -> {
			return new Date();
		};
		System.out.println("Date : "+date.get());



		//Unary Operator
		// single Arg n return tyoe are of same type
		UnaryOperator<String> unaryOperator = x -> "Hello " + x;
		System.out.println("Unary opertor :: " + unaryOperator.apply("Sumu"));

		UnaryOperator<Couples> couples = couple -> new Couples("Giri","Sumu");
		System.out.println("Couple Object ::" + couples.apply(null));

		UnaryOperator<Couples> couples1 = new UnaryOperator<Couples>() {

			@Override
			public Couples apply(Couples couple) {
				return new Couples("Giri","Sumu");
			}

		};
		System.out.println("Couple Object ::" + couples1.apply(null));



		// BiPredicate
		// Takes two params n returns a boolena
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> x>y;
		System.out.println("BiPredicate :: " +biPredicate.test(10, 15));


		// BiFucntion
		// <Input, Input, Output>
		BiFunction<String, String, String> biFunction = (boy,girl) -> "Hello " + boy + girl;
		System.out.println("Bi Function :: " + biFunction.apply("Giri ", "Sumu"));


		//BiConsumer
		// Takes 2 params n returns void
		BiConsumer<String, String> biConsumer  = (boy,girl) -> System.out.println("BiConsumer :: Hello "+ boy+girl);
		biConsumer.accept("Giri", "Sumu");

		//IntBinaryOperator
		IntBinaryOperator intBinOpr = new IntBinaryOperator() {
			@Override
			public int applyAsInt(int left, int right) {

				return left+right;
			}

		};


		//IntBinaryOperator takes 2 params n return the same arg typw
		IntBinaryOperator intBinOpr2 = (x, y) -> x+y;
		System.out.println("INT Binary Operator : " + intBinOpr.applyAsInt(5, 6));
		System.out.println("INT Binary Operator : " + intBinOpr2.applyAsInt(5, 6));

		//IntConsumer 
		// takes Integer as a param to Print
		IntConsumer intConsumer = System.out::println;
		intConsumer.accept(4);

		//IntFunction
		// takes int params n return the result
		IntFunction<String> intFunc = x -> x+ " times I love you";
		System.out.println("Int Function ::" +intFunc.apply(5));

		// IntPredicate
		IntPredicate intPredicate = x -> x>10;
		System.out.println("Given value is greater than 10.? :" + intPredicate.test(5));

		//IntSupplier
		IntSupplier intSupplier = () -> 10;
		System.out.println("IntSupplier : "+intSupplier.getAsInt());

		//IntToDouble function
		IntToDoubleFunction intToDoubleFunction = x -> x;
		System.out.println("IntToDoubleFunction :: "+ intToDoubleFunction.applyAsDouble(5));

		//Int to Long Function
		IntToLongFunction intToLongFunction = x -> x * 56735483;
		System.out.println("IntToLongFunction :: " + intToLongFunction.applyAsLong(6));

		//Int Unary Operator
		IntUnaryOperator intUnaryOperator = x -> x*x;
		System.out.println("IntUnaryOperator :: "+ intUnaryOperator.applyAsInt(5));

		courses.stream()
		.map(str -> FP04FunctionalInterfaces.formatInput(str))
		.forEach(System.out::println);

		Supplier<Couples> coupleObject = Couples::new;
		coupleObject.get().getBoy();

	}

	public static String formatInput(String name) {
		return "Hello " + name;
	}


}
