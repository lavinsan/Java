package java_seven;

import java.util.Arrays;
import java.util.List;

public class ContainNumber {

	public static void main(String[] args) {
		Integer[] a = { 3, 2, 1, 4, 7, 7, 5, 1, 4, 5 };
		Arrays.sort(a);
		List<Integer> list = Arrays.asList(a);
		System.out.println(list);
		System.out.println(list.contains(5));
	}
}
//  int array can't convert to integer so we have to use integer array
// int array can not be autobox to integer and list takes object only.