package java_multithreading;

/**
 * @author Vinod Lakhani
 */
public class Exp08ThreadGroup {

	public static void main(String[] args) {

		TGDemo tgDemo = new TGDemo();

		ThreadGroup tg1 = new ThreadGroup("Group 1");
		ThreadGroup tg2 = new ThreadGroup(tg1, "Group 2");

		Thread t1 = new Thread(tg1, tgDemo, " Thread 1");
		Thread t2 = new Thread(tg1, tgDemo, " Thread 2");
		Thread t3 = new Thread(tg1, tgDemo, " Thread 3");
		Thread t4 = new Thread(tg2, tgDemo, " Thread 4");
		Thread t5 = new Thread(tg2, tgDemo, " Thread 5");

		tg1.setMaxPriority(Thread.MAX_PRIORITY);
		tg2.setMaxPriority(Thread.MIN_PRIORITY);

		System.out.println("Group 1 Parent is : " + tg1	.getParent()
														.getName());
		System.out.println("Group 2 Parent is : " + tg2	.getParent()
														.getName());

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

		
		System.out.println("Group 1 Count is : " + tg1.activeCount());
		System.out.println("Group 2 Count is : " + tg2.activeCount());

		
		tg1.list();
		tg2.list();
	}
}
class TGDemo implements Runnable {
	static int count;
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread	.currentThread()
										.getThreadGroup()
										.getName()
					+ " " + Thread	.currentThread()

									.getName()
					+ "  : " + count++);
		}
	}
}
