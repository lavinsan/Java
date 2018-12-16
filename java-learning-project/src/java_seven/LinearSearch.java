package java_seven;

import java.util.Arrays;
import java.util.List;

public class LinearSearch {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(5, 3, 4, 2, 7, 4, 2, 8, 4, 6);
		System.out.println(searchFirst(2, list));
	}

	public static int searchFirst(int number, List<Integer> list) {
		int index = 0;
		for (int i = 0; i < list.size(); i++) {
			if (number == list.get(i)) {
				index = i;
				break;
			}
		}
		return index;
	}
}
