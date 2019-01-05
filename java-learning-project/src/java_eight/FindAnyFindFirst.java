package java_eight;

import java.util.List;
import java.util.Optional;

/**
 * @author Vinod Lakhani
 *         findAny, findFirst methods return optional
 */
public class FindAnyFindFirst {

	public static void main(String[] args) {

		List<User> list = User.createUser();

		Optional<User> findFirst =
			list.stream()
				.filter(age -> age.getAge() < 25)
				.findFirst();
		findFirst.ifPresent(System.out::println);

		Optional<User> findAny =
			list.stream()
				.filter(age -> age.getAge() > 25)
				.findAny();
		findAny.ifPresent(System.out::println);

	}

}
