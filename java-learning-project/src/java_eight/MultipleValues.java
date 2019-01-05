package java_eight;

import java.util.Arrays;
import java.util.List;

public class MultipleValues {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(9, 15, 5, 3, 45, 30, 40);

		list.stream()
			.filter(num -> num % 3 == 0 && num % 5==0)
			.forEach(System.out::println);
		
		Integer number = 6;
		Integer total = 1;
		for (int i = number; i > 0 ; i--) {
			total = total * i;
		}
		System.out.println(total);
	}

}
