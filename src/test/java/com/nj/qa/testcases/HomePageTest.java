package com.nj.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.nj.qa.base.TestBase;
import com.nj.qa.pages.HomePage;
import com.nj.qa.pages.LoginPage;
import com.nj.qa.pages.SoftwarePage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	SoftwarePage softwarePage;
	LoginPage login;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() throws InterruptedException{
		
		initialize();
		login = new LoginPage();
		homePage=login.login(prop.getProperty("email"), prop.getProperty("pass"));
		Thread.sleep(5000);;		
	}
	
	@Test(priority=1, description="To verify title of Home Page")
	@Severity(SeverityLevel.CRITICAL)
	@Description("Test Description: User should be able to verify the test")
	@Story("Name of Story: To check page title")
	public void getHomePageTitleTest(){
		String title=homePage.getHomePageTitle();
		Assert.assertEquals(title, "My Account", "Title not matched");
	}
	
	@Test(priority=2, description="To verify click on Software tab")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Description: User should be able to click on Software tab")
	@Story("Name of Story: To click on Software tab")
	public void clickOnSoftwareTabTest(){
		softwarePage=homePage.clickOnSoftwareTab();
		
	}
	
	@AfterMethod
	public void tearDown(){
		
		driver.quit();
	}
}
