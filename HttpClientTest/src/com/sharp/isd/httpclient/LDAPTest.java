package com.sharp.isd.httpclient;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class LDAPTest {
	
	public static void main(String[] args) {
		System.out.println("Sarted ...");

		final String ldapAdServer = "ldap://ldap.sharp.com:389";
//		final String ldapSearchBase = "dc=SHCSD,dc=sharp,dc=com";

//		final String ldapUsername = "konyu";
//		final String ldapUsername = "konyu@shcsd.sharp.com";
		final String ldapUsername = "shcsd\\konyu";
		final String ldapPassword = "patience14";

		Hashtable<String, Object> env = new Hashtable<String, Object>();
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		if(ldapUsername != null) {
			env.put(Context.SECURITY_PRINCIPAL, ldapUsername);
		}
		if(ldapPassword != null) {
			env.put(Context.SECURITY_CREDENTIALS, ldapPassword);
		}
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.PROVIDER_URL, ldapAdServer);

		
		try{
		
		DirContext ctx = new InitialDirContext(env);
		System.out.println("Done ...");
		}
		catch(NamingException e){
			System.out.println("NamingException: "+e.getLocalizedMessage()  +" : " +e.getMessage());
			
		}
	}


}
