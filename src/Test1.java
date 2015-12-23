
public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer n1 = 1;
		Integer n2 = 1;
		System.out.println(n1==n2);
		Integer n3 = 128;
		Integer n4 = 128;
		System.out.println(n3==n4);
		
		
		String s = "hello";
		String s1 = "hello";
		System.out.println(s==s1);
		
		String s3 = "hello"+"world";
		String s4 = "helloworld";
		System.out.println(s3==s4);
		
		String s5 = s1 + "world";//new StringBuilder(s1).append("world").toSting();
		System.out.println(s4==s5);
		
		
		
		String s6 = new String("1234567");
		//s6 = s6.substring(3);
		//s6 = new String(s6.substring(3));
		
		
		
		
		
		
		
		
	}

}
