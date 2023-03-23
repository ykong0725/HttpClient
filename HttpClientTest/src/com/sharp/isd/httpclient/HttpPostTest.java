package com.sharp.isd.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class HttpPostTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			
			 
			
//			URL url = new URL("http://localhost:8080/FhceUniqueId/getUniqueId?MRN=103601217&user=konyu&sid=0.9811755185710753");
 
			URL url = new URL("http://localhost:8080/FhceUniqueId/getUniqueId");
			
			
			String rawData = "MRN=103601217&user=konyu";
			
			String encodedData = URLEncoder.encode(rawData, "UTF-8");
			
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("POST");   
			rc.setDoOutput( true );   
			rc.setDoInput( true );    
			rc.setRequestProperty( "Content-Type", "application/x-www-form-urlencoded");
			
			rc.setRequestProperty( "Content-Length", String.valueOf(encodedData.length()));
			
			OutputStream os=rc.getOutputStream();
			
			os.write(encodedData.getBytes());
			os.flush();
			
//			rc.setRequestProperty("MRN", "103601217");
//			rc.setRequestProperty("user", "konyu");
			
			
			
//			rc.connect();
			
			
			
//			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );
			
//			OutputStreamWriter out = new OutputStreamWriter( rc.getOutputStream() );    
//			out.write( reqStr, 0, len );   
//			out.flush();   
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
	}
}

