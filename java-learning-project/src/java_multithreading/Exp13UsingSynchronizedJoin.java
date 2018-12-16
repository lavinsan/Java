package java_multithreading;

/**
 * @author Vinod Lakhani
 *         first we call 3 thread on one object and we join the thread so
 *         all thread should wait for one to complete and then we increment
 *         static value in synchronized method to get proper result.
 */
public class Exp13UsingSynchronizedJoin {

	public static void main(String[] args) throws InterruptedException {
		RunnableSyn syn = new RunnableSyn();
		Thread t1 = new Thread(syn, "Thread-1");
		Thread t2 = new Thread(syn, "Thread-2");
		Thread t3 = new Thread(syn, "Thread-3");

		t1.start();
		t2.start();
		t3.start();

		t1.join();
		t2.join();
		t3.join();

		syn.numberValue();
	}
}
class RunnableSyn implements Runnable {

	private static int number = 0;
	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			increment();
		}
	}

	public void numberValue() {
		System.out.println(number);
	}
	private synchronized void increment() {
		number++;
	}
}
