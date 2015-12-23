package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyFactoryBean implements InvocationHandler {
	private Object target;// Ŀ�����

	// �����������֮���κη����ĵ��ö��ᱻinvoke��������
	// targetProxy.f();
	public void setTarget(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		// Ȩ�ޡ���־������
	
		System.out.println("Ȩ�ޡ���־������");
		method.invoke(target, args);// ����Ŀ�귽��
		System.out.println("��־����");
		return null;
	}

	public Object getProxy() {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}

}
