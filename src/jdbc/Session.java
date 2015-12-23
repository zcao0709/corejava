package jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Session {
	public int save(Object obj){
		Connection con = null;
		PreparedStatement pstmt = null;
		int n = 0;
		try {
			con = JdbcUtil.getConn();
			pstmt = getStatement(con, obj);
			n = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
	public PreparedStatement getStatement(Connection con,Object obj)throws Exception{
		PreparedStatement pstmt = con.prepareStatement(getSql(obj));
		Class c= obj.getClass();
		Field[] fs = c.getDeclaredFields();
		for(int i = 0; i < fs.length;i++){
			fs[i].setAccessible(true);
			pstmt.setObject(i+1, fs[i].get(obj));
		}
		return pstmt;
		
	}
	public String getSql(Object obj){
		StringBuilder s = new StringBuilder();
		s.append("insert into ");
		Class c = obj.getClass();
		String tablename = c.getSimpleName();
		Entity entity = (Entity)c.getAnnotation(Entity.class);
		if(entity!=null)
			tablename = entity.value();
		s.append(tablename).append("(");
		Field[] fs = c.getDeclaredFields();
		for(int i = 0; i < fs.length;i++){
			String name = fs[i].getName();
			Column column = fs[i].getAnnotation(Column.class);
			if(column!=null)
				name = column.value();
			s = i == 0 ? s.append(name) : s.append(",").append(name);
		}
		s.append(")values").append(getString(fs.length));
		return s.toString();
	}
	public String getString(int length){
		StringBuilder s= new StringBuilder();
		s.append("(");
		for(int i = 0 ; i < length;i++){
			s = i == 0 ? s.append("?") :s.append(",?");
		}
		return s.append(")").toString();
	}
}
