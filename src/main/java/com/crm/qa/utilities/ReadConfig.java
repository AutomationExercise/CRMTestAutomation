package com.crm.qa.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties prop;
	
	public ReadConfig() // constructor to load the properties file.
	{
		//File src = new File("./Configurations/config.properties");
		File src = new File(System.getProperty("user.dir")+"/src/main/java/com/crm/qa/config/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		} catch(Exception e)
		{
			System.out.println("Exception is: "+ e.getMessage());
		}
	}
	
	public String getAppURL()
	{
		String url = prop.getProperty("baseURL");
		return url;
	}
	
	public String getUserName()
	{
		String username = prop.getProperty("username");
		return username;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
	
	public String getChromePath()
	{
		String chromepath = prop.getProperty("chromePath");
		return chromepath;
	}
	
	public String getFirefoxPath()
	{
		String firefoxpath = prop.getProperty("firefoxPath");
		return firefoxpath;
	}
	
	public String getIEPath()
	{
		String iepath = prop.getProperty("iePath");
		return iepath;
	}
}
