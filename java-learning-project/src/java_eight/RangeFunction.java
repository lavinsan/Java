package java_eight;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * @author Vinod Lakhani
 */
public class RangeFunction {

	public static void main(String[] args) {

		// rangeClosed function start value and end value
		// forEachOrdered will execute one by one in sequence
		// even we used parallel execution and value is ordered
		IntStream	.rangeClosed(1, 10)
					.parallel()
					.forEachOrdered(System.out::print);
		System.out.println();

		// range function start value and end value -1
		// forEach will execute in parallel so value will be
		// not ordered
		IntStream	.range(1, 10)
					.parallel()
					.forEach(System.out::print);
		System.out.println();

		// skip function will skip first four values
		IntStream	.range(1, 10)
					.skip(4)
					.forEach(System.out::print);
		System.out.println();

		// sum function will total all the value
		System.out.println(IntStream.range(1, 10)
									.parallel()
									.sum());
		System.out.println();

		// ints method takes 3 arguments
		// 1-- size 2-- starting(inclusive) 3-- ending(exclusive)
		new Random().ints(5, 20, 25)
					.forEach(System.out::println);
		System.out.println();

		// ints method takes 2 arguments
		// 1-- starting(inclusive) 2-- ending(exclusive)
		// limit is same as size
		new Random().ints(10, 15)
					.limit(5)
					.forEach(System.out::println);
		System.out.println();

		// to get value as int we use findfirst and getasint
		int asInt =
			new Random().ints(10, 15)
						.limit(1)
						.findFirst()
						.getAsInt();
		System.out.println(asInt);
	}
}
