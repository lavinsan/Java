package java_multithreading;

/**
 * @author Vinod Lakhani
 *         Creating Thread by extending Thread class
 */
public class Exp01UsingThreadClass {

	public static void main(String[] args) {
		ThreadRunner threadRunner1 = new ThreadRunner();
		threadRunner1.setName("Thread-1");
		ThreadRunner threadRunner2 = new ThreadRunner();
		threadRunner1.setName("Thread-2");
		threadRunner1.start();
		threadRunner2.start();
	}

}
class ThreadRunner extends Thread {
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
