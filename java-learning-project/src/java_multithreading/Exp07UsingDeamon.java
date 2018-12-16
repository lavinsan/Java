package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Defining Thread as Daemon may not complete full execution.
 *         Because as main thread complete all daemon thread are destroyed
 */
public class Exp07UsingDeamon {

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();
		Thread t1 = new Thread(new RunnableRunnerd(), "Thread-1");

		t1.setDaemon(true);

		System.out.println("Main Thread : " + mainThread.isDaemon());
		System.out.println("Thread 1 : " + t1.isDaemon());

		t1.start();

	}
}
class RunnableRunnerd implements Runnable {
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread	.currentThread()
										.getName()
					+ "  : " + (i + 1));
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
