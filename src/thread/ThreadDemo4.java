package thread;

import java.util.Random;

public class ThreadDemo4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Business2 business = new Business2();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i= 1; i <= 50;i++)
				business.send();
			}
		}).start();
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i= 1; i <= 50;i++)
				business.rec();
			}
		});
	
		t1.start();
         new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i= 1; i <= 50;i++)
				business.sub();
			}
		}).start();
	}

}
class Business2{
	private int flag=1;
	
	public void send(){
			synchronized (this) {
				while(flag!=1){
					try {
					  this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= 10;i++){
					System.out.println("t1线程循环"+i+"次");
				}
				flag = 2;
				this.notifyAll();
				
			}
		
	}
	public void rec(){
			synchronized (this) {
				while(flag!=2){
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				for(int i = 1; i <= 20;i++){
					System.out.println("t2线程循环"+i+"次");
				}
				flag = 3;
				this.notifyAll();
			}
		}
	public void sub(){
		synchronized (this) {
			while(flag!=3){
				try {
					this.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			for(int i = 1; i <= 30;i++){
				System.out.println("t3线程循环"+i+"次");
			}
			flag = 1;
			this.notifyAll();
		}
	}

}
