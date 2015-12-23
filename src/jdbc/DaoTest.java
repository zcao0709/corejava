package jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DaoSupport<Account> ds = new DaoSupport<Account>();
		//Account account = ds.findById(1, "select * from account where id=?",new AccountRowMapper());
		//System.out.println(account);
//		List<Account> accounts = ds.find("select * from account where account > ?", new AccountRowMapper(),2300);
//		for (Account account : accounts) {
//			System.out.println(account);
//		}
//		Account account = new Account(15, "xayzbc", 2000);
//		ds.saveOrDelOrUpdate("insert into account (id, name,account)values(?,?,?)",account.getId(),account.getName(),account.getAccount());
		AccountServcie as = new AccountServiceBean();
		//as.change(1, 2000, 100);
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTarget(as);
		AccountServcie asProxy  = (AccountServcie)pfb.getProxy();
		asProxy.change(1, 20000, 100);
	}

}
class AccountRowMapper implements RowMapper<Account>{

	@Override
	public Account getRow(ResultSet rs) throws SQLException {
		// TODO Auto-generated method stub
		Account account = new Account();
		account.setId(rs.getInt("id"));
		account.setName(rs.getString("name"));
		account.setAccount(rs.getInt("account"));
		return account;
	}
	
}
