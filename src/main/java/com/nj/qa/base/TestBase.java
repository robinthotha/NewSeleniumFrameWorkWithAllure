package com.nj.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.nj.util.TestUtil;

public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase() {
		
		prop = new Properties();		
		try {
			FileInputStream file = new FileInputStream("D:\\Workspace\\NinjaTutorial\\src\\main\\java\\com\\"
					+ "nj\\qa\\config\\config.properties");
			prop.load(file);
			} catch ( FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}

	public void initialize(){
		String browser =prop.getProperty("browser");
		if(browser.equalsIgnoreCase("CH")){
			System.setProperty("webdriver.chrome.driver", "D:\\Workspace\\NinjaTutorial\\ChromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
		
		}else if(browser.equalsIgnoreCase("FF")){
			System.setProperty("webdriver.gecko.driver", "D:\\Workspace\\NinjaTutorial\\Driver2\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGELOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
		
	}
}
