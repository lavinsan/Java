package java_eight;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumber {

	private static final List<Integer> LIST = new ArrayList<>();
	static {
		IntStream	.rangeClosed('0', '9')
					.forEach(LIST::add);
		IntStream	.rangeClosed('a', 'z')
					.forEach(LIST::add);
		IntStream	.rangeClosed('A', 'Z')
					.forEach(LIST::add);
		IntStream	.rangeClosed('!', '*')
					.forEach(LIST::add);
	}
	static Random random = new Random();

	public static void main(String[] args) {
		randomInts();
		randomSecure();
		randomMath();

		for (int i = 0; i < 1; i++) {
			System.out.println(random.nextInt());
			System.out.println(random.nextInt(100));
			System.out.println(random.nextLong());
			System.out.println(random.nextBoolean());
			System.out.println(random.nextFloat());
			System.out.println(random.nextDouble());
			System.out.println(random.nextGaussian());
		}
	}

	private static void randomMath() {
		for (int i = 0; i < 5; i++) {
			System.out.println((int) (Math.random() * 100) + 10);
		}
	}

	private static void randomInts() {
		for (int i = 0; i < 5; i++) {
			random	.ints(8, 0, LIST.size())
					.map(LIST::get)
					.forEach(s -> System.out.print((char) s));
			System.out.println();
		}
	}

	private static void randomSecure() {
		SecureRandom random = new SecureRandom();
		for (int i = 0; i < 5; i++) {
			random	.ints(8, 0, LIST.size())
					.map(LIST::get)
					.forEach(s -> System.out.print((char) s));
			System.out.println();
		}
	}
}
