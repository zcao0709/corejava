package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean implements InvocationHandler {
	private Object target;// 目标对象

	// 代理对象生成之后任何方法的调用都会被invoke方法拦截
	// targetProxy.f();
	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// 权限、日志、事务
	
		System.out.println("权限、日志、事务");
		method.invoke(target, args);// 调用目标方法
		System.out.println("日志事务");
		return null;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

}
