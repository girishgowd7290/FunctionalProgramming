/**
 * 
 */
package com.codemads.functional.programming7;

import java.util.stream.IntStream;

/**
 * @author girishgowda
 *
 */
public class FP10Threads {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Traditioanl
		Runnable runnable = new Runnable() {
			@Override
			public void run() {

				for(int i =0; i <10000; i++) {
					//System.out.println("Trad :"+ Thread.currentThread().getId() + " :: "+i);
				}
			}
		};
		
		
		// Functional
		Runnable runnableFun = () ->{
			IntStream.range(1, 1000).forEach(i -> System.out.println("Func ::" +Thread.currentThread().getId() + " :: "+i));
		};
		
		Thread threadFun = new Thread(runnableFun);
		threadFun.start();
		
		Thread thread1 = new Thread(runnable);
		thread1.start();
	}

}
