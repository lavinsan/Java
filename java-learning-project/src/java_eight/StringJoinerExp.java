package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * @author Vinod Lakhani
 */
public class StringJoinerExp {

	public static void main(String[] args) {

		// passing comma(,) as delimiter
		StringJoiner names1 = new StringJoiner(",");
		names1.add("Rahul");
		names1.add("Raju");
		names1.add("Peter");
		System.out.println(names1);

		// passing comma(|) as delimiter
		StringJoiner names2 = new StringJoiner("|");
		names2.add("Rahul");
		names2.add("Raju");
		names2.add("Peter");
		System.out.println(names2);

		// passing comma(,) as delimiter and [ ] as prefix and suffix
		StringJoiner names3 = new StringJoiner(",", "[", "]");
		names3.add("Rahul");
		names3.add("Raju");
		names3.add("Peter");
		System.out.println(names3);

		// Merge method to merge 2 string joiner
		StringJoiner names4 = names1.merge(names2);
		System.out.println(names4);

		// SetEmptyValue method for String joiner
		StringJoiner names5 = new StringJoiner(",", "[", "]");
		names5.setEmptyValue("This is empty");
		System.out.println(names5);
		names5.add("vinod");
		names5.add("lavina");
		System.out.println(names5);

		// length method to find the length of a string
		System.out.println(names5.length());

		// join method take iterable or char sequence
		List<String> asList = Arrays.asList("vinod", "mohini", "lavina", "deepa");
		String join = String.join("|", asList);
		System.out.println(join);
		System.out.println();

		// joining method join the list with delimeter
		String collect =
			asList	.stream()
					.collect(Collectors.joining("!"));
		System.out.println(collect);

	}
}
