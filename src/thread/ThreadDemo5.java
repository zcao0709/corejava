package thread;

import java.util.Random;

public class ThreadDemo5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Business business = new Business();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				business.send();
			}
		}).start();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				business.rec();
			}
		});
		t1.setDaemon(true);
		t1.start();
	}

}
class Business{
	private boolean flag;
	private int theValue;
	public void send(){
		for(int i = 1; i <= 5; i++){
			synchronized (this) {
				while(flag){
					try {
					  this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				theValue = new Random().nextInt(1000);
				System.out.println("send the value is:"+theValue);
				flag = true;
				this.notify();
				
			}
		}
	}
	public void rec(){
		while(true){
			synchronized (this) {
				while(!flag){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("rec the value is:"+theValue);
				flag = false;
				this.notify();
			}
		}
	}
}
