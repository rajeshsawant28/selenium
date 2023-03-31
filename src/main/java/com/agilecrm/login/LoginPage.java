package com.agilecrm.login;

import org.openqa.selenium.By;

import com.agilecrm1.utility.BaseClass;
import com.github.dockerjava.api.model.Driver;



public class LoginPage extends BaseClass

{
	By username = By.name("email");
	By password = By.name("password");
	By signin = By.xpath("//input[@type='submit']");
	By forgotPassword = By.xpath("(//a)[2]");
	
	By profile=By.xpath("(//span/img)[1]");
	By logout=By.xpath("//a[normalize-space()='Logout']");
	
	By module=By.id("//h1[@id=\"dashboard-name\"]");
	By errormessage=By.xpath("//*[@id=\"app\"]/div/div[2]");
	
	By errormessage1=By.xpath("//*[@id=\"app\"]/div/div[2]");
	
	public LoginPage()
	{
		super();  // reads config.properties file
	}
	
	public void enterUsername(String uname)
	{
		driver.findElement(username).sendKeys("rajesh123@yopmail.com");
		
		
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys("NGDNG9IQ");
	}
	
	public void clickOnLoginBtn()
	{
		driver.findElement(signin).click();
	}
	
	public LandingPage loginToAppl(String uname, String pwd)
	{
		enterUsername(uname);
		enterPassword(pwd);
		clickOnLoginBtn();
		return new LandingPage(); // chaining of pages
	}

}
