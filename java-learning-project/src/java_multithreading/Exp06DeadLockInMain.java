
package java_multithreading;

/**
 * @author Vinod Lakhani
 *         DeadLock in Main Thread if we call join on itself
 *         join method will wait for itself to end so deadlock
 *         In deadlock we can check by using java visual vm tools in bin.
 *         Or in command prompt we can write jps -l -m to find process number
 *         then we write jstack and process number
 */
public class Exp06DeadLockInMain {

	public static void main(String[] args) throws InterruptedException {

		Thread currentThread = Thread.currentThread();

		System.out.println(currentThread.getName() + " \t Thread Started");

		currentThread.join();

		System.out.println(currentThread.getName() + " \t Thread Ended");
	}
}
