package org.jvm;

public class LoaderTest {
	public static void main(String[] args) {
		//class type 类类型  Class
	/*	A a1 = new A();
		Class c1 = A.class;
		Class c2 = a1.getClass();//如果是子类的对象得到的是子类的类类型
		try {
			Class c3 = Class.forName("org.jvm.A");
			System.out.println(c1==c2);
			System.out.println(c2==c3);
			
			A aa = (A)c1.newInstance();
			aa.f();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		System.out.println("hello");
		System.out.println(LoaderTest.class.getClassLoader().getClass().getName());
	    System.out.println(LoaderTest.class.getClassLoader().getParent().getClass().getName());
	    System.out.println(LoaderTest.class.getClassLoader().getParent().getParent());
        System.out.println(String.class.getClassLoader());
	    System.out.println("bye-bye");
	}

}
class A{
	public void f(){
		System.out.println("helloworld");
	}
}
