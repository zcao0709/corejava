package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		A a1 = new A();
		Class c = a1.getClass();
		try {
			Method m = c.getMethod("f", int.class,int.class);
		
		    a1.f(10, 10);
		    
		    m.invoke(a1, 10,10);
		    
		    Method m1 = c.getMethod("f", int[].class);
		    
		    a1.f(new int[]{1,2,});
		    m1.invoke(a1, new int[]{1,2});
		    
		    Field f = c.getDeclaredField("i");
		    f.setAccessible(true);
		    System.out.println(f.get(a1));
		    f.set(a1, 1000);
		    System.out.println(a1.getI());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
//		System.out.println(a1.add(new int[]{}));
//		System.out.println(a1.add(new int[]{1,2,3}));
//		System.out.println(a1.add());
//		System.out.println(a1.add(1));
//		System.out.println(a1.add(1,23));
	}

}
class A{
	private int i = 11;
	public int getI() {
		return i;
	}
	public void f(int a,int b){
		System.out.println(a+","+b);
	}
	public String f(int a,String c){
		return a+","+c;
	}
	public void f(int[] a){
		for (int i : a) {
			System.out.println(i);
		}
	}
	public int add(int... a){
		int sum = 0;
		for(int i : a){
			sum+=i;
		}
		return sum;
	}
}