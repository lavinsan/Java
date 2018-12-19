package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *         Stream<String[]> -> flatMap -> Stream<String>
 *         Stream<Set<String>> -> flatMap -> Stream<String>
 *         Stream<List<String>> -> flatMap -> Stream<String>
 *         Stream<List<Object>> -> flatMap -> Stream<Object>
 */
public class FlatmapFunction {

	public static void main(String[] args) {

		// Array.stream will convert 2d string array to stream of string array
		// flatMap will convert stream of string array to stream of strings
		// collectors.joining will convert it to single string
		// we can give joining operator we want
		String[][] array2D = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};
		Stream<String[]> array = Arrays.stream(array2D);
		Stream<String> flatMap = array.flatMap(s -> Arrays.stream(s));
		String string = flatMap.collect(Collectors.joining(", "));
		System.out.println(string);
		System.out.println();

		// Stream.of method will convert int[] array to Stream<int[]>
		// flatMap method will convert Stream<int[]> to IntStream not stream
		// IntStream intStream = Arrays.stream(intArray) directly converts
		// so we can use Arrays.stream instead to Stream.of method
		int[] intArray = {1, 2, 3, 4, 5, 6};
		Stream<int[]> streamArray = Stream.of(intArray);
		IntStream intStream = streamArray.flatMapToInt(x -> Arrays.stream(x));
		intStream.forEach(x -> System.out.println(x));
		System.out.println();

		List<User> user = User.createUser();

		// stream method will convert to stream of users
		Stream<User> stream = user.stream();
		stream.forEach(System.out::println);
		System.out.println();

		// map method will convert Stream<User> to Stream<List<Integer>>
		// cause we have list of phone number in list of Users
		Stream<List<Integer>> stream1 =
			user.stream()
				.map(p -> p.getPhone());
		stream1.forEach(System.out::println);
		System.out.println();

		// flatMap method will convert Stream<List<Integer>> to Stream<Integer>
		// so we can use filter and other method on stream of integers
		// distinct will remove the duplicate from stream
		Stream<Integer> flatMap1 =
			user.stream()
				.map(p -> p.getPhone())
				.flatMap(p -> p.stream())
				.distinct();
		flatMap1.forEach(System.out::println);

		// Method reference
		// .map(User::getPhone)
		// .flatMap(Collection::stream)
		// or we can combine map and flatMap in to single statement
		// .flatMap(p -> p .getPhone().stream())
	}
}