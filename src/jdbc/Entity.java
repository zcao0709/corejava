package jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//ע��һ��Ҫ��������˭
@Target(ElementType.TYPE)
//ע��һ��Ҫ��֪ʲôʱ����Ч--->�����Լ�д�Ķ�������ʱ����Ч
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	String value() default "hello";
}
