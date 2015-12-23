package flyweight;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer n1 = 1;
		Integer n2 = 1;
		System.out.println(n1==n2);
		
		Integer n3 = 128;
		Integer n4 = 128;
		System.out.println(n3==n4);
		
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1==s2);
		
		String s3 = "hello" + "world";
		String s4 = "helloworld";
		System.out.println(s3==s4);
		
		String s5 = s1 +"world";//new StringBuilder(s1).append("world").toString()
		System.out.println(s3==s5);
		
		
		String str1 = new String("123456789");
		str1 = str1.substring(2);
		//str1 = new String(str1.substring(2))

	}

}
