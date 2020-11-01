package com.qa.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.qa.objectrepo.MXpath;

public class BasePage {
	private final java.util.logging.Logger log = java.util.logging.Logger
			.getLogger(BasePage.class.getName());
	
	public void waitAndClickLnk(WebDriver driver,WebElement element) 
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		log.info("Element Clicked: "+element.toString());
	}
	public void click(WebElement element) {
		element.click();
		
	}

	public void verifyText(WebDriver driver,WebElement element,String text){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println(element.getText());
		Assert.assertEquals(element.getText(), text, "Text not matching: "+"Expected: "+text+" Actual: "+element.getText() );
	}

	public String getTextValue(WebDriver driver,WebElement element){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println(element.getText());
		String result= element.getText();
		return result;
	}
	public void clearAndType(WebElement field, String keys) {
		field.clear();
		field.sendKeys(keys);
	}
	public void Type(WebElement field, String keys) {
		field.sendKeys(keys);
	}
	
	public void clickButton(WebElement button){
	/*	if (!verifyElementExists(button)) {
			throw new NoSuchElementException("Button is not present" + toString());
		} else {  */
			button.click();
			addDelay(1000);
		}
	
	public Boolean verifyElementExists(WebElement lnk) {
		if (lnk == null) {
			return false;
		} else
			return true;

	}
	public void clickLink(WebElement lnk){
		if (!verifyElementExists(lnk)) {
			throw new NoSuchElementException("Link is not present" + toString());
		} else {
			lnk.click();
			addDelay(5000);
		}
	}
	public void addDelay(int milliSec) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String verifyNewTabOpened(WebDriver driver) {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		if (tabs.size() > 1) {
			driver.switchTo().window(tabs.get(1));
			String currentUrl = driver.getCurrentUrl();
			if (currentUrl.contains("https://www.marketresearch.com/")) {
				try {
					ssoLogin(driver);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			String newUrl = driver.getCurrentUrl();
			driver.close();
			driver.switchTo().window(tabs.get(0));
			return newUrl;

		} else {
			driver.switchTo().window(tabs.get(0));
			return driver.getCurrentUrl();
		}}

	public void ssoLogin(WebDriver driver) throws IOException {

		Properties props = new Properties();
		props.load(BasePage.class.getResourceAsStream("P:\\selenium-testing\\MarketResearch\\config.properties"));
		MXpath.userBtn.sendKeys(props.getProperty("wusername"));
		MXpath.passwordBtn.sendKeys(props.getProperty("wpassword"));
		MXpath.loginClick.click();
		addDelay(1000);
		try {
			Alert alert = driver.switchTo().alert();
			String alertText = alert.getText();
			System.out.println("Alert data: " + alertText);
			alert.accept();
		} catch (Exception e) { 
		}}	

}
