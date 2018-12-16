package java_eight;

import java.util.Date;
import java.util.function.Supplier;

/**
 * @author Vinod Lakhani
 * 
 *         Supplier -> Used to give output only
 *         Supplier<R> -> <R>Return anything we want.
 *         SAM -> public abstract <R> get();
 *         No default and static methods.
 */
public class ASupplierTest {
	public static void main(String[] args) {

		Supplier<Date> s = () -> new Date();
		System.out.println(s.get());

		Supplier<String> otp = () -> createOtp();
		System.out.println(otp.get());

	}

	private static String createOtp() {
		String otp = "";
		for (int i = 0; i < 10; i++) {
			otp += (int) (Math.random() * 10);
		}
		return otp;
	}

}
