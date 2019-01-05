package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Vinod Lakhani
 *
 */
public class MapAndFlatMap {

	public static void main(String[] args) {

		List<User> list = User.createUser();

		Stream<String> map1 =
			list.stream()
				.map(User::getName);
		map1.forEach(System.out::println);

		// split method will convert it into stream of string array
		Stream<String[]> map2 =
			list.stream()
				.map(name -> name	.getName()
									.split(""));

		// then flatMap will convert it into stream of individual string
		// each character from words
		Stream<String> map3 =
			map2.flatMap(Arrays::stream)
				.map(String::toUpperCase);
		map3.forEach(System.out::print);

	}

}
