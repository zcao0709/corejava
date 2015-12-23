package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo6 {
	public static void main(String[] args) {
		ExecutorService threadPool = Executors.newFixedThreadPool(3);
		for (int i = 1; i <= 10; i++) {
			final int task = i;
			threadPool.execute(new Runnable() {

				@Override
				public void run() {
					for (int j = 1; j <= 10; j++) {
						System.out.println(Thread.currentThread().getName()
								+ "在处理第" + task + "个任务的第" + j + "次循环");
					}
				}
			});
		}
	}

}
