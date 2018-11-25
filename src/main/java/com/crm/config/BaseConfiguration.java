package com.crm.config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class BaseConfiguration {
	
	private static Logger Log = Logger.getLogger(BaseConfiguration.class.getName());
	public static WebDriver wd = null;
	public Properties prop = null;
	public FileInputStream fis = null;
	
public void invokeBrowser() {
	
	try
	{
		PropertyConfigurator.configure("src/test/resources/log4j.properties");
		fis = new FileInputStream("src/test/resources/config.properties");
		prop = new Properties();
		prop.load(fis);
		String br = prop.getProperty("browser");
		
		if(br.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\ScriptDriver\\chromedriver.exe");
			wd = new ChromeDriver();
			Log.info("browser open successfully");
		}
		else if(br.equalsIgnoreCase("firefox")) {
			System.setProperty("webDriver.firefox.driver", "C:\\ScriptDrivers\\geckodriver.exe");
			wd = new FirefoxDriver();
		}
		else if(br.equalsIgnoreCase("iexplore")) {
			System.setProperty("webDriver.iexplore.driver", "C:\\ScriptDrivers\\IEDriverServer.exe");
			wd = new InternetExplorerDriver();
		}
		
		wd.navigate().to(prop.getProperty("qa_url"));
		Log.info("page open succesfully");
		wd.manage().window().maximize();
		String impWait = prop.getProperty("implicity_wait");
		int impwait = Integer.parseInt(impWait);
		wd.manage().timeouts().implicitlyWait(impwait, TimeUnit.SECONDS);

	}
	
	catch(Exception e)
	{
		e.printStackTrace();
	}
	

}

}
