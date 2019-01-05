package java_eight;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertStringToChar {

	public static void main(String[] args) {
		String name = "Vinod Lakhani";
		// chars method will return intStream so we get int value
		IntStream chars = name.chars();
		// we will convert it to char with mapToObj method
		Stream<Character> mapToObj = chars.mapToObj(c -> (char) c);
		mapToObj.forEach(System.out::println);
	}

}
