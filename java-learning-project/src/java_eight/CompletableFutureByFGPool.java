package java_eight;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureByFGPool {

	public static void main(String[] args) throws Exception {

		CompletableFuture<String> future =
			CompletableFuture	.supplyAsync(() -> getDataById(10))
								.thenApply(data -> sendData(data));
		System.out.println("No Waiting : " + Thread	.currentThread()
													.getName());
		future.get();
	}

	private static String sendData(String data) {
		System.out.println("SendData : " + Thread	.currentThread()
													.getName()
			+ " : \n" + data);
		return data;
	}

	private static String getDataById(int id) {
		System.out.println("GetDataById : " + Thread.currentThread()
													.getName()
			+ " : " + id);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Data is : " + id;
	}
}

/*
 * Main thread starts executing the code and when it reaches to
 * supplyAsync() then supplyAsync() takes new thread from
 * ForkJoinPool.commonPool() to executes its function asynchronously.
 * thenApply() will execute either by main thread or the thread
 * used by supplyAsync(). If the supplier of supplyAsync() is
 * taking longer time then thenApply() will be executed by
 * thread used by supplyAsync() and hence main thread will not
 * be blocked. To understand this, change the getDataById()
 * method by giving sleep of 1000 millisecond.
 */