package proxy;

public class UserServceProxy implements UserService{
	private UserServcieImpl us;
	public void setUs(UserServcieImpl us) {
		this.us = us;
	}
	@Override
	public void update() {
		System.out.println("Ȩ�ޡ���־������");
		us.update();
		System.out.println("��־������");
	}

	@Override
	public void delete() {
		System.out.println("Ȩ�ޡ���־������");
		us.delete();
		System.out.println("��־������");
	}

}
