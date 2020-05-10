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


/**
 * FunctionalProgramming contains the overall summary of the Lambdas and Streams usage
 * 
 * @author girishgowda
 *
 */

public class FunctionalProgramming2 {
	
	/*
	 * FunctionalProgramming2 contains 
	 * 
	 * 1. Supplier - No Args but returns a value
	 * 2. UnaryOperator - Takes only one arguement; return type is same as arguement
	 * 3. BiPredicate - Takes two input params n returns a boolean value
	 * 4. BiFucntion - Takes two input params n returns a  value
	 * 5. BiConsumer - Takes two input params n returns nothing
	 * 6. IntBinaryOperator - Takes 2 Integer params n return the Integer type
	 * 7. IntConsumer - Consumes a Integer type param and performs operation. Doesn return anything
	 * 8. IntFunction - Takes Integer as param always and returns the data type value defined
	 * 9. IntPredicate - Takes Integer as param and returns Boolean value
	 * 10. IntSupplier - No Input args but returns a Integer value
	 * 11. IntToDoubleFunction function - Takes Integer as input param and returns Double value
	 * 12. IntToLongFunction function - Takes Integer as input param and returns Long value
	 * 13. Int Unary Operator - Takes Integer as only  param and returns the Integer value
	 * 14. To create a new Object - Supplier<Object> object = Object::new;
	 * 
	 */
	public static void main(String[] args) {
		
		List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices", "AWS", "PCF","Azure", "Docker", "Kubernetes", "Ruby");

		/*
		 * Supplier - Zero args but returns a value of <T>
		 */
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
		// BiPredicate - Takes two input params n returns a boolean value
		BiPredicate<Integer, Integer> biPredicate = (x,y) -> x>y;
		System.out.println("BiPredicate :: " +biPredicate.test(10, 15));


		// BiFucntion - Takes two input params n returns a  value
		// <Input, Input, Output>
		BiFunction<String, String, String> biFunction = (boy,girl) -> "Hello " + boy + girl;
		System.out.println("Bi Function :: " + biFunction.apply("Giri ", "Sumu"));


		//BiConsumer - Takes two input params n returns nothing
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


		//IntBinaryOperator - Takes 2 Integer params n return the Integer type
		IntBinaryOperator intBinOpr2 = (x, y) -> x+y;
		System.out.println("INT Binary Operator : " + intBinOpr.applyAsInt(5, 6));
		System.out.println("INT Binary Operator : " + intBinOpr2.applyAsInt(5, 6));

		//IntConsumer - Consumes a Integer type param and performs operation. Doesn return anything
		// takes Integer as a param to Print
		IntConsumer intConsumer = System.out::println;
		intConsumer.accept(4);

		//IntFunction - Takes Integer as param always and returns the data type value defined
		// takes int params n return the result
		IntFunction<String> intFunc = x -> x+ " times I love you";
		System.out.println("Int Function ::" +intFunc.apply(5));

		// IntPredicate - Takes Integer as param and returns Boolean value
		IntPredicate intPredicate = x -> x>10;
		System.out.println("Given value is greater than 10.? :" + intPredicate.test(5));

		//IntSupplier - No Input args but returns a Integer value
		IntSupplier intSupplier = () -> 10;
		System.out.println("IntSupplier : "+intSupplier.getAsInt());

		//IntToDoubleFunction function - Takes Integer as input param and returns Double value
		IntToDoubleFunction intToDoubleFunction = x -> x;
		System.out.println("IntToDoubleFunction :: "+ intToDoubleFunction.applyAsDouble(5));

		//IntToLongFunction function - Takes Integer as input param and returns Long value
		IntToLongFunction intToLongFunction = x -> x * 56735483;
		System.out.println("IntToLongFunction :: " + intToLongFunction.applyAsLong(6));

		//Int Unary Operator - Takes Integer as only  param and returns the Integer value
		IntUnaryOperator intUnaryOperator = x -> x*x;
		System.out.println("IntUnaryOperator :: "+ intUnaryOperator.applyAsInt(5));


		// To create a new Object - Supplier<Object> object = Object::new;
		Supplier<Couples> coupleObject = Couples::new;
		coupleObject.get().getBoy();

	}


}
