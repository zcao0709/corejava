package jdbc;

public class SessionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session = new Session();
//		Account account = new Account(13, "xyabc", 300);
//		session.save(account);
		
		System.out.println(session.getSql(new User()));

	}

}
