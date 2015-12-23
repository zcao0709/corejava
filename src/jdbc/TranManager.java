package jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TranManager {
	public static void begin(){
		Connection con = JdbcUtil.getConn();
		if(con!=null)
			try {
				con.setAutoCommit(false);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void commit(){
		Connection con = JdbcUtil.getConn();
		if(con!=null)
			try {
				con.commit();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void rollback(){
		Connection con = JdbcUtil.getConn();
		if(con!=null)
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
