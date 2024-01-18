package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	Properties pro;

	public ReadConfig() {

		File src = new File("./Configuration/config.properties");

		try {
			FileInputStream readData = new FileInputStream(src);
			pro = new Properties();
			pro.load(readData);

		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}

	}

	public String getApplicationURL() {
		String url = pro.getProperty("baseUrl");
		return url;

	}

	public String getUserName() {
		String username = pro.getProperty("username");
		return username;
	}

	public String getPassword() {
		String pwd = pro.getProperty("Password");
		return pwd;
	}

	public String getChromPath() {
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}

	public String getFirfoxPath() {
		String firefoxpath = pro.getProperty("firefoxpath");
		return firefoxpath;
	}
}
