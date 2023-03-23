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

import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

public class RestfulClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		FileInputStream fis=null;
// 
//		File file=new File("C:/PointCareRelated/posted_data_fromPointcare2.txt"); //FHCE data
		
		try{
			
//			fis=new FileInputStream(file);
//			int len=(int)file.length();
//			
//			System.out.println("file length is "+len);
//			byte[] byteArray=new byte[len];
//			int i=0;
//			i=fis.read(byteArray);
//			System.out.println("read bytes: "+i);
//			String reqStr=new String(byteArray);
			
			System.out.println("Start sending request");
			
			URL url = new URL("http://localhost:7003/WFBannerPicture/ConversionService/InchToFeet/126");
			
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("GET");   
			rc.setDoOutput( true );   
			rc.setDoInput( true );    
//			rc.setRequestProperty( "Content-Type", "text/xml; charset=utf-8" );   
			
			rc.setReadTimeout(10000);
			rc.connect();
			
//			BufferedReader rd= new BufferedReader(new InputStreamReader(rc.getInputStream()));
//			
//			StringBuilder sb = new StringBuilder();
//
//			String line=null;
//			while ((line = rd.readLine()) != null)
//			{
//			sb.append(line + '\n');
//			}
//
//			System.out.println(sb.toString());

			
//			rc.setRequestProperty( "Content-Length", Integer.toString( len ) );   
//			rc.setRequestProperty("SOAPAction", soapActions[actionLookup(action)] );   
//			rc.connect();       
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
