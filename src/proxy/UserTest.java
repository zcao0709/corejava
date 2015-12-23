package proxy;

public class UserTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserServcieImpl us = new UserServcieImpl();
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(us);
		UserService usProxy = (UserService)pfb.getProxy();
		usProxy.delete();
		usProxy.update();

	}

}
