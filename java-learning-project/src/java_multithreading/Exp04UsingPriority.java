package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Defining Thread Priority
 *         The numeric value is between 1 to 10 and if u give any
 *         value outside of the range then we will get exception
 *         java.lang.IllegalArgumentException is runtime exception
 */
public class Exp04UsingPriority {

	public static void main(String[] args) {

		Thread t1 = new Thread(new RunnableRunnerp(), "Thread-1");
		Thread t2 = new Thread(new RunnableRunnerp(), "Thread-2");

		t1.setPriority(Thread.MIN_PRIORITY);
		t2.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();

	}
}
class RunnableRunnerp implements Runnable {
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
