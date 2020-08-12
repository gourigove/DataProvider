package com.model;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo {
	
	@BeforeSuite
	public void openBrowser()
	{
		System.out.println("openbrowser");
		System.out.println("success");
	}
	@BeforeTest
	public void enterUrl()
	{
		System.out.println("url");
		System.out.println("success");
	}
	@BeforeClass
	public void  maximizePage()
	{
		System.out.println("Maximize");
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("cookies");
	}
	@Test
	public void loginTest()
	{
		System.out.println("login success");
	}
	@AfterMethod
	public void captureScrrenshot()
	{
		System.out.println("scrreenshot");
	}
	@AfterClass
	public void deleteCookie()
	{
		System.out.println("delete cookie");
	}
	@AfterTest
	public void dbClose() {
		System.out.println("db close");
	}
	@AfterSuite
	public void closeWindow()
	{
		System.out.println("closewindow");
	}
	
	
		
	
	
	
	

}

