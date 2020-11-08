package com.qa.test;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.objectrepo.MXpath;
import com.qa.page.Login;
import com.qa.page.Logout;


public class LoginTest extends Base{

	Login loginPage = null;
	public Properties props=null;
	public static WebDriver driver=null;
	Base b=PageFactory.initElements(driver,Base.class);
	Logout logpoutPage=null;

	private final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(LoginTest.class.getName());

	/* @BeforeMethod
	public void beforeMethod() {
		// We are going to the Login page before each test

	   driver=b.getLocalDriver();
		String baseUrl =props.getProperty("url");

	//	driver.get(baseUrl + Login.LOGIN_URI);
       driver.get(baseUrl);
	}*/
	@BeforeMethod
	public void readData()
	{
		props=new Properties();
		InputStream input;
		try {
			input = new FileInputStream("P:\\selenium-testing\\MarketResearch\\config.properties");

			props.load(input);
			props.getProperty("browser");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}
	/*@AfterClass
	public void tearDownafterClass() {
		try
		{
			driver.quit();
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("not close");
		}
	}*/
		/*	@Test
	public void testLoginPass() throws InterruptedException {
		WebDriver driver=b.getLocalDriver();
		Login loginPage=PageFactory.initElements(driver,Login.class);
		MXpath mxpath=PageFactory.initElements(driver,MXpath.class);

		String url="https://www.marketresearch.com/";
		driver.get(url);
		loginPage.clickLogin();


		String userid = "puja.giet1@gmail.com";
		String password = "Ppp@giri123";

		loginPage.submitLogin(userid, password);

		//	Assert.assertTrue(driver.getCurrentUrl().contains("https://www.marketresearch.com/"),
		//		"Login Failed to redirect to /ctbx-ui/#/home url");
	} */
		@Test
		public void testLoginByProp() throws InterruptedException
		{

			WebDriver driver=b.getLocalDriver();
			Login loginPage=PageFactory.initElements(driver,Login.class);
			MXpath mxpath=PageFactory.initElements(driver,MXpath.class);
			Logout logoutPage=PageFactory.initElements(driver,Logout.class);

			String url=props.getProperty("url");
			//String url="https://www.marketresearch.com/";
			driver.get(url); 
			loginPage.clickLogin();


			String userid =props.getProperty("wusername");
			String password =props.getProperty("wpassword");

			loginPage.submitLogin(userid, password);

			logoutPage.clickLogout();
	        log.log(Level.INFO, "LogIn Success.."); 

			driver.close();
		} 

	}
