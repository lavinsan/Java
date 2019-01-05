package java_eight;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadLocalRandom;

public class RandomThreadLocal {

	public static void main(String[] args) {
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		TaskTest test1 = new TaskTest(" Task 1");
		TaskTest test2 = new TaskTest(" Task 2");
		forkJoinPool.invoke(test1);
		forkJoinPool.invoke(test2);
	}
}

class TaskTest extends ForkJoinTask<String> {

	private static final long serialVersionUID = 1L;
	private String msg = null;

	public TaskTest(String msg) {
		this.msg = msg;
	}

	@Override
	public String getRawResult() {
		return null;
	}

	@Override
	protected void setRawResult(String value) {
	}

	@Override
	protected boolean exec() {
		int nextInt =
			ThreadLocalRandom	.current()
								.nextInt(1, 10);
		System.out.println(" ThreadLocalRandom " + msg + " : " + nextInt);
		return true;
	}
}