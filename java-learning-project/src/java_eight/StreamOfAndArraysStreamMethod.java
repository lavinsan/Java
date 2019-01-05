package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *         Arrays.stream and Stream.of function
 *         Arrays can be transfer to streams like collections
 */
public class StreamOfAndArraysStreamMethod {

	public static void main(String[] args) {

		String[] array1 = {"Anil", "lavina", "vinod", "deepa", "mohini"};
		int[] array2 = {1, 2, 3, 4, 5, 6};

		// Array of object types return stream of object
		Stream<String> stream1 = Stream.of(array1);
		stream1.forEach(System.out::println);
		System.out.println();

		Stream<String> stream2 = Arrays.stream(array1);
		stream2.forEach(System.out::println);
		System.out.println();

		// Array of primitive types return stream of int[]
		// we can print IntStream but not Stream<int[]>
		Stream<int[]> stream3 = Stream.of(array2);
		IntStream intStream = stream3.flatMapToInt(Arrays::stream);
		intStream.forEach(System.out::println);
		System.out.println();

		// Array of primitive types return IntStream
		// so for primitive always use Arrays.stream
		IntStream stream4 = Arrays.stream(array2);
		stream4.forEach(System.out::println);
		System.out.println();

		// IntStream of method convert it into intStream
		// boxed will convert it into stream of integer
		IntStream stream5 = IntStream.of(array2);
		Stream<Integer> boxed = stream5.boxed();
		List<Integer> list = boxed.collect(Collectors.toList());
		list.forEach(System.out::println);

		Stream	.of(array1)
				.sorted()
				.findFirst()
				.ifPresent(System.out::print);
		System.out.println();

		Stream	.of("lavina", "vinod", "deepa", "mohini")
				.sorted()
				.findFirst()
				.ifPresent(System.out::print);
		System.out.println();

		Stream	.of(new String[]{"lavina", "vinod", "deepa", "mohini"})
				.filter(x -> x.startsWith("l"))
				.map(String::toUpperCase)
				.forEach(System.out::println);

		Arrays	.stream(new int[]{2, 5, 7, 6, 8, 2})
				.average()
				.ifPresent(System.out::print);
		System.out.println();

	}

}
