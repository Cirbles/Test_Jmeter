package com.yiibai.junit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import jdk.internal.util.xml.impl.Input;

public class URLReader {
	
	
	public static void main(String[] args) throws Exception{
		
		String str  = "http://www.baidu.com/query.jsp?param1=value2&param2=value2";
		URL yahoo = new URL(str);
		BufferedReader in = new BufferedReader(new InputStreamReader(yahoo.openStream()));
		String inputLine;
		
		while ((inputLine = in.readLine()) != null) {
			System.out.println(inputLine);
			
			in.close();
		}
		
	}

}
