package com.sharp.isd.httpclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class PointCareFutureClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileInputStream fis=null;
//		File file=new File("C:/temp/exampleJson.txt");
		
		File file=new File("C:/temp/exampleJsonWithPid.txt");
		
//		File file=new File("C:/temp/exampleFromEric.txt");

		try{

			fis=new FileInputStream(file);
			int len=(int)file.length();

			System.out.println("file length is "+len);
			byte[] byteArray=new byte[len];
			int i=0;
			i=fis.read(byteArray);
			System.out.println("read bytes: "+i);
			String reqStr=new String(byteArray);

			System.out.println("reqStr is "+reqStr);
			System.out.println("Start sending request");
			
			
			//07/2018
			//after remove TLS1 from Apache,
			//SSLProtocol all -SSLv2 -SSLv3 -TLSv1
			//got this error:
			//javax.net.ssl.SSLHandshakeException: Remote host closed connection during handshake
			//Caused by: java.io.EOFException: SSL peer shut down incorrectly
			
			//to fix it, add below lines
			System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
			
			
			//POINTCARE future
			
			URL url = new URL("https://rmsproxy.sharp.com/pointcareTest/general");
			
//			URL url = new URL("https://pphxwebsrdmz1.sharp.com/pointcareTest/general"); 

			HttpsURLConnection rc = (HttpsURLConnection)url.openConnection();

			HostnameVerifier hv = new HostnameVerifier()
			{
				public boolean verify(String urlHostName, SSLSession session)
				{
					System.out.println("Warning: URL Host: " + urlHostName + " vs. "
							+ session.getPeerHost());
					return true;
				}
			};

			rc.setHostnameVerifier(hv);

			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("POST");   
			rc.setDoOutput( true );   
			rc.setDoInput( true );    
			rc.setRequestProperty("Content-Type", "application/json" );   
			rc.setRequestProperty("X-API-KEY", "9114FA1B544F5EB6DB94C36D832DA579" ); 

//			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );   
//			rc.setRequestProperty("SOAPAction", soapActions[actionLookup(action)] );   
//			rc.connect();       
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
	}
}
