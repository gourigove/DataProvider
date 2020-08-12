package com.model;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MercuryTours {
	
	
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
		driver=new ChromeDriver();
		
	}
	@BeforeTest
	public void openUrl()
	{
		driver.get("http://demo.guru99.com/test/newtours/");
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		Assert.assertEquals("http://demo.guru99.com/test/newtours/", "http://demo.guru99.com/test/newtours/");
	}
	@BeforeMethod
	public void takeScreenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("Download\\screenshot\\mercury.jpeg"));
		System.out.println("success");
	}
	@Test(dataProvider="getdata")
	public void login(String un,String ps)
	{
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[2]/input")).sendKeys(un);
		driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input")).sendKeys(ps);
	
	driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[4]/td[2]/div/input")).click();
	}
	@DataProvider
	public Object [][] getdata()
	{
		Object [][]data=new Object[2][2];
				data[0][0]="cjc1";
				data[0][1]="pass1";
				data[1][0]="manjusha1";
				data[1][1]="manjusha";
				return data;
	}			
	
	

}
