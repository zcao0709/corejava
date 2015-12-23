package jdbc;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
	public T findById(Serializable id,String sql,RowMapper<T> rm);
	public List<T> find(String sql,RowMapper<T> rm,Object...obj);
	public int saveOrDelOrUpdate(String sql,Object...obj);
}
