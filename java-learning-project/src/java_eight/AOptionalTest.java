package java_eight;

import java.util.Date;
import java.util.Optional;


/**
 * @author Vinod Lakhani
 *
 */
public class AOptionalTest {

	public static void main(String[] args) {
		Optional<String> gender = Optional.of("vinod");
		// It will give optional of object passed
		System.out.println("Optional.of(vinod)\t\t : " + gender);
		// This function return true if value is present
		System.out.println("Optional.of(vinod) isPresent\t : " + gender.isPresent());
		// get function give the object from the optional of object
		System.out.println("Optional.of(vinod) get\t\t : " + gender.get());
		// ifPresent then print else do nothing
		gender.ifPresent(
			str -> System.out.println("Optional.of(vinod) ifPresent\t : " + str.length()));
		System.out.println();

		// This function gives optional of empty
		System.out.println("Optional.empty\t\t\t : " + Optional.empty());
		// This function gives false cause its empty
		System.out.println("Optional.empty.isPresent" + "\t : " + Optional	.empty()
																			.isPresent());
		// ifPresent then print else do nothing so it will not print empty also
		Optional.empty()
				.ifPresent(str -> System.out.println("empty " + str));
		System.out.println();

		// orElse function will return value if not null else
		// it return the argument given to orElse
		System.out.println("(vinod) orElse: " + Optional.ofNullable("vin")
														.orElse("deepa"));
		System.out.println("(null) orElse : " + Optional.ofNullable(null)
														.orElse(new Date()));
		System.out.println("(null) orElseGet : " + Optional	.ofNullable(null)
															.orElseGet(() -> new Date()));
		/*
		 * System.out.println("(null) orElseThrow : " + Optional
		 * .ofNullable(null)
		 * .orElseThrow(
		 * RuntimeException::new));
		 */
		System.out.println();

		String answer1 = "vinod";
		String answer2 = null;
		// Both function will give us optional of object passed
		System.out.println("1 " + Optional.ofNullable(answer1));
		System.out.println("2 " + Optional.of(answer1));
		// ofNullable function will give optional of empty if we pass null
		System.out.println("3 " + Optional.ofNullable(answer2));
		// of function will give java.lang.NullPointerException if we pass null
		System.out.println("4 " + Optional.of(answer2));

	}
}
