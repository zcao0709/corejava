package io;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class IODemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException {
//		FileOutputStream out = new FileOutputStream("e:\\aa.txt");
//		out.write(1000000);
//		DataOutputStream dout = new DataOutputStream(out);
//		dout.writeInt(1000000);
//		new BufferedOutputStream(dout);
//		
//		new BufferedReader(new InputStreamReader(new FileInputStream("")));
//	
	    String s = "ÖÐ¹úABC";
	    byte[] bytes = s.getBytes("UTF-16BE");
	    for (byte b : bytes) {
			System.out.print(Integer.toHexString(b&0XFF)+"  ");
		}
	}

}
