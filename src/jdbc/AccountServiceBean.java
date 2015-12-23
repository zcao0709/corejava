package jdbc;

public class AccountServiceBean implements AccountServcie {
	private DaoSupport<Account> ds = new DaoSupport<Account>();
	/* (non-Javadoc)
	 * @see jdbc.AccountServcie#change(int, int, int)
	 */
	@Override
	public void change(int id1,int id2,int money){
		int n1 = ds.saveOrDelOrUpdate("update account set account = account -? where id=?", money,id1);
		int n2 = ds.saveOrDelOrUpdate("update account set account = account + ? where id=?", money,id2);
		if(n1==0 || n2 == 0)
			throw new RuntimeException("в╙укспнС!");
	}
}
