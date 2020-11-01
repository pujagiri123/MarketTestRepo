package com.qa.page;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.qa.objectrepo.MXpath;


public class Login extends BasePage{
	private final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(Login.class.getName());


	public WebDriver driver;
	public static final String LOGIN_URI = "https://www.marketresearch.com/";
	public Login(WebDriver driver)
	{
		this.driver=driver;	
	}
	public BasePage clickLogin() 
	{

		//clickLink(driver.findElement(By.xpath("//a[contains(text(),'Log In')]"))); or,
		click(MXpath.loginBtn);
		return this;
	}

	public BasePage submitLogin(String userid, String pwd) {
		//	final String sourceMethod = "submitLogin";
		//	log.entering(sourceClass, sourceMethod);

		//addDelay(2000);
		clearAndType(MXpath.userBtn, userid);
		clearAndType(MXpath.passwordBtn, pwd);
		//clickButton(MXpath.acceptLnk);
		addDelay(2000);

		if((MXpath.acceptLnk).isDisplayed())
		{
			clickButton(MXpath.acceptLnk);		
		}
		else
		{
			clickButton(MXpath.loginClick);		

		} 
		clickButton(MXpath.loginClick);	
		addDelay(2000);
		String url = driver.getCurrentUrl();
		if (url.contains("Login »")) {
			return this;
		} else {
			return PageFactory.initElements(driver, Login.class);
		}
	}



}
