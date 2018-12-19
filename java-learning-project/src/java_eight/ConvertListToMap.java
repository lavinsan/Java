package java_eight;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 */
public class ConvertListToMap {

	public static void main(String[] args) {

		List<User> createUser = User.createUser();
		createUser.forEach(System.out::println);
		System.out.println();

		// converting list to map with Id as keys and Users as value
		Map<Integer, User> map1 =
			createUser	.stream()
						.collect(Collectors.toMap(User::getId, user -> user));
		map1.entrySet()
			.forEach(System.out::println);
		System.out.println();

		// converting list to map with Id as keys and names as value
		Map<Integer, String> map2 =
			createUser	.stream()
						.collect(Collectors.toMap(User::getId, User::getName));
		map2.entrySet()
			.forEach(System.out::println);
		System.out.println();

		// converting list to map with Name as keys and Age as value
		// but we will get error IllegalStateException : Duplicate key 16
		// cause name is key and has duplicates values but error is confusing
		// To solve duplicated key issue we pass third mergeFunction argument
		// oldValue will print 16 and newValue will print 17
		// so mergeFunction will take 2 input and 1 output we decide we want.
		Map<String, Integer> map3 =
			createUser	.stream()
						.collect(Collectors.toMap(User::getName, User::getAge,
							(oldValue, newValue) -> oldValue));
		map3.entrySet()
			.forEach(System.out::println);
		System.out.println();

		// we sorted the list in reversed order so now oldValue changed
		// and we passed fourth argument in toMap method
		// which gives new LinkedHashMap in order we wanted
		LinkedHashMap<String, Integer> map4 =
			createUser	.stream()
						.sorted(Comparator	.comparingInt(User::getId)
											.reversed())
						.collect(Collectors.toMap(User::getName, User::getAge,
							(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		map4.entrySet()
			.forEach(System.out::println);
		System.out.println();
	}
}
