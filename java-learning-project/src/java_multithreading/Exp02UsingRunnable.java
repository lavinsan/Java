package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Creating Thread by implementing Runnable interface
 *         we can't restart a thread again and if we try we will get
 *         java.lang.IllegalThreadStateException its a runtime exception
 */
public class Exp02UsingRunnable {

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunnableRunner());
		Thread t2 = new Thread(new RunnableRunner(), "Thread-2");
		t1.setName("Thread-1");
		t1.start();
		t2.start();
	}
}
class RunnableRunner implements Runnable {
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
