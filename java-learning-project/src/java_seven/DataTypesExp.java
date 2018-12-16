package java_seven;

public class DataTypesExp {
	public static void main(String[] args) {

		int decimal = 2147483647; // decimal
		int octal = 0777; // octal
		int hexadecimal = 0x9fff; // Hexadecimal
		int binary = 0b0101; // binary
		int character = 'a'; // character
		
		System.out.println("Decimal form \t: = " + decimal);
		System.out.println("Octal form \t: = " + octal);
		System.out.println("Hexadecimal \t: = " + hexadecimal);
		System.out.println("Binary form \t: = " + binary);
		System.out.println("Character form \t: = " + character);
		
		double d1 = 112.111;
		double d2 = 1.2e3; // Exponential form
		System.out.println("Decimal form \t: = " + d1);
		System.out.println("Exponential \t: = " + d2);

		char c1 = 'a';
		char c2 = 97;// digit form
		System.out.println("Char form \t: = " + c1);
		System.out.println("digit form \t: = " + c2);
		
		// except character
		
		System.out.println("\'vinod\' \t \"vinod\"");
		System.out.println(12_34_567); // underscore allowed
		

	}
}
