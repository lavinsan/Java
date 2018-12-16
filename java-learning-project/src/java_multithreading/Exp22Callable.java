package java_multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp22Callable {

	public static void main(String[] args) throws InterruptedException {

		MyCallable task = new MyCallable(5);

		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<Integer> future = es.submit(task);
		Thread.sleep(100);
		if (future.isDone()) {
			try {
				System.out.println(future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		es.shutdown();
		es.awaitTermination(5, TimeUnit.MINUTES);

	}
}

class MyCallable implements Callable<Integer> {

	Integer number;
	public MyCallable(Integer number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		Integer sum = 0;
		for (int i = 1; i <= number; i++) {
			sum = sum + i;
		}
		return sum;
	}
}