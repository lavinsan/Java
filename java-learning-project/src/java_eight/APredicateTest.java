package java_eight;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

/**
 * @author Vinod Lakhani
 *         Predicate -> Used for conditional checks
 *         Predicate<T> -> Take input and return Boolean
 *         BiPredicate<T,U> -> Take two input and return Boolean
 *         SAM -> public abstract boolean test(T t)
 *         Default -> and , or, negate
 *         Static -> isEqual(Object o)
 */
public class APredicateTest {

	public static void main(String[] args) {

		Predicate<Integer> p = v -> v % 2 == 0;
		System.out.println("\tPredicate : " + p.test(10));

		BiPredicate<Integer, Integer> bp = (a, b) -> (a + b) % 2 == 0;
		System.out.println("\tBiPredicate : " + bp.test(10, 20));

		System.out.println();
		int[] number = {5, 20, 15, 10, 45, 42, 58, 51, 60, 12};

		Predicate<Integer> p1 = v -> v % 2 == 0;
		Predicate<Integer> p2 = v -> v > 25;

		System.out.println("\tFor And Method ");
		for (int num : number) {
			if (p1	.and(p2)
					.test(num)) {
				System.out.println(num);
			}
		}

		System.out.println("\tFor Or Method ");
		for (int num : number) {
			if (p1	.or(p2)
					.test(num)) {
				System.out.println(num);
			}
		}

		System.out.println("\tFor negate Method ");
		for (int num : number) {
			if (p1	.negate()
					.test(num)) {
				System.out.println(num);
			}
		}
	}

}

/*
 * boolean test(T t);
 * 
 * default Predicate<T> and(Predicate<? super T> other) {
 * Objects.requireNonNull(other);
 * return (t) -> test(t) && other.test(t);
 * }
 * 
 * default Predicate<T> negate() {
 * return (t) -> !test(t);
 * }
 * 
 * default Predicate<T> or(Predicate<? super T> other) {
 * Objects.requireNonNull(other);
 * return (t) -> test(t) || other.test(t);
 * }
 * 
 * static <T> Predicate<T> isEqual(Object targetRef) {
 * return (null == targetRef)
 * ? Objects::isNull
 * : object -> targetRef.equals(object);}
 * 
 * public class PredicateFunctionExample{
 * public static void main(String args[]){
 * Predicate<Integer> positive = i -> i > 0;
 * List<Integer> integerList = Arrays.asList(
 * new Integer(1),new Integer(10),
 * new Integer(200),new Integer(101),
 * new Integer(-10),new Integer(0));
 * List<Integer> filteredList = filterList(integerList, positive);
 * filteredList.forEach(System.out::println);
 * }
 * public static List<Integer> filterList(List<Integer> listOfIntegers,
 * Predicate<Integer> predicate){
 * List<Integer> filteredList = new ArrayList<Integer>();
 * for(Integer integer:listOfIntegers){
 * if(predicate.test(integer)){
 * filteredList.add(integer);
 * }
 * }
 * return filteredList;
 * }
 * }
 */
