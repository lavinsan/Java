package java_eight;

import java.util.List;

/**
 * @author Vinod Lakhani
 *         Matching with predicate conditions using three methods
 *         defined on the Streams API which are – allMatch(),
 *         anyMatch() and noneMatch().
 */

public class MatchingWithStream {

	public static void main(String[] args) {

		List<User> list = User.createUser();

		boolean allMatch =
			list.stream()
				.allMatch(age -> age.getAge() > 21);
		System.out.println(allMatch);

		boolean anyMatch =
			list.stream()
				.anyMatch(age -> age.getAge() == 21);
		System.out.println(anyMatch);

		boolean noneMatch =
			list.stream()
				.noneMatch(age -> age.getAge() < 21);
		System.out.println(noneMatch);
	}

}
