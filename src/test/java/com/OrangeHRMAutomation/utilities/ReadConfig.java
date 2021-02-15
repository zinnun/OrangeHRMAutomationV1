package com.OrangeHRMAutomation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties prop;
	
	
	public ReadConfig()
	{
		File src = new File("./Configuration\\config.properties");
		
		
		// properties file --> file --> fileInputStream --> properties(fileInputStream)
		try 
		{
			FileInputStream instrm = new FileInputStream(src);
			prop = new Properties();
			prop.load(instrm);
		} 
		catch (Exception e) 
		{
			System.out.println("exception: "+ e.getMessage());
		}
	}
	
	
	
	public String getURl()
	{
		String url = prop.getProperty("baseUrl");
		return url;
	}
	public String getUserName()
	{
		String usrName= prop.getProperty("userName");
		return usrName;
		
	}
	public String getPassword()
	{
		String pass = prop.getProperty("password");
		return pass;
		
	}
	public String getChrome()
	{
		String chromeKey = prop.getProperty("chrome");
		return chromeKey;
		
	}
	public String getFirefox()
	{
		String firefoxKey = prop.getProperty("firefox");
		return firefoxKey;
		
	}
	public String getEdge()
	{
		String edgeKey = prop.getProperty("edge");
		return edgeKey;
		
	}
	public String getChromePath()
	{
		String chromePath = prop.getProperty("chrome_path");
		return chromePath;
		
	}
	public String getFirefoxPath()
	{
		String firefoxPath = prop.getProperty("gecko_path");
		return firefoxPath;
		
	}
	public String getEdgeKey()
	{
		String edgePath = prop.getProperty("edge_path");
		return edgePath;
		
	}
	
	
}
