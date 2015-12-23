package thread;

public class ThreadDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*A a = new A();
		Thread t1 = new Thread(a);
		t1.start();*/
		MyThread t = new MyThread();
		t.start();
		for(int i = 1;i<=10;i++){
			try {
				//t.sleep(1000);
				//Thread.sleep(1000);
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("world");
		}
		

	}

}
class A implements Runnable{
	public void run() {
		for(;;){
			System.out.println("hello");
		}
	}
}
class MyThread extends Thread{
	@Override
	public void run() {
	   for(int i = 1; i<= 10;i++){
		   try {
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   System.out.println("hello");
	   }
	}
}
