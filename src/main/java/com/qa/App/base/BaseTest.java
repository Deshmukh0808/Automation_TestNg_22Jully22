package com.qa.App.base;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.qa.App.pages.*;

public class BaseTest {

	public BasePage basepage;
	public Properties prop;
	public WebDriver driver;
	public HomePage HomePage;

	@BeforeTest
	public void setUp()
	{
		basepage = new BasePage();
		prop = basepage.init_prop();
		FileReader reader= null;
		try {
			reader = new FileReader(System.getProperty("user.dir")+"\\src\\main\\java\\com\\qa\\App\\config\\config.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties p=new Properties();
		try {
			p.load(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String browser = p.getProperty("browser");
		driver = basepage.init_driver(browser);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		HomePage = new HomePage(driver);
		driver.get(prop.getProperty("url"));
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}
