package java_collection;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/**
 * @author Vinod Lakhani
 */
public class ArrayListExp {

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();
		
		list.add("vinod");
		list.add("Deepa");
		list.add("lavina");
		list.add("mohini");
		list.add("prakesh");
		list.add("lavina");

		System.out.println(list);

		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

		System.out.println(list.isEmpty());
		System.out.println(list.size());
		System.out.println(list.get(0));

		list.remove(4);
		list.add(3, "laxman");
		list.set(0, "vin");
		list.clear();
		list.add("lavina");
		list.add("mohini");
		list.add("prakesh");

		System.out.println(list.contains("lavina"));

		List<String> list1 = list.subList(0, 3);

		System.out.println(" retain " + list1.retainAll(list));

		System.out.println("\n For Loop \n");
		for (String s : list1) {
			System.out.println(s);
		}

		Vector<String> vec = new Vector<>();
		Enumeration<String> enu = vec.elements();
		ListIterator<String> listIterator = vec.listIterator();

		System.out.println(enu	.getClass()
								.getName());
		System.out.println(iterator	.getClass()
									.getName());
		System.out.println(listIterator	.getClass()
										.getName());
		
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
			listIterator.remove();
		}
	}

}
