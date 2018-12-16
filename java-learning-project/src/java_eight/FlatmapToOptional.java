package java_eight;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class FlatmapToOptional {

	public static void main(String[] args) {

		List<User> people = User.createUser();

		// stream method will convert to stream of peoples
		Stream<User> stream = people.stream();
		stream.forEach(System.out::println);

		// map method will convert one level down
		// Stream<People> to Stream<List<Integer>>
		Stream<List<Integer>> map =
			people	.stream()
					.map(p -> p.getPhone());
		map.forEach(System.out::println);

		// flatMap method will convert one level down
		// Stream<List<Integer>> to Stream<Integer>
		// so we can use filter and other method
		Stream<Integer> flatMap =
			people	.stream()
					.map(p -> p.getPhone())
					.flatMap(p -> p.stream());
		flatMap.forEach(System.out::println);

		// findAny will return optional
		Optional<Integer> findAny =
			people	.stream()
					.map(User::getPhone)
					.flatMap(Collection::stream)
					.filter(p -> p == 5)
					.findAny();

		findAny.ifPresent(System.out::println);

	}
}