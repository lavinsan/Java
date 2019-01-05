package java_arrays;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class ArrayDuplicteValue {

	public static void main(String[] args) {
		int[] array = {10, 15, 10, 50, 100, 50, 100, 100, 102, 50};
		Arrays.sort(array);
		findDuplicate01(array);
		System.out.println();
		findDuplicate02(array);
		
	}

	private static void findDuplicate01(int[] array) {
		Set<Integer> set = new LinkedHashSet<>();
		for (Integer integer : array) {
			if (!set.add(integer)) {
				System.out.println(integer);
			}
		}
		System.out.println(set);
	}

	private static void findDuplicate02(int[] array) {
		Map<Integer, Integer> map = new LinkedHashMap<>();
		int value = 1;
		for (int i : array) {
			
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}else {
				map.put(i, value);
			}
			
			
		/*	Integer put = map.put(i, value);
			if (put != null) {
				map.replace(i, ++put);
			}*/
		}
		System.out.println(map);
	}
}
