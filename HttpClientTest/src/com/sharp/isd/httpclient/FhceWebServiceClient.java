package com.sharp.isd.httpclient;

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

public class FhceWebServiceClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FileInputStream fis=null;
		File file=new File("C:/temp/requestStr.txt"); //FHCE data
//		File file=new File("C:/requestStr2.txt"); //FHCE data
//		File file=new File("C:/requestStr3.txt"); //FHCE data
//		File file=new File("C:/requestStr4.txt"); //FHCE data
//		File file=new File("C:/TomK.txt"); //FHCE data
		
//		File file=new File("C:/Bryanna2.txt"); //FHCE data
//		File file=new File("C:/weekly.txt"); //FHCE data
		
		
//		File file=new File("C:/TEMP/fhceTest.txt"); //FHCE data
		
//		File file=new File("C:/arriveAppt.txt"); //kiosk data
		
//		File file=new File("C:/upLoadImage.txt"); //kiosk data
		
//		File file=new File("C:/varoliiOutBoundTest.txt"); //FHCE data
		
//		File file=new File("C:/testData.xml");   //ECIN data
//		File file=new File("C:/testData2.txt");   //ECIN data
		
		
//		File file=new File("C:/PointCareRelated/testData3.txt");   //ECIN data
		
		
		
//		File file=new File("C:/test4.xml");   //ECIN data
//		File file=new File("C:/testXX.xml");   //ECIN data
		
//		File file=new File("C:/test1234.xml");   //ECIN data
		
//		File file=new File("C:/test0506.xml");   //ECIN data
		
//		File file=new File("C:/test050502.xml");   //ECIN data
//		File file=new File("C:/test0506.xml");   //ECIN data
		
//		File file=new File("C:/test0616.xml");   //ECIN data
		
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
//			URL url = new URL("http://localhost:7003/FhceResultInput/general");   //FHCE
//			URL url = new URL("http://socambsysweb01:7001/fhceimport/general");   //FHCE
//			URL url = new URL("http://socambsysweb01:7001/fhceimportlive/general");   //FHCE
//			URL url = new URL("http://socambsysweb01:7005/PatImportService/general");   //FHCE
//			URL url = new URL("http://socambsysweb01:7005/PatImportServiceLive/general");   //FHCE
			
			
			//fhce testing connection from vendor
			
			URL url = new URL("http://webproxy.sharp.com/fhceimportlive/general");  //Now it is LB for socwebproxyprd1 and socwebproxyprd2
//			URL url = new URL("http://webproxy.sharp.com/fhceimport/general");  //Now it is LB for socwebproxyprd1 and socwebproxyprd2
			
//			URL url = new URL("http://socwebproxyprd1.sharp.com/fhceimportlive/general");
			
//			URL url = new URL("http://socwebproxyprd2.sharp.com/fhceimportlive/general");
			
//			URL url = new URL("http://socwebproxyqa.sharp.com/fhceimportlive/general");
			
//			URL url = new URL("http://socwebproxystg.sharp.com/fhceimportlive/general");
			
			
			//TEST for new way, go to Tomcat directly
//			URL url = new URL("https://socrmsproxy04.sharp.com/fhceimport/general");
			
//			https://rmsproxy.sharp.com/fhceimport/general?wsdl
			
			//*****************************************************************************
			//fhce live connection from vendor
//			URL url = new URL("http://webproxy.sharp.com/fhceimportlive/general");
			
//			URL url = new URL("https://rmsproxy.sharp.com/fhceimportlive/general");      //new LINK
			
//			URL url = new URL("http://webproxy.sharp.com/fhceimport/general");

//			URL url = new URL("http://socrmsweb01:7001/fhceimportlive/general");
			
			
//			URL url = new URL("http://socambsystst01.sharp.com/fhceimport/general");   //FHCE
			
			//fhce testing, from web01
//			URL url = new URL("http://socwebproxy01.sharp.com/fhceimport/general");
			
			//fhce live, from web01
//			URL url = new URL("http://socwebproxy01.sharp.com/fhceimportlive/general");
			
			//fhce testing, from web02
//			URL url = new URL("http://socwebproxy02.sharp.com/fhceimport/general");
			
			
			
//			URL url = new URL("http://socpmgtest/fhceimport/general");   //FHCE
			
//			URL url = new URL("https://webproxy.sharp.com/fhceimportlive/general");   //FHCE
			
//			URL url = new URL("http://socambsystst01:7007/KioskServiceSch/schedule");   //kiosk 
			
//			URL url = new URL("http://localhost:7003/KioskService/registration");   //kiosk 
			
			
//			URL url = new URL("http://socambsystst01:7003/PatImportService/general");   //FHCE
			
//			URL url = new URL("http://socambsysweb01:7001/fhceimportlive/general");   //FHCE
			
//			URL url = new URL("http://localhost:7003/XMLImportFromAllScripts/general");  //ECIN 
			
//			URL url = new URL("http://socambsysweb01:7005/PatImportService/general");  //ECIN 
			
			//last time this one
//			URL url = new URL("http://172.16.31.183:13592/PatImportService/general");  //ECIN   09/08/2015
//			URL url = new URL("http://socrmsweb01:13592/PatImportService/general");  //ECIN 
			
//			URL url = new URL("http://socosbdevtest:7008/PatImportService/general");  //ECIN 
			
//			URL url = new URL("http://172.16.31.184:7009/PatImportService/general");  //ECIN 
			
//			URL url = new URL("http://socosbdevtest:7009/PatImportService/general");  //ECIN 
//			URL url = new URL("http://socosbdevtest:7007/PatImportService/general");   
//			URL url = new URL("http://sochco01:8001/PatImportService/general");   
//			URL url = new URL("http://socambsystst01/PatImportService/general");  
			
//			URL url = new URL("https://socwebproxytest/PatImportService/general");
			
			
//			URL url = new URL("https://socrmsproxy01/PatImportService/general");
//			URL url = new URL("https://socrmsproxy02/PatImportService/general");
//			URL url = new URL("http://socrmsproxy02/fhceimport/general");
			
//			URL url = new URL("https://rmsproxy.sharp.com/PatImportService/general");
			
//			URL url = new URL("https://sst-svcbus.vrli.com:52090/scheduleReminder");
			
//			URL url = new URL("http://localhost:7003/PatientPortalService/scheduleReminder");
			
			
//			URL url = new URL("https://172.21.17.191:7004/PatImportService/general");
//			URL url = new URL("http://socambsysweb04/PatImportService/general");
//			URL url = new URL("http://socambsystst01/PatImportService/general");
			
			//https://socrmsproxy02.sharp.com/SharpInPrd/varolii?wsdl
			
			
			
			
			
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
//			HttpsURLConnection rc = (HttpsURLConnection)url.openConnection();   
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
