package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadDemo3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Output output = new Output();
		final Output output1 = new Output();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					output.print2("helloworld");
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					output.print2("BYE-BYE");
				}
			}
		}).start();
	}

}

class Output {
	private Lock lock = new ReentrantLock();
	public static synchronized void print(String name) {

		for (int i = 0; i < name.length(); i++) {
			System.out.print(name.charAt(i));
		}
		System.out.println();

	}
	public  void print1(String name) {

		synchronized (Output.class) {
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}

	}
	public  void print2(String name) {
		lock.lock();
		try{
			for (int i = 0; i < name.length(); i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
		}finally{
			lock.unlock();
		}
	}

}
