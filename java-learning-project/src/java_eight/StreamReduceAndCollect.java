package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class StreamReduceAndCollect {

	public static void main(String[] args) {

		int[] intNumber = {3, 2, 1, 4, 7, 7, 5, 1, 4, 5};

		List<Integer> numbers = Arrays.asList(7, 8, 7, 4, 5, 9, 7, 8, 2, 3);

		Arrays.sort(intNumber);

		// converting int array to list of type integer.
		// boxed method will boxed int to integer
		// collectors.tolist will convert to list
		List<Integer> list =
			Arrays	.stream(intNumber)
					.boxed()
					.collect(Collectors.toList());
		System.out.println(list);

		numbers	.stream()
				.mapToInt(e -> e)
				.average()
				.getAsDouble();

		// convert to list and check for number exists or not
		System.out.println(list	.stream()
								.anyMatch(x -> x == 7));

		// check for number exists or not without converting to list
		System.out.println(IntStream.of(intNumber)
									.anyMatch(x -> x == 4));

		// Arrays.stream and Stream.of function are doing same things
		Stream	.of("lavina", "vinod", "deepa", "mohini")
				.sorted()
				.findFirst()
				.ifPresent(System.out::print);
		System.out.println();

		Stream	.of("lavina", "vinod", "deepa", "mohini")
				.sorted()
				.forEach(System.out::print);
		System.out.println();

		String[] array = {"Anil", "lavina", "vinod", "deepa", "mohini"};
		Stream	.of(array)
				.sorted()
				.findFirst()
				.ifPresent(System.out::print);
		System.out.println();

		Arrays	.stream(new int[]{2, 5, 7, 6, 8, 2})
				.average()
				.ifPresent(System.out::print);
		System.out.println();

		Stream	.of("lavina", "vinod", "deepa", "mohini", "laviya")
				.filter(x -> x.startsWith("l"))
				.map(String::toUpperCase)
				.forEach(System.out::println);
	}
}
