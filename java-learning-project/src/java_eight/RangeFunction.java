package java_eight;

import java.util.stream.IntStream;

/**
 * @author Vinod Lakhani
 *
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
	}
}
