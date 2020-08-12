package com.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider1 {
	@DataProvider
	public Object[][]getData()
	{
return new Object[][]
{
	new Object[]
			{
		       "cjc1","pass1"
			},
	new Object[]
			{
		      "cjc2","pass2"
			},};
					
	}
/*	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
	 driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
	 driver.get("https://www.facebook.com/");
	}*/
	@DataProvider
	
	/*public  Object[][]getData()
			{
		Object[][]data=new Object[3][2];
				data [0][0]="cjc1";
				data [0][1]="pass1";
				/*data [1][0]="cjc2";
				data [1][1]="pass2";
				data [2][0]="cjc3";
				data [2][1]="pass3";
				return data;
			}*/
				
				@Test(dataProvider="getData")
				
				public void Loginwithvalid(String us,String ps)
				{
					/*WebElement e=driver.findElement(By.id("email"));
					e.sendKeys("gourigove123@gmail.com");
					
					WebElement pss=driver.findElement(By.name("pass"));
					pss.sendKeys("1234");*/
				}
								
			};
	

				
	

