package org.jvm;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JButton;

public class ClassDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printClassMsg(new JButton());

	}
	public static void printClassMsg(Object obj){
		Class c = obj.getClass();
		System.out.println("类的名称是:"+c.getName());
		Method[] ms = c.getMethods();//c.getDeclaredMethods()
		for (Method method : ms) {
			Class returnType = method.getReturnType();
			System.out.print(returnType.getSimpleName()+"  "+method.getName()+"(");
			Class[] paramTypes = method.getParameterTypes();
			for (Class class1 : paramTypes) {
				System.out.print(class1.getName()+",");
			}
			System.out.print(")");
			System.out.println();
		}
		System.out.println("=========================");
		Field[] fs = c.getDeclaredFields();//c.getFields()
		for (Field field : fs) {
			System.out.println(field.getType().getName()+","+field.getName());
		}
	}

}
