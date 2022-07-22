/**
 * 
 */
package com.qa.App.test;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.qa.App.utils.Constants;
import com.qa.App.base.BaseTest;

/**
 * @author sruth
 *
 */
public class HomePageTest extends BaseTest {
	
	@Test(priority = 1)
	public void verifyLoginPageTitleTest()
	{
		String title = HomePage.getLoginPageTitle();
		Assert.assertEquals(title,Constants.LOGIN_PAGETITLE);

}

	@Test(priority = 2)
	public void homePageTitleTest()
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String Title = HomePage.getLoginPageTitle();
		Assert.assertEquals(Title,Constants.LOGIN_PAGETITLE);
	}

	@Test(priority = 3)
	public void contactpageValidateSuccessfulSubmissionofContactForm()
	{
			try {
				Thread.sleep(7000);
			} catch (InterruptedException e) {
				// TODO Auto-generated ()catch block
				e.printStackTrace();
			}
		for(int i=0;i<=5;i++) {
			HomePage.gotoContactPage();
			HomePage.EnterRequiredvalues("Test Forename", "JupiterCloud@jupiter.com", "Test Message");
			HomePage.ClickonSubmit();
			Assert.assertEquals(HomePage.VerifyFormSubmittedSuccessfully(), true);
			HomePage.ClickonBack();
		}
	}
	@Test(priority = 4)
	public void ValidateCartItems()
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.gotoShopPage();
		HomePage.AddFunnyCowtoCart();
		HomePage.AddFunnyCowtoCart();
		HomePage.AddFluffyBunnytoCart(1);
		HomePage.ClickonCart();
		HomePage.VerifyItemsareaddedtoCart();
	}
	@Test(priority = 5)
	public void contactpageValidateErrorTest()
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.gotoContactPage();
		HomePage.ClickonSubmit();
		Assert.assertEquals(HomePage.ValidateErrors(),false);
		HomePage.EnterRequiredvalues("Test Forename","JupiterCloud@jupiter.com","Test Message");
		Assert.assertEquals(HomePage.ValidateErrors(),true);

	}
	@Test(priority = 6)
	public void ValidateCartTotal()
	{
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage.gotoShopPage();
		HomePage.AddStuffedFrogtoCart(2);
		HomePage.AddFluffyBunnytoCart(5);
		HomePage.AddValentineBeartoCart(3);
		double StuffedFrogSubtotal = Double.parseDouble(HomePage.GetStuffedFrogprice().replace("$",""))*2;
		double FluffyBunnySubtotal = Double.parseDouble(HomePage.GetFluffyBunnyprice().replace("$",""))*5;
		double ValentineBearSubtotal = Double.parseDouble(HomePage.GetValentineBearprice().replace("$",""))*3;
		HomePage.ClickonCart();
		HomePage.VerifyCartSubtotals(StuffedFrogSubtotal,FluffyBunnySubtotal,ValentineBearSubtotal);
	}
}
