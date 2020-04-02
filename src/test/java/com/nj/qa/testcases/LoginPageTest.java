package com.nj.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.nj.qa.base.TestBase;
import com.nj.qa.pages.HomePage;
import com.nj.qa.pages.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;


public class LoginPageTest extends TestBase{
	
	LoginPage login;
	HomePage homePage;
	
	public LoginPageTest(){		
		super();		
	}
	
	@BeforeMethod
	public void setup(){		
		initialize();
		login = new LoginPage();
	}
	
	@Test(priority=1, description="Verify title of Login Page")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: To verify the title of Login Page")
	@Story("Story Name: To check the title of login page")
	public void verifyTitleTest(){
		String title=login.loginPageTitle();
		Assert.assertEquals(title, "The Ninja Store", "Title not matched");
	}
	

	@Test(priority=2, description="Verify User is able to login to application with Correct Username and Password")
	@Severity(SeverityLevel.NORMAL)
	@Description("Test Case Description: Verify User is able to login to application with Correct Username and Password")
	@Story("Story Name: To check the successful login")
	public void validCredentialsloginTest(){		
		homePage=login.login(prop.getProperty("email"),prop.getProperty("pass"));
	}
	
	@AfterMethod
	public void tearDown(){		
		driver.quit();
	}
}
