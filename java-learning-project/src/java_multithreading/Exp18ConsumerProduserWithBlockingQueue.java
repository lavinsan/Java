package java_multithreading;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp18ConsumerProduserWithBlockingQueue {

	public static void main(String[] args) throws InterruptedException {
		BlockingQueue<Integer> sharedQueue = new ArrayBlockingQueue<>(10);

		Producer1 p = new Producer1(sharedQueue);
		Consumer1 c = new Consumer1(sharedQueue);

		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		t1.start();
		t2.start();

	}

}

class Producer1 implements Runnable {
	private BlockingQueue<Integer> sharedQueue;
	Random random = new Random();
	public Producer1(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1000);
				int value = random.nextInt(100);
				sharedQueue.put(value);
				System.out.println("Produced : " + value + " Size : "
						+ sharedQueue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}

class Consumer1 implements Runnable {
	private BlockingQueue<Integer> sharedQueue;
	Random random = new Random();
	public Consumer1(BlockingQueue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {

		while (true) {
			try {
				Thread.sleep(1100);
				int value = sharedQueue.take();
				System.out.println("Consumed : " + value + " Size : "
						+ sharedQueue.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}