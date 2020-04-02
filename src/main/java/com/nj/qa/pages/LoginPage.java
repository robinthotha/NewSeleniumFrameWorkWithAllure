package com.nj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.nj.qa.base.TestBase;
import io.qameta.allure.Step;

public class LoginPage extends TestBase{

	LoginPage login;
	HomePage homePage;
	
	@FindBy(xpath="//span[@class='hidden-xs hidden-sm hidden-md'][contains(.,'My Account')]")
	WebElement myAccountLink;
	
/*	@FindBy(xpath="//a[contains(.,'Login')]")
	WebElement loginLink;
*/
	@FindBy(linkText="Login")
	WebElement loginLink;
	
	@FindBy(id="input-email")
	WebElement emailAddress;
	
	@FindBy(id="input-password")
	WebElement pass;
	
	@FindBy(xpath="//input[contains(@class,'btn btn-primary')]")
	WebElement loginButton;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	@Step("Login with Username: {0} and Password: {1} Step..")
	public HomePage login(String username, String password){
		
		myAccountLink.click();
		loginLink.click();
		emailAddress.sendKeys(username);
		pass.sendKeys(password);
		loginButton.click();
		return new HomePage();
		
	}
	@Step("Getting the title of page step..")
	public String loginPageTitle(){
		return driver.getTitle();
	}
	
}
