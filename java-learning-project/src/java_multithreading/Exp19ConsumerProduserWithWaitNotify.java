package java_multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp19ConsumerProduserWithWaitNotify {

	public static void main(String[] args) throws InterruptedException {

		Queue<Integer> sharedQueue = new LinkedList<>();
		Producer p = new Producer(sharedQueue);
		Consumer c = new Consumer(sharedQueue);
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(c);
		
		t1.start();
		t2.start();
	}
}

class Producer implements Runnable {
	Queue<Integer> sharedQueue;
	Random ramdom = new Random();
	public Producer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.size() == 10) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int value = ramdom.nextInt(10);
				sharedQueue.add(value);
				System.out.println("Producer : " + value);
				sharedQueue.notify();
			}
		}
	}
}

class Consumer implements Runnable {
	Queue<Integer> sharedQueue;
	Random ramdom = new Random();
	public Consumer(Queue<Integer> sharedQueue) {
		this.sharedQueue = sharedQueue;
	}
	@Override
	public void run() {
		while (true) {
			synchronized (sharedQueue) {
				while (sharedQueue.isEmpty()) {
					try {
						sharedQueue.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				int value = sharedQueue.poll();
				System.out.println("Consumer : " + value);
				sharedQueue.notify();
			}
		}
	}
}