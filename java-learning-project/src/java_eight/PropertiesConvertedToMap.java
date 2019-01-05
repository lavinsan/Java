package java_eight;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PropertiesConvertedToMap {

	public static void main(String[] args) {

		Properties properties = System.getProperties();

		// Print all properties together in one line
		Set<Map.Entry<Object, Object>> zeroStep = properties.entrySet();
		System.out.println(zeroStep);
		System.out.println();

		// Print reference only so we have to collect it to map
		Stream<Entry<Object, Object>> firstStep =
			properties	.entrySet()
						.stream();
		System.out.println(firstStep);
		System.out.println();

		// Now we can print properties and value but sorting is not possible
		// we have to convert it to map of string , string
		Map<Object, Object> secondStep =
			properties	.entrySet()
						.stream()
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		secondStep.forEach((a, b) -> System.out.println(a + "  --- >\t: " + b));
		System.out.println();

		// We can convert to string by type casting in toMap method
		Map<String, String> thirdStep =
			properties	.entrySet()
						.stream()
						.collect(
							Collectors.toMap(k -> (String) k.getKey(), e -> (String) e.getValue()));
		thirdStep.forEach((a, b) -> System.out.println(a + "  --- >\t: " + b));
		System.out.println();

		// Now sorting is possible so we have done sorting by keys but then we
		// have to use again toMap method to transfer to another linkedHashMap
		// to maintain the order else order is not maintain in hashMap
		LinkedHashMap<String, String> finalStep =
			thirdStep	.entrySet()
						.stream()
						.sorted(Map.Entry.comparingByKey())
						.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
							(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		finalStep.forEach((a, b) -> System.out.println(a + "  --- >\t: " + b));
		System.out.println();

	}

}
