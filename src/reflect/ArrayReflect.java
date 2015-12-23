package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

public class ArrayReflect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = {1,2,3};
		int[][] b = {{1,2,3},{4,5,6}};
		String[][] s = {{"aa","bb"},{"cc","dd"}};
		
		Class c = a.getClass();
		System.out.println(c==int[].class);
		
		Object o = b;
		Object[] o1 = b;
		
		Object o2 = s;
		Object[] o3 = s;
		Object[][] o4 = s;
		
		Arg.main(new String[]{"hello","world"});
		
		Class cc = Arg.class;
		try {
			Object oo = new String[]{"hello","world"};
			Method m = cc.getDeclaredMethod("main", String[].class);
			m.invoke(null, oo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("==========================");
		print(s);
		
	}
	public static void print(Object obj){
		//如果obj是数组打印每个元素，否则直接打印对象
		Class c = obj.getClass();
		if(c.isArray()){
			int length = Array.getLength(obj);
			for(int i = 0 ;i < length;i++){
				Object o = Array.get(obj, i);
				System.out.println(o);
				print(o);
			}
			
		}else{
			System.out.println(obj);
		}
	}
	

}
class Arg{
	public static void main(String[] args) {
		for (String string : args) {
			System.out.println(string);
		}
	}
}
