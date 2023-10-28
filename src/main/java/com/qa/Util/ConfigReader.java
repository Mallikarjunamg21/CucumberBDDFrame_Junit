package com.qa.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;

	
	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("src/test/resources/com/qa/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			System.out.println("File not found...!! ");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("File not loading...!! ");
			e.printStackTrace();
		}
		return prop;
	}
	
	
	
}
