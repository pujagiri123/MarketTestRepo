package com.qa.objectrepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MXpath {
	public MXpath()
	{}
	
	//SignUp
	
	@FindBy(xpath="//body/div[2]/div[1]/section[1]/nav[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")
	public static WebElement signUpBtn;
	@FindBy(xpath="//body/form[@id='registrationform']/div[2]/p[1]/input[1]")
	public static WebElement emailBtn;
	@FindBy(xpath="//body/form[@id='registrationform']/div[2]/p[2]/input[1]")
	public static WebElement firstName;
	@FindBy(xpath="//body[1]/form[1]/div[2]/p[3]/input[1]")
	public static WebElement lastName;
	@FindBy(xpath="//body/form[@id='registrationform']/div[2]/p[4]/input[1]")
	public static WebElement countryBtn;
	@FindBy(xpath="//button[@id='submitRegistration']")
	public static WebElement saveandkeepredBtn;
	
	
	//Login
	
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	public static WebElement loginBtn;
	@FindBy(xpath="//tbody/tr[1]/td[2]/input[1]")
	public static WebElement userBtn;
	@FindBy(xpath="//tbody/tr[2]/td[2]/input[1]")
	public static WebElement passwordBtn;
	@FindBy(xpath="//*[contains(text(),'Login »')]")
	public static WebElement loginClick;
	@FindBy(xpath="//*[contains(text(),'Accept')]")
	public static WebElement acceptLnk;
	
	//Logout
	@FindBy(xpath="//a[@id='link-myaccount']")
	public static WebElement myAccount;
	@FindBy(xpath="//a[contains(text(),'Log Out')]")
	public static WebElement logoutBtn;
}
