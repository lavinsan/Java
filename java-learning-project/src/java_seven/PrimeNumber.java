package java_seven;
/*
 A prime number is a whole number greater than 1, 
 has only two whole-number factors are 1 and itself. 
The first few prime numbers are 2, 3, 5, 7, 11, 13, 17, 19, 23, and 29
*/

public class PrimeNumber {
	public static void main(String[] args) {
		int num = 30;
		int count;
		for (int i = 2; i < num; i++) {
			count = 0;
			for (int j = 2; j <= i / 2; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}
			if (count == 0)
				System.out.println(i);
		}
	}
}
