package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamConcatMethod {

	public static void main(String[] args) {

		Stream<Integer> stream1 = Stream.of(10, 20, 30);
		Stream<Integer> stream2 = Stream.of(40, 50, 30);
		Stream<Integer> concat1 =
			Stream	.concat(stream1, stream2)
					.distinct();
		concat1.forEach(System.out::println);

		List<Integer> list1 = Arrays.asList(10, 20, 30);
		List<Integer> list2 = Arrays.asList(40, 20, 50);
		Stream<Integer> concat2 =
			Stream	.concat(list1.stream(), list2.stream())
					.distinct();
		// List<Integer> collect = concat2.collect(Collectors.toList());
		concat2.forEach(System.out::println);

		Integer[] array1 = {10, 20, 30};
		Integer[] array2 = {50, 40, 30};
		Stream<Integer> concat3 =
			Stream	.concat(Stream.of(array1), Stream.of(array2))
					.distinct();
		Integer[] array = concat3.toArray(Integer[]::new);
		// concat3.forEach(System.out::println);
		for (Integer integer : array) {
			System.out.println(integer);
		}

	}

}
