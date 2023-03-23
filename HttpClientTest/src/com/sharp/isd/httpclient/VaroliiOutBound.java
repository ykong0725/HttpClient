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

public class VaroliiOutBound {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		FileInputStream fis=null;
		File file=new File("C:/VaroliiTestingfile/testingOut.xml"); //Varolii outbound data

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

			//Varolii live
			URL url = new URL("https://sharp.vrli.com/scheduleReminder?WSDL");

			//Varolii testing
//			URL url = new URL("https://sst-svcbus.vrli.com:52090/scheduleReminder?WSDL");

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
			rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );   

			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );   
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

