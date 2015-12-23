package reflect;

import java.lang.reflect.Field;

public class FieldDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		U u = new U("zhangsan", 30);
		
       try {
		changeValue(u);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       System.out.println(u.getName()+","+u.getAge());
	}
	/**
	 * 把obj中的字符串属性全部大写，数字属性都加100
	 * @param obj
	 */
	public static void changeValue(Object obj)throws Exception{
		Class c = obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			if(field.getType()==String.class){
				field.setAccessible(true);
				String oldValue =(String) field.get(obj);
				field.set(obj, oldValue.toUpperCase());
			}
			if(field.getType()==int.class){
				field.setAccessible(true);
				int oldValue = (Integer)field.get(obj);
				field.set(obj, oldValue+100);
			}
		}
	}

}
class U{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public U(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	public U() {
		// TODO Auto-generated constructor stub
	}
}
