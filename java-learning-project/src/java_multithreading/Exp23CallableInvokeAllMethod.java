package java_multithreading;

import java.util.ArrayList;
import java.util.List;
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
public class Exp23CallableInvokeAllMethod {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = null;
		List<Future<Integer>> future = null;

		List<Callable<Integer>> list = new ArrayList<>();
		list.add(new InCallable(1000));
		list.add(new InCallable(1500));
		list.add(new InCallable(2000));

		try {
			service = Executors.newFixedThreadPool(3);
			future = service.invokeAll(list);
			for (Future<Integer> futures : future) {
				System.out.println(futures.get());
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		service.shutdown();
		service.awaitTermination(5, TimeUnit.MINUTES);
	}
}

class InCallable implements Callable<Integer> {

	Integer number;
	public InCallable(Integer number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		Thread.sleep(number);
		return number;
	}
}