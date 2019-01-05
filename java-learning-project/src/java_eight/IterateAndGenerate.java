package java_eight;

import java.util.stream.Stream;

public class IterateAndGenerate {

	public static void main(String[] args) {

		Stream<Integer> iterate =
			Stream	.iterate(1, num -> num * 2)
					.limit(5);
		iterate.forEach(System.out::println);

		Stream<Double> generate =
			Stream	.generate(Math::random)
					.limit(5);
		generate.forEach(System.out::println);

		Stream<Integer> integer =
			Stream	.generate(() -> (int) (Math.random() * 100) + 100)
					.limit(5);
		integer.forEach(System.out::println);
	}

}
