package com.nj.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.nj.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(linkText="Software")
	WebElement softwareText;
	
	@FindBy(linkText="Tablets")
	WebElement tabletsText;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
//		initialize();
	
	}	

	public String getHomePageTitle(){		
		return driver.getTitle();		
	}
	
	public SoftwarePage clickOnSoftwareTab(){		
		softwareText.click();
		return new SoftwarePage();		
	}
	
	public TabletsPage clickOnTabletsTab(){		
		softwareText.click();
		return new TabletsPage();		
	}
}
