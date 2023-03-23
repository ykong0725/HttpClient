package com.sharp.isd.httpclient;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class RestfulClientHieConnect {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try{
			
			JSONObject demo = new JSONObject();
			demo.put("shcNum", "103601217");
//			demo.put("shcNum", 103601217);
//			demo.put("shcNum", 1999999999);
			int i=Integer.MAX_VALUE;
			System.out.println("i is "+i);
			
			demo.put("lastName", "RGTEST");
			demo.put("firstName", "SELECT");
			demo.put("DOB", "12/10/1956");
//			demo.put("dob", "12/10/1956");
			demo.put("gender", "Female");
			
			JSONObject address = new JSONObject();
			address.put("addrL1", "10824 Scripps Ranch Blvd");
			address.put("addrL2", "#203");
//			address.put("addrL2", 203);
			address.put("city", "San Diego");
			address.put("state", "CA");
			address.put("zipCode", "92131");
//			address.put("zipCode", 92131);
			address.put("country", "USA");
			
			demo.putOpt("address", address);
			
			demo.put("telePhone", "858-866-1234");
			
			String demoString=demo.toString();
			
			System.out.println("demoString: "+demoString);
			
			System.out.println("Start sending request");
			
			
//			URL url = new URL("http://localhost:7003/RMSGeneralRs/registration/updateHieConsent");
//			URL url = new URL("http://localhost:7003/RMSGeneralRs/registration/updateHieConsentJackson");
//			URL url = new URL("http://socambsystst02:8080/RMSGeneralRsWar/registration/updateHieConsent");
//			URL url = new URL("http://socambsystst01:7003/RMSGeneralRs/registration/updateHieConsent");
//			URL url = new URL("http://socambsysweb01:7003/RMSGeneralRs/registration/updateHieConsent");
			
//			URL url = new URL("http://socrmswebtst01:7003/RMSGeneralRs/registration/updateHieConsent");
//			URL url = new URL("http://socrmsweb01:7003/RMSGeneralRs/registration/updateHieConsent");
			
			
//			URL url = new URL("http://localhost:8080/RMSGeneralRs/registration/updateHieConsent");   // NEW LOCAL
			
			URL url = new URL("http://socrmswebtst02:8080/RMSGeneralRs/registration/updateHieConsent");   // NEW TEST
			
			HttpURLConnection rc = (HttpURLConnection)url.openConnection();   
			System.out.println("Connection opened " + rc );   
			rc.setRequestMethod("POST");   
			rc.setDoOutput( true );   
			rc.setDoInput( true );
			
            rc.setRequestProperty( "Content-Type", "application/json" );   
			
			OutputStreamWriter out = new OutputStreamWriter(rc.getOutputStream());    
			out.write(demoString);   
			out.flush();   
			System.out.println("Request sent, reading response ");
			
			int responseCode=rc.getResponseCode();
			System.out.println("responseCodeq is "+responseCode);
			
			
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
		catch(JSONException e){
			System.out.println("JSONException occurred: "+e.getMessage());
		}
		catch(IOException e){
			System.out.println("IOException "+e.getMessage());
			e.printStackTrace();
		}
	}

}

