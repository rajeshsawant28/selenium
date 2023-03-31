package com.agilecrm1.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public FileInputStream fis=null;
	public Properties prop=null;
	public WebDriver driver=null;
	
	public BaseClass()
	{
		String fileName=System.getProperty("user.dir")+"\\src\\main\\resources\\config.feature";  
		
		try 
		{
			fis=new FileInputStream(fileName);
            prop=new Properties();
            prop.load(fis);
			
		} catch (FileNotFoundException e) 
		{
			
			e.printStackTrace();
			
			throw new RuntimeException("File Not Found : "+fileName);
		} catch (IOException e) {
			
			e.printStackTrace();
			throw new RuntimeException("Error in Loading propertise File : "+fileName);
			
		}
		
	}
	
	// initialization of browser and url to launch
	public void inIt()
	{
		String browserName=prop.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver(); 
		}
		else 
			throw new RuntimeException("Invalid Browser"+browserName);
		
		String URL=prop.getProperty("url");
		driver.get(URL);
		
		int timeout=Integer.parseInt(prop.getProperty("timeout"));
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
		
		boolean maximize=Boolean.parseBoolean(prop.getProperty("maximize"));
		if(maximize)    //maximize=true
			
			driver.manage().window().maximize();
			
	}

}
