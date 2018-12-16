package java_multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Vinod Lakhani
 *
 */
public class Exp15UsingSynchronizedBlock {

	public static void main(String[] args) throws InterruptedException {
		new synBlock().doProcess();
	}

}

class synBlock extends Thread {

	Random random = new Random();
	List<Integer> list1 = new ArrayList<>();
	List<Integer> list2 = new ArrayList<>();

	Object lock1 = new Object();
	Object lock2 = new Object();
	
	public void doProcess() throws InterruptedException {

		long start = System.currentTimeMillis();
		Thread t1 = new Thread() {
			@Override
			public void run() {
				process();
			}
		};
		Thread t2 = new Thread() {
			@Override
			public void run() {
				process();
			}
		};

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		long end = System.currentTimeMillis();

		System.out.println("List one : \t" + list1.size());
		System.out.println("List two : \t" + list2.size());
		System.out.println("Total Time taken : " + (end - start));

	}

	private void process() {
		for (int i = 0; i < 1000; i++) {
			stageOne();
			stageTwo();
		}
	}

	private void stageOne() {
		synchronized (lock1) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list1.add(random.nextInt());
		}
	}

	private void stageTwo() {
		synchronized (lock2) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list2.add(random.nextInt());
		}
	}
}