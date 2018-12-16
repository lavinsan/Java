package java_seven;

import java.util.Arrays;
import java.util.List;

public class OddEvenExp {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println(totalValue(numbers));
		System.out.println(totalValueOfEvenNumber(numbers));
		System.out.println(totalValueOfOddNumber(numbers));
	}

	public static int totalValue(List<Integer> list) {
		int result = 0;
		for (int e : list) {
			result += e;
		}
		return result;
	}

	public static int totalValueOfEvenNumber(List<Integer> list) {
		int result = 0;
		for (int e : list) {
			if (e % 2 == 0) {
				result += e;
			}
		}
		return result;
	}

	public static int totalValueOfOddNumber(List<Integer> list) {
		int result = 0;
		for (int e : list) {
			if (e % 2 != 0) {
				result += e;
			}
		}
		return result;
	}
}
