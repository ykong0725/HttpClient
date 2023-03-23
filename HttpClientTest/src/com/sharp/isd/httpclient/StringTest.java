package com.sharp.isd.httpclient;

//import weblogic.apache.org.apache.velocity.runtime.directive.Foreach;

public class StringTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String asd="ABCDEFGHIJKLMNabcdefg";
		byte[] bytes=asd.getBytes();
		
		String zxc=bytes.toString();
		
		System.out.println("bytes is "+bytes);
		
		int len=bytes.length;
		for(int i=0; i<len; i++){
			System.out.println("byte is "+bytes[i]);
			
		}
		
		System.out.println("zxc is "+zxc);
		
		byte byte1 = 100;
		System.out.println("byte1 is "+byte1);
		char char1 = 'A';
		byte1 = (byte)char1;
		System.out.println("byte1 is "+byte1);
		System.out.println("char1 is "+char1);
		
		for (byte b : bytes) {
			
			System.out.println("b is "+b);
		}
		
		 


	}

}
