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

public class DataProviderWay2automation {
	public WebDriver driver;
	@BeforeSuite
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
	 driver=new ChromeDriver();
	}
	@BeforeTest
	public void enterUrl()
	{
	 driver.get("http://way2automation.com/way2auto_jquery/index.php");
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
	public void registerpage(String name,String phone,String email,String country,String city,String username,String password)
	{

		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(name);
		
		driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys(phone);
		
		driver.findElement(By.xpath("//input[@name=\"email\"]")).sendKeys(email);
		
		WebElement country1=driver.findElement(By.xpath("//select[@name=\"country\"]"));
		Select s=new Select(country1);
		s.selectByIndex(3);
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[5]/input")).sendKeys(city);
		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[6]/input")).sendKeys(username);

		driver.findElement(By.xpath("//*[@id=\"load_form\"]/fieldset[7]/input")).sendKeys(password);
		
		driver.findElement(By.xpath("/html/body/div[4]/div/div/div/div/div/form/div/div[2]/input")).click();
		
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
		
		
		Object[][]data=new Object[2][7];
		data[0][0]="cjc";
		data[0][1]="65656756756";
		data[0][2]="gourigove321@gmail.com";
		data[0][3]="india";
		data[0][4]="pune";
		data[0][5]="gourigove321@gmail.com";
		data[0][6]="240693gove";
		
	
		data[1][0]="cjc1";
		data[1][1]="656567567567676";
		data[1][2]="gourigove321@gmail.com";
		data[1][3]="india";
		data[1][4]="mumbai";
		data[1][5]="gourigove321@gmail.com";
		data[1][6]="240693gove";
		
		
		return data;
		
		
	}
	
	
		
	
	
	
	

}

