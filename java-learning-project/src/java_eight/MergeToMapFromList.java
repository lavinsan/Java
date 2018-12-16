package java_eight;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 *
 */
public class MergeToMapFromList {

	public static void main(String[] args) {

		List<User> createUser = User.createUser();

		// converting list to map
		Map<Integer, User> map =
			createUser	.stream()
						.collect(Collectors.toMap(User::getId, user -> user));
		map	.entrySet()
			.forEach(System.out::println);
	}
}
