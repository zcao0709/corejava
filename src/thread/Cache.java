package thread;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Cache {
	private Object value;
	private HashMap hm = new HashMap();
	private ReentrantReadWriteLock rrwl = new ReentrantReadWriteLock();
	public  Object get(Object key){
		
		rrwl.readLock().lock();
		try{
		   value = hm.get(key);
		   if(value==null){
			   rrwl.readLock().unlock();
			   rrwl.writeLock().lock();
			   try{
				   if(value==null){
				   value = "...";
				   hm.put(key, value);
				   }
			   }finally{
				   rrwl.writeLock().unlock();
				   rrwl.readLock().lock();
			   }
		   }
		}finally{
			rrwl.readLock().unlock();
		}
		return value;
	}
	public static void main(String[] args) {
	  int[] a = {1,2,3};
	  System.out.println(a.getClass()==int[].class);
	  int[][] b = {{},{}};
	  System.out.println(b.getClass()==int[][].class);
	}
}
