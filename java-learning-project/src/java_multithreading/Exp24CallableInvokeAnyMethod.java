package java_multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp24CallableInvokeAnyMethod {

	public static void main(String[] args) throws InterruptedException {

		ExecutorService service = null;
		Integer value = null;

		List<Callable<Integer>> list = new ArrayList<>();
		list.add(new AnyCallable(2000));
		list.add(new AnyCallable(1500));
		list.add(new AnyCallable(2000));

		try {
			service = Executors.newFixedThreadPool(3);
			value = service.invokeAny(list);
			System.out.println(value);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		service.shutdown();
		service.awaitTermination(5, TimeUnit.MINUTES);
	}
}

class AnyCallable implements Callable<Integer> {

	Integer number;
	public AnyCallable(Integer number) {
		this.number = number;
	}
	@Override
	public Integer call() throws Exception {
		Thread.sleep(number);
		return number;
	}
}