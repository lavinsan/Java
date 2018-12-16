package java_collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Vinod Lakhani
 *
 */
public class LinkedListExp {

	public static void main(String[] args) {

		List<String> list = new LinkedList<>();

		list.add("vinod");
		list.add("Deepa");
		list.add("lavina");
		list.add("mohini");
		list.add("prakesh");
		list.add("lavina");

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println(list.indexOf("mohini"));

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				return o2.compareTo(o1);
			}
		});

		System.out.println(list);

	}

}
