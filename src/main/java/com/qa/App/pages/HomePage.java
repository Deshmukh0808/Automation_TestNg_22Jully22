package com.qa.App.pages;

import com.qa.App.utils.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import com.qa.App.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class HomePage extends BasePage {
	
	
	private By header = By.cssSelector("h1.private-header_heading");
	private By settingIcon = By.id("navSetting");
	private By accountName = By.className("account-name");
	private By Contact = By.xpath("//a[contains(text(),'Contact')]");
	private By Back = By.xpath("//a[contains(text(),'Back')]");
	private By Shop = By.xpath("//a[contains(text(),'Shop')]");
	private By Submit = By.xpath("//a[contains(text(),'Submit')]");
	private By Forename = By.id("forename");
	private By ForenameError = By.id("forename-err");
	private By Email = By.id("email");
	private By EmailError = By.id("email-err");
	private By Message = By.id("message");
	private By MessageError = By.id("message-err");
	//private By SubmissionSuccessfulMessage = By.xpath("//div[@class='alert alert-success']");
	private By SubmissionSuccessfulMessage = By.xpath("//div[@class='alert alert-success']");
	private By FunnyCowbuy = By.xpath("(//h4[contains(text(),'Funny Cow')]//following::a)[1]");
	private By FluffyBunnybuy = By.xpath("(//h4[contains(text(),'Fluffy Bunny')]//following::a)[1]");
	private By Cart = By.xpath("//a[contains(text(),'Cart')]");
	private By FirstCartItem = By.xpath("((//tr[@class='cart-item ng-scope'])[1]//child::td)[1]");
	private By FirstCartItemQuantity = By.xpath("(//input[@name='quantity'])[1]");
	private By SecondCartItem = By.xpath("((//tr[@class='cart-item ng-scope'])[1]//child::td)[2]");
	private By SecondCartItemQuantity = By.xpath("(//input[@name='quantity'])[2]");
	private By FluffyBunnyprice = By.xpath("(//h4[contains(text(),'Fluffy Bunny')]//following::span)[1]");
	private By StuffedFrogbuy = By.xpath("(//h4[contains(text(),'Stuffed Frog')]//following::a)[1]");
	private By StuffedFrogprice = By.xpath("(//h4[contains(text(),'Stuffed Frog')]//following::span)[1]");
	private By ValentineBearbuy = By.xpath("(//h4[contains(text(),'Valentine Bear')]//following::a)[1]");
	private By ValentineBearprice = By.xpath("(//h4[contains(text(),'Valentine Bear')]//following::span)[1]");
	private By FirstCartItemSubtotal = By.xpath("((//tr[@class='cart-item ng-scope'])[1]//child::td)[4]");
	private By SecondCartItemSubtotal = By.xpath("((//tr[@class='cart-item ng-scope'])[2]//child::td)[4]");
	private By ThirdCartItemSubtotal = By.xpath("((//tr[@class='cart-item ng-scope'])[3]//child::td)[4]");
	private By CartTotal = By.xpath("//strong[contains(text(),'Total:')]");

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public String getHeaderValue()
	{
		if(driver.findElement(header).isDisplayed())
		{
			return driver.findElement(header).getText();
		
		}
		
		return null;
	}
	
	public boolean isSettingsIconExist()
	{
		if(driver.findElements(settingIcon).size()>0){
			return true;
		}
		return false;
	}

	public String getAccountNameValue()
	{
		if(driver.findElement(accountName).isDisplayed())
		{
			return driver.findElement(accountName).getText();
		
		}
		
		return null;
	}

	public void AddFluffyBunnytoCart()
	{
		driver.findElement(FluffyBunnybuy).click();
	}

	public String getLoginPageTitle()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return driver.getTitle();
	}

	public void gotoContactPage()
	{
		driver.findElement(Contact).click();
	}
	public void ClickonBack()
	{
		driver.findElement(Back).click();
	}

	public void gotoShopPage()
	{
		driver.findElement(Shop).click();
	}

	public void ClickonSubmit()
	{
		driver.findElement(Submit).click();
	}
	public boolean ValidateErrors() {
		try {
			if (driver.findElement(ForenameError).isDisplayed() || driver.findElement(EmailError).isDisplayed() || driver.findElement(MessageError).isDisplayed()) {
				return false;
			}
		} catch (NoSuchElementException e) {
			return true;
		}
		return true;
	}
	public void EnterRequiredvalues(String forename, String email, String message)
	{
		driver.findElement(Forename).sendKeys(forename);
		driver.findElement(Email).sendKeys(email);
		driver.findElement(Message).sendKeys(message);
	}
	public boolean VerifyFormSubmittedSuccessfully()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			if (driver.findElement(SubmissionSuccessfulMessage).isDisplayed()) {
				return true;
			} else {
				return false;
			}
	}

	public void AddFunnyCowtoCart()
	{
		driver.findElement(FunnyCowbuy).click();
	}
	public void AddFluffyBunnytoCart(int a)
	{
		for(int i =1; i<=a; i++) {
			driver.findElement(FluffyBunnybuy).click();
		}
	}
	public void AddValentineBeartoCart(int a)
	{
		for(int i =1; i<=a; i++) {
			driver.findElement(ValentineBearbuy).click();
		}
	}
	public void AddStuffedFrogtoCart(int a)
	{
		for(int i =1; i<=a; i++) {
			driver.findElement(StuffedFrogbuy).click();
		}
	}
	public String GetValentineBearprice()
	{
		return driver.findElement(ValentineBearprice).getText();
	}
	public String GetStuffedFrogprice()
	{
		return driver.findElement(StuffedFrogprice).getText();
	}
	public String GetFluffyBunnyprice()
	{
		return driver.findElement(FluffyBunnyprice).getText();
	}
	public void ClickonCart()
	{
		driver.findElement(Cart).click();
	}
	public boolean VerifyItemsareaddedtoCart()
	{
		String firstcartitem = driver.findElement(FirstCartItem).getText();
		String firstcartitemquantity = driver.findElement(FirstCartItemQuantity).getText();
		String secondcartitem = driver.findElement(SecondCartItem).getText();
		String secondcartitemquantity = driver.findElement(SecondCartItemQuantity).getText();
		if(firstcartitem == "FunnyCow" && firstcartitemquantity == "2" && secondcartitem == "FluffyBunny" && secondcartitemquantity == "1"){
			return true;
		}else{
			return false;
		}
	}
	public void VerifyCartSubtotals(double subtotal1, double subtotal2, double subtotal3)
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double Total = subtotal1+subtotal2+subtotal3;
		String firstcartitemsubtotal = driver.findElement(FirstCartItemSubtotal).getText();
		String secondcartitemsubtotal = driver.findElement(SecondCartItemSubtotal).getText();
		String thirdcartitemsubtotal = driver.findElement(ThirdCartItemSubtotal).getText();
		Assert.assertEquals(firstcartitemsubtotal.replace("$",""),String.valueOf(subtotal1));
		Assert.assertEquals(secondcartitemsubtotal.replace("$",""),String.valueOf(subtotal2));
		Assert.assertEquals(thirdcartitemsubtotal.replace("$",""),String.valueOf(subtotal3));
		Assert.assertEquals(String.valueOf(Total),driver.findElement(CartTotal).getText().replace("Total: ",""));
	}

}
