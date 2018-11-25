package com.crm.objectrepo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PageObjects {
	
	public Properties getPageObjects() throws IOException {
		FileInputStream fis = new FileInputStream("src\\test\\resources\\crm_or.properties");
		Properties prop = new Properties();
		prop.load(fis);
		return prop;
	}
	
	

}
