package java_collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Vinod Lakhani
 */
public class HashMapExp {

	public static void main(String[] args) {

		Map<Integer, String> map = new HashMap<>();

		map.put(1, "vinod");
		map.put(2, "Deepa");
		map.put(3, "lavin");
		map.put(3, "lavina");
		map.put(4, "mohini");
		map.put(5, "prakesh");

		System.out.println("Is Empty : " + map.isEmpty());
		System.out.println("Size is : " + map.size() + "\n");

		Iterator<Entry<Integer, String>> iterator =
			map	.entrySet()
				.iterator();

		while (iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		map.clear();
		System.out.println();
		
		map.put(1, "lavina");
		map.put(2, "mohini");
		map.put(3, "prakesh");

		for (Entry<Integer, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
