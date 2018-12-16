package java_eight;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 *
 */
public class ComparatorExp {

	public static void main(String[] args) {

		List<User> personList = User.createUser();
		System.out.println("\n--------------------------");
		personList.sort(sortByAge());
		personList.forEach(System.out::println);
		System.out.println("\n--------------------------");
		personList.sort(sortBySalary().reversed());
		personList.forEach(System.out::println);
		System.out.println("\n--------------------------");
		personList.sort(sortByName());
		personList.forEach(System.out::println);
		System.out.println("\n--------------------------");
		List<User> list = newList(personList, "vinod");
		list.forEach(System.out::println);
		System.out.println("\n--------------------------");
		System.out.println(findByName(personList, "deepa"));
		System.out.println("\n--------------------------");
		System.out.println(findName(personList, "lavina"));
		System.out.println("\n--------------------------");
		List<String> findOnlyName = findOnlyName(personList);
		findOnlyName.forEach(System.out::println);

	}

	private static List<String> findOnlyName(List<User> personList) {
		return personList	.stream()
							.map(User::getName)// convert person to string
							.collect(Collectors.toList());// collect all name
	}

	private static String findName(List<User> personList, String name) {
		return personList	.stream()
							.filter(p1 -> p1.getName()
											.equalsIgnoreCase(name))
							.map(User::getName)// convert person to string
							.findAny()
							.orElse(null);
	}

	private static User findByName(List<User> personList, String name) {
		return personList	.stream()
							.filter(p1 -> p1.getName()
											.equalsIgnoreCase(name))
							.findAny()
							.orElse(null);
	}

	private static List<User> newList(List<User> personList, String name) {
		return personList	.stream()
							.filter(p1 -> !p1	.getName()
												.equalsIgnoreCase(name))
							.collect(Collectors.toList());
	}

	private static Comparator<User> sortBySalary() {
		return (p1, p2) -> p1	.getSalary()
								.compareTo(p2.getSalary());
	}
	private static Comparator<User> sortByAge() {
		return (p1, p2) -> p1	.getAge()
								.compareTo(p2.getAge());
	}
	private static Comparator<User> sortByName() {
		return (p1, p2) -> p1	.getName()
								.compareTo(p2.getName());
	}
}