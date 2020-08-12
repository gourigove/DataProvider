package com.model;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderMercury {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\Testing\\chromedriver.exe");
	 driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
	 driver.get("http://newtours.demoaut.com/mercurysignon.php");
	}
	@BeforeClass
	public void  maximizePage()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("get cookies");
		Set<Cookie>se=driver.manage().getCookies();
		int count=se.size();
		for(Cookie cookie:se)
		{
			System.out.println("All"+cookie.getName());
		}
			
	}
	@Test(dataProvider="getdata")
	public void registerpage(String username,String password)
	{
		
		driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(1) > td:nth-child(2) > input")).sendKeys(username);
		
		driver.findElement(By.cssSelector("body > div > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(4) > td > table > tbody > tr > td:nth-child(2) > table > tbody > tr:nth-child(5) > td > form > table > tbody > tr:nth-child(2) > td:nth-child(2) > input[type=password]")).sendKeys(password);
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td/input")).click();
		driver.findElement(By.linkText("SIGN-OFF")).click();
		
	}
	/*@AfterMethod
	public void captureScrrenshot() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:\\Second\\fb.jpeg"));
		System.out.println("success");
	}*/
	@AfterClass
	public void deleteCookie()
	{
		driver.manage().deleteAllCookies();
		
	}
	@AfterTest
	public void dbClose() {
		System.out.println("db close");
	}
	@AfterSuite
	public void closeWindow()
	{
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.close();
	}
	@DataProvider
	public Object[][]getdata()
	{
		
		
		Object[][]data=new Object[2][2];
		data[0][0]="manjusha1";
		data[0][1]="manjusha";
		
		data[1][0]="manjusha2";
		data[1][1]="manjusha";
		
		
		return data;
		
	}

}
