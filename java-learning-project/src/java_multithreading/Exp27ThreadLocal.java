package java_multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp27ThreadLocal {

	public static void main(String[] args) {

		ExecutorService pool = Executors.newSingleThreadExecutor();
		pool.submit(new ThreadLocalDemo());
		pool.submit(new ThreadLocalDemo());
		pool.submit(new ThreadLocalDemo());
		pool.submit(new ThreadLocalDemo());
		pool.submit(new ThreadLocalDemo());

		pool.shutdown();

	}
}

class ThreadLocalDemo implements Runnable {

	static AtomicInteger integer = new AtomicInteger(0);

	ThreadLocal<Integer> local = ThreadLocal.withInitial(
			() -> integer.incrementAndGet());
	@Override
	public void run() {
		System.out.println(Thread	.currentThread()
									.getName()
				+ " : " + local.get());
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
