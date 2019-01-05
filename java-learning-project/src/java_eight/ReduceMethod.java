package java_eight;

import java.util.List;
import java.util.Optional;

public class ReduceMethod {

	public static void main(String[] args) {
		List<Item> list = Item.createItemList();

		// .reduce(accumulator)
		Optional<Item> reduce1 =
			list.stream()
				.reduce((a, b) -> a.getQuantity() < b.getQuantity() ? a : b);
		reduce1.ifPresent(System.out::println);

		// .reduce(identity, accumulator)
		Integer reduce2 =
			list.stream()
				.map(Item::getQuantity)
				.reduce(10, (a, b) -> a + b);
		System.out.println(reduce2);

		// .reduce(identity, accumulator, combiner)
		Integer reduce3 =
			list.stream()
				.map(Item::getQuantity)
				.reduce(10, (a, b) -> a + b, (a, b) -> a * b);
		System.out.println(reduce3);
	}

}
