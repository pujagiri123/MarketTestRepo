package com.qa.base;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {
	private final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(Base.class.getName());

	public WebDriver driver=null;
	public static Properties props = null;


	public WebDriver getLocalDriver() {
		System.setProperty("webdriver.chrome.driver","P:\\chromedriver.exe");

		//String browser = props.getProperty("browser", "Chrome");
		/*	if (browser.equals("Mozilla")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("IE"))
			driver = new InternetExplorerDriver();
		else 
		if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("P:\\selenium jars\\chromedriver.exe"));
			driver = new ChromeDriver();
		} */
		driver=new ChromeDriver();
		return driver;
	}
	public static void readPropertiesFile()
	{
		props=new Properties();
		InputStream input;
		String url;
		try {
			input = new FileInputStream("P:\\selenium-testing\\MarketResearch\\config.properties");

			props.load(input);
			url=props.getProperty("browser");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected static String getTestUrl() {
		String url=props.getProperty("url");
		String testUrl = url.toString().toLowerCase();
		//return testUrl;
		return url;
	}

}
