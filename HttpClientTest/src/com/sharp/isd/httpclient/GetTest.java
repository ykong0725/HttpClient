package com.sharp.isd.httpclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetTest {

	 
	public static void main(String[] args) {
		
		 
		
		try{
			
			System.out.println("Start sending request");   
			
			URL url = new URL("http://localhost:8080/HttpWebTest/searchPatient?name=franklin");
 
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("GET");   
			
			System.out.println("Request sent, reading response "); 
			
			int responseCode=rc.getResponseCode();
			System.out.println("response code is "+responseCode);
			
			
//			InputStreamReader read = new InputStreamReader( rc.getInputStream() );   
//			StringBuilder sb = new StringBuilder();      
//			int ch = read.read();   
//			while( ch != -1 ){   
//				sb.append((char)ch);   
//				ch = read.read();   
//			}   
//			String response = sb.toString();
//			read.close();   
//			System.out.println("response is "+response);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(
					rc.getInputStream()));
			String inputLine;
//			StringBuffer response = new StringBuffer();  // thread safe
			StringBuilder response = new StringBuilder();  //not thread safe, but fast

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println("response is "+response.toString());
//			System.out.println("response is "+response);
			
			
			
			
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


