package java_seven;
/*
 * odd and even without using % and / operator
 * 
 */


public class OddAndEven {

	public static void main(String arg[]) {
		int result = 7;
		while (result >= 2) {
			result = result - 2;
		}
		if (result == 1) {
			System.out.println("The number is odd");
		} else {
			System.out.print("The number is even");
		}
	}

}
