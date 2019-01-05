package java_eight;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamToArray {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("vin", "vinod", "lavina", "deepa", "mohini");
		
		// list convert to array
		// if we print direct we get address of array
		String[] array1 = list.toArray(new String[0]);
		System.out.println(array1);

		// list convert to stream and then to array
		Stream<String> stream = list.stream();
		String[] array2 = stream.toArray(a -> new String[a]);

		// Arrays.toString method to print array values
		String string = Arrays.toString(array2);
		System.out.println(string);

	}

}
