package util;

import java.util.HashMap;
import java.util.HashSet;

public class HashMapTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Stu> hs = new HashSet<Stu>();
		Stu stu1 = new Stu("1000", "zhangsan");
		Stu stu2 = new Stu("1000","zhangsan");
		hs.add(stu1);
		//hs.add(stu2);
		stu1.setNo("xxx");
		hs.remove(stu1);
		System.out.println(hs.size());
		
		HashMap<Stu, String> hm = new HashMap<Stu,String>();
		hm.put(stu1, "hello");
		stu1.setNo("xxx");
		System.out.println(hm.get(stu1));
		

	}

}
class Stu{
	private String no;
	private String name;
	public Stu() {
		// TODO Auto-generated constructor stub
	}
	public Stu(String no, String name) {
		super();
		this.no = no;
		this.name = name;
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stu other = (Stu) obj;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		return true;
	}
	
}
