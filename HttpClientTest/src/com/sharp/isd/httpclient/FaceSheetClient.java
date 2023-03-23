package com.sharp.isd.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class FaceSheetClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream fis=null;
		
		File file=new File("C:/TEMP/testingData/faceSheet.txt"); //testing data
		
		try{
			
			fis=new FileInputStream(file);
			int len=(int)file.length();
			
			System.out.println("file length is "+len);
			byte[] byteArray=new byte[len];
			int i=0;
			i=fis.read(byteArray);
			System.out.println("read bytes: "+i);
			String reqStr=new String(byteArray);
			
//			System.out.println("reqStr is "+reqStr);
			System.out.println("Start sending request");   
			
			URL url = new URL("http://socrmswebtst02:8080/MFacesheet/services/FlowCastFacesheetSOAP");  //TEST
 
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("POST");   
			rc.setDoOutput( true );   //for POST, send stuff out, The default is false
			rc.setDoInput( true );    // is used to fetch the response and is true by default
			rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );
			
			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );   
			
			
//			rc.setRequestProperty("SOAPAction", "http://socrmswebtst02:8080/MFacesheet/services/FlowCastFacesheetSOAP/");
//			rc.setRequestProperty("SOAPAction", "http://www.sharp.com/FlowCastFacesheet/");
			
			OutputStreamWriter out = new OutputStreamWriter( rc.getOutputStream() );    
			out.write( reqStr, 0, len );   
			out.flush();   
			System.out.println("Request sent, reading response ");   
			InputStreamReader read = new InputStreamReader( rc.getInputStream() );   
			StringBuilder sb = new StringBuilder();      
			int ch = read.read();   
			while( ch != -1 ){   
				sb.append((char)ch);   
				ch = read.read();   
			}   
			String response = sb.toString();
			System.out.println("response is "+response);
			read.close();   
			rc.disconnect();   
		}
		catch(FileNotFoundException e){
			System.out.println("FileNotFoundException "+e.getMessage());
		}
		catch(IOException e){
			System.out.println("IOException "+e.getMessage());
			e.printStackTrace();
		}
		catch(Throwable e){
			System.out.println("Throwable "+e.getMessage());
			e.printStackTrace();
		}
	}
}

