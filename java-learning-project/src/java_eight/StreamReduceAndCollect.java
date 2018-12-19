package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 */
public class StreamReduceAndCollect {

	public static void main(String[] args) {

		int[] intNumber = {3, 2, 1, 4, 7, 7, 5, 1, 4, 5};

		List<Integer> numbers = Arrays.asList(7, 8, 7, 4, 5, 9, 7, 8, 2, 3);

		Stream<String> language = Stream.of("java", "python", "node", null, "ruby", null, "php");
		List<String> result =
			language.filter(Objects::nonNull)
					.collect(Collectors.toList());
		result.forEach(System.out::println);

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

		/*
		 * 
		 * // Accumulate names into a TreeSet
		 * Set<String> set =
		 * people.stream().map(Person::getName).collect(Collectors.toCollection(
		 * TreeSet:
		 * :new));
		 * 
		 * // Convert elements to strings and concatenate them, separated by
		 * commas
		 * String joined = things.stream()
		 * .map(Object::toString)
		 * .collect(Collectors.joining(", "));
		 * 
		 * // Compute sum of salaries of employee
		 * int total = employees.stream()
		 * .collect(Collectors.summingInt(Employee::getSalary)));
		 * 
		 * 
		 * // Partition students into passing and failing
		 * Map<Boolean, List<Student>> passingFailing =
		 * students.stream()
		 * .collect(Collectors.partitioningBy(s -> s.getGrade() >=
		 * PASS_THRESHOLD));
		 * 
		 */
	}
}
