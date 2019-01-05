package java_eight;

import java.util.Arrays;
import java.util.List;

/**
 * @author Vinod Lakhani
 *         filter(), distinct(), limit(n) and skip(n)
 */
public class FilterAndSlicOfStream {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(15, 20, 10, 14, 17, 18, 17, 19, 18, 17);
		list.stream()
			.filter(n -> n > 10)
			.sorted()
			.distinct()
			.limit(6)
			.skip(2)
			.forEach(System.out::println);
	}

}
