package com.agilecrm.login;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.agilecrm1.utility.BaseClass;

public class LoginTest extends BaseClass
{
	
	LoginPage loginPage     = null;
	LandingPage landingPage = null;
	
	@BeforeMethod
	public void setUp()
	{
		loginPage = new LoginPage();
		loginPage.inIt();
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//			driver.quit();
//	}
	
	@Test
	public void SignIn()
	{
		landingPage = loginPage.loginToAppl("rajesh123@yopmail.com", "NGDNG9IQ");
		
	}

}
