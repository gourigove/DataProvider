              

package com.model;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryRegister {
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
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		Set<Cookie>se=driver.manage().getCookies();
		for(Cookie Cookie:se)
		{
			System.out.println("All cookies"+Cookie.getName());
		}
	}
	@Test(dataProvider="getdata")
	public void registerPage(String fn,String ln,String pn,String em,String add,String city,String state,String code,String country,String un,String pass,String cps)
    {
		
		driver.findElement(By.cssSelector("input[name=\"firstName\"]")).sendKeys(fn);
		
		driver.findElement(By.cssSelector("input[name=\"lastName\"]")).sendKeys(ln);
	
		driver.findElement(By.cssSelector("input[name=\"phone\"]")).sendKeys(pn);
		
	driver.findElement(By.cssSelector("input[name='userName']")).sendKeys(em);;
		
	driver.findElement(By.cssSelector("input[name=address1]")).sendKeys(add);
	
	driver.findElement(By.cssSelector("input[name=\"city\"]")).sendKeys(city);
	driver.findElement(By.cssSelector("input[name=\"state\"]")).sendKeys(state);
	driver.findElement(By.cssSelector("input[name=\"postalCode\"")).sendKeys(code);;
		WebElement br=driver.findElement(By.xpath("//select[@name=\"country\"]/parent::td"));
		Select s12=new Select(br);
		s12.selectByVisibleText("TONGA");
		
		/*WebElement s11=driver.findElement(By.cssSelector("select[name=\"country\"]"));
		Select s12=new Select(s11);
		s12.selectByVisibleText("ARUBA");*/
		driver.findElement(By.cssSelector("input[name=\"email\"]")).sendKeys(un);
		driver.findElement(By.cssSelector("input[name=\"password\"]")).sendKeys(pass);
		driver.findElement(By.cssSelector("input[name=\"confirmPassword\"]")).sendKeys(cps);
		driver.findElement(By.cssSelector("input[type=\"image\"]")).click();
		driver.findElement(By.cssSelector("a[href=\"mercurysignon.php\"]")).click();
	driver.findElement(By.cssSelector("input[name=\"userName")).sendKeys(un);
    }
	@DataProvider
	public Object[][]getdata()
	{
		
		
		Object[][]data=new Object[1][12];
		data[0][0]="Gouri";
		data[0][1]="Gove";
		data[0][0]="645743574";
		data[0][1]="gourigove321@gmail.com";
		data[0][0]="karvenagar";
		data[0][1]="Pune";
		data[0][0]="Maharashtra";
		data[0][1]="6643767";
		data[0][0]="india";
		data[0][1]="gourigove321@gmail.com\"";
		data[0][0]="1234";
		data[0][1]="1234";
		return data;
		
	}



	}
	


