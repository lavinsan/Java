package java_collection;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author Vinod Lakhani
 */
public class LinkedHashSetExp {

	public static void main(String[] args) {

		Set<String> set = new LinkedHashSet<>();

		set.add("vinod");
		set.add("Deepa");
		set.add("lavina");
		set.add("lavina");
		set.add("mohini");
		set.add("prakesh");

		System.out.println("Set : "+set);

		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println("Is Empty : "+set.isEmpty());
		System.out.println("Size is : "+set.size());

		set.clear();

		set.add("lavina");
		set.add("mohini");
		set.add("prakesh");
		
		System.out.println("Set : "+set);
		System.out.println("Contain :  "+set.contains("lavina"));
	}
}
