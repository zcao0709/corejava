package proxy;

public class UserServceProxy implements UserService{
	private UserServcieImpl us;
	public void setUs(UserServcieImpl us) {
		this.us = us;
	}
	@Override
	public void update() {
		System.out.println("权限、日志、事务");
		us.update();
		System.out.println("日志、事务");
	}

	@Override
	public void delete() {
		System.out.println("权限、日志、事务");
		us.delete();
		System.out.println("日志、事务");
	}

}
