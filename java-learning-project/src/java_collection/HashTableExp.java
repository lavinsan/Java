package java_collection;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Vinod Lakhani
 */
public class HashTableExp {

	public static void main(String[] args) {

		Hashtable<Integer, String> table = new Hashtable<>();

		table.put(1, "vinod");
		table.put(2, "Deepa");
		table.put(3, "lavin");
		table.put(3, "lavina");
		table.put(4, "mohini");
		table.put(5, "prakesh");

		System.out.println("Is Empty : " + table.isEmpty());
		System.out.println("Size is : " + table.size() + "\n");

		Enumeration<Integer> keys = table.keys();
		while (keys.hasMoreElements()) {
			Integer key = keys.nextElement();
			System.out.println("Value of " + key + " is: " + table.get(key));
		}

		Iterator<Map.Entry<Integer, String>> iterator =
			table	.entrySet()
					.iterator();

		while (iterator.hasNext()) {
			Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

		table.clear();
		System.out.println();

		table.put(1, "lavina");
		table.put(2, "mohini");
		table.put(3, "prakesh");

		for (Entry<Integer, String> entry : table.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
}
