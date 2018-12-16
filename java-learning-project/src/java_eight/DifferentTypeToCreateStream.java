package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class DifferentTypeToCreateStream {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

		Stream<String> stream1 = Stream.empty();
		stream1.forEach(System.out::println);

		// stream.of function return stream of list of integers
		// so we have to use flatMap to go inside of list by passing Function
		Stream<Integer> stream2 =
			Stream	.of(list)
					.flatMap(List::stream)
					.filter(a -> a > 5);
		stream2.forEach(System.out::println);

		// list.stream give us stream of integers
		Stream<Integer> stream3 =
			list.stream()
				.filter(a -> a > 5);
		stream3.forEach(System.out::println);

		// Arrays.stream takes 3 arguments array, start , end -1
		Stream<Integer> stream4 = Arrays.stream((Integer[]) list.toArray(), 1, 4);
		stream4.forEach(System.out::println);

		// Builder method is used to build streams
		Stream<Object> stream5 =
			Stream	.builder()
					.add(11)
					.add(10)
					.add(12)
					.build();

		stream5.forEach(System.out::println);

		// Generate method can be used to generate lot of things
		Stream<Integer> stream6 =
			Stream	.generate(() -> ((int) (Math.random() * 10) + 10))
					.limit(5);
		stream6.forEach(System.out::println);

		// Iterate method is used for iteration
		Stream<Integer> stream7 =
			Stream	.iterate(1, a -> a + 1)
					.limit(10);
		stream7.forEach(System.out::println);
		
		// use of streams
		IntStream stream8 = IntStream.range(1, 5);
		stream8.forEach(System.out::println);

		LongStream stream9 = LongStream.rangeClosed(1, 10);
		stream9.forEach(System.out::println);
		
		Random random = new Random();
		DoubleStream stream10 = random.doubles(5);
		stream10.forEach(System.out::println);
		
		
		
	}

}
