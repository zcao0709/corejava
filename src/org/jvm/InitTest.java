package org.jvm;

import java.lang.ref.SoftReference;

public class InitTest {
	public static void main(String[] args) {
		C c = new C();
		
		
		Object obj = new Object();
	    SoftReference srf = new SoftReference(obj);
	    obj = null;
	    srf.get();
	    
	}
}
class B{
	static{
		System.out.println("aa");
	}
	public B(){this.test();}
	public void test(){System.out.println("hello");}
}
class C extends B{
	static{
		System.out.println("bb..");
	}
	//private int i = 11;
	private int i ;
	{
		i = 11;
	}
	public void test(){System.out.println(i);}
}
