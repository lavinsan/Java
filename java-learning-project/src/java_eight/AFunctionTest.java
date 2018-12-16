package java_eight;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author Vinod Lakhani
 * 
 *         Function<T,R> -> Used for doing some operation and return that value
 *         Function<T,R> -> <T>Take input and <R>return anything.
 *         BiFunction<T,U,R> -> <T,U>Take two input and <R>return anything.
 *         SAM -> public abstract R apply(T t)
 *         Default -> andThen , compose (reverse apply)
 *         Static -> identity
 */
public class AFunctionTest {
	public static void main(String[] args) {

		Function<Integer, Integer> f = v -> v * 2;
		System.out.println("\tFunction " + f.apply(10));

		BiFunction<Integer, Integer, Integer> bf = (a, b) -> (a + b) * 2;
		System.out.println("\tBiFunction " + bf.apply(10, 20));

		int[] number = {5, 20, 15, 10, 45, 42, 58, 51, 60, 12};

		Function<Integer, Integer> f1 = v -> v * v;
		Function<Integer, Integer> f2 = v -> v + v;

		// first f1 then f2 function will solved
		System.out.println("\tFor andThen Method ");
		for (int num : number) {
			System.out.println(f1	.andThen(f2)
									.apply(num));
		}
		// first f2 then f1 function will solved
		System.out.println("\tFor compose Method ");
		for (int num : number) {
			System.out.println(f1	.compose(f2)
									.apply(num));
		}
	}

}

/*
 * R apply(T t);
 * 
 * default <V> Function<V, R> compose(Function<? super V, ? extends T> before) {
 * Objects.requireNonNull(before);
 * return (V v) -> apply(before.apply(v));
 * }
 * 
 * default <V> Function<T, V> andThen(Function<? super R, ? extends V> after) {
 * Objects.requireNonNull(after);
 * return (T t) -> after.apply(apply(t));
 * }
 * 
 * 
 * static <T> Function<T, T> identity() {
 * return t -> t;
 * }
 */
