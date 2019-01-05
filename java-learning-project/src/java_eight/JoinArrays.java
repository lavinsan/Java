package java_eight;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JoinArrays {

	public static void main(String[] args) {

		String[] s1 = {"a", "b", "c"};
		String[] s2 = {"d", "e", "f"};
		String[] s3 = {"g", "h", "i"};

		int[] int1 = {1, 2, 3};
		int[] int2 = {4, 5, 6};
		int[] int3 = {7, 8, 9};

		// stream of function will join all the arrays
		// into single array --- stream of array
		// then flatmap will convert it to stream of strings
		// by passing stream of method to flat map
		Stream<String[]> firstStringStream = Stream.of(s1, s2, s3);
		Stream<String> stream = firstStringStream.flatMap(Stream::of);
		stream.forEach(System.out::println);

		// here flatmaptoint will convert it to intstream 
		// by passing arrays stream method to flatmaptoint
		Stream<int[]> firstIntStream = Stream.of(int1, int2, int3);
		IntStream mapToInt = firstIntStream.flatMapToInt(Arrays::stream);
		mapToInt.forEach(System.out::println);
	}

}

/*
 * concat method can concat only 2 streams so we are using
 * concat method 2 times to concat 3 int arrays
 * Arrays.stream return IntStream so we are using
 * toArray method to convert it to int array
 * 
 * int[] int4 =
 * IntStream .concat(Arrays.stream(int1), Arrays.stream(int2)).toArray()
 * int[] int5 =
 * IntStream .concat(Arrays.stream(int3), Arrays.stream(int4)).toArray()
 * 
 * Object[] s4 =
 * Stream .concat(Arrays.stream(s1), Arrays.stream(s2)).toArray()
 * Object[] s5 =
 * Stream .concat(Arrays.stream(s3), Arrays.stream(s4)).toArray()
 */