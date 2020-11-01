package com.qa.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.qa.objectrepo.MXpath;

public class Logout extends BasePage {
	private final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(Logout.class.getName());
	
     
	public WebDriver driver;
	public Logout(WebDriver driver)
	{
		this.driver=driver;	
	}
	public BasePage clickLogout() 
	{
		
	//clickLink(driver.findElement(By.xpath("//a[contains(text(),'Log In')]"))); or,
       Actions actions = new Actions(driver);
    	actions.moveToElement(MXpath.myAccount).perform();
		addDelay(1000);

		click(MXpath.logoutBtn);
			return this;
}
	

}
