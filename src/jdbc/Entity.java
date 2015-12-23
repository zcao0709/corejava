package jdbc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解一定要声明修饰谁
@Target(ElementType.TYPE)
//注解一定要告知什么时候有效--->我们自己写的都是运行时刻有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Entity {
	String value() default "hello";
}
