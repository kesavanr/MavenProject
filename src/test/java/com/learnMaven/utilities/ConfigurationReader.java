package com.learnMaven.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
	Properties pr;
	public ConfigurationReader() throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\java\\com\\learnMaven\\property\\config.properties");
		pr = new Properties();
		pr.load(fis);
	}
	public String getBrowser() {
		return pr.getProperty("Browser");
	}
	public String getUrl() {
		return pr.getProperty("Url");
	}
	/*public static void main(String[] args) throws IOException {
		ConfigurationReader cr = new ConfigurationReader();
		System.out.println(cr.getBrowser());
		System.out.println(cr.getUrl());
	}*/
}
