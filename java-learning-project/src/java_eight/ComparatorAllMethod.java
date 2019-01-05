package java_eight;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

/**
 * @author Vinod Lakhani
 *
 */
public class ComparatorAllMethod {

	public static void main(String[] args) {

		List<User> user = User.createUser();

		// Comparator.comparing with age
		user.stream()
			.sorted(Comparator.comparing(User::getAge))
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with age and then reversed
		user.stream()
			.sorted(Comparator	.comparing(User::getAge)
								.reversed())
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with age and then with name
		// we can chain thenComparing many times
		user.stream()
			.sorted(Comparator	.comparing(User::getAge)
								.thenComparing(User::getName))
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with age and second argument can be
		// Comparator.naturalOrder
		user.stream()
			.sorted(Comparator.comparing(User::getAge, Comparator.naturalOrder()))
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with age and second argument can be
		// Comparator.reverseOrder
		user.stream()
			.sorted(Comparator.comparing(User::getAge, Comparator.reverseOrder()))
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with salary and second argument can be
		// Comparator.nullsFirst(BigDecimal::compareTo)
		user.stream()
			.sorted(
				Comparator.comparing(User::getSalary, Comparator.nullsFirst(BigDecimal::compareTo)))
			.forEach(System.out::println);
		System.out.println();

		// Comparator.comparing with salary and second argument can be
		// Comparator.nullsLast(BigDecimal::compareTo)
		user.stream()
			.sorted(
				Comparator.comparing(User::getSalary, Comparator.nullsLast(BigDecimal::compareTo)))
			.forEach(System.out::println);
		System.out.println();
	}
}

/*
 * 
 * user.stream()
 * .map(User::getAge)
 * .sorted()
 * .forEach(System.out::println);
 * System.out.println();
 * 
 * .sorted(Comparator.naturalOrder())
 * .sorted(Comparator.reverseOrder())
 * 
 */
