package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class JdbcUtil {
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static Properties prop = new Properties();
	static {
		try {
			prop.load(JdbcUtil.class
					.getResourceAsStream("/jdbc/jdbc.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConn() {
		Connection con = tl.get();
		if (con == null) {
			try {
				Class.forName(prop.getProperty("driverClassName"));
				con = DriverManager.getConnection(prop.getProperty("url"),
						prop.getProperty("uname"), prop.getProperty("upass"));
				tl.set(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return con;

	}
}
