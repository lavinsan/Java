package java_eight;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author Vinod Lakhani
 * 
 *         Consumer<T> -> Used for printing and saving in databases
 *         Consumer<T> -> <T>Take input and no return void.
 *         BiConsumer<T,U> -> <T,U>Take input and no return void.
 *         SAM -> public abstract boolean accept(T t)
 *         Default -> andThen.
 */
public class AConsumerTest {
	public static void main(String[] args) {

		Consumer<Integer> f = v -> System.out.println(v);
		f.accept(10);

		BiConsumer<Integer, Integer> bf = (a, b) -> System.out.println(a + b);
		bf.accept(10, 20);

		Consumer<Integer> f1 = v -> System.out.println(" f1 : " + v);
		Consumer<Integer> f2 = v -> System.out.println(" f2 : " + v);

		f1	.andThen(f2)
			.accept(20);

	}

}


/*
 * void accept(T arg0);
 * 
 * default Consumer<T> andThen(Consumer<? super T> arg0) {
 * Objects.requireNonNull(arg0);
 * return (arg1) -> {
 * this.accept(arg1);
 * arg0.accept(arg1);
 * };
 */