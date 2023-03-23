package com.sharp.isd.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeSyncClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try{
			
			System.out.println("Start sending request");   
			
			URL url = new URL("https://websoaint.sharp.com/restapi/patientsync");  //QA
 
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("POST");   
			rc.setDoOutput( true );   
			rc.setDoInput( true );
			
			
			rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );
			
			String urlParameters="shcn=102-694-907&source=GE&firstname=SUNNY&lastname=RGTEST&middleInitial=&addressLine1=4580 TWAIN AVE APT 2&addressLine2=&city=SAN DIEGO&state=CA&zipCode=92120-4130";
			
			int len=urlParameters.length();
			
			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );   
			
			OutputStreamWriter out = new OutputStreamWriter( rc.getOutputStream() );    
			out.write( urlParameters, 0, len );   
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


