package com.qa.App.utils;


import com.qa.App.base.BasePage;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumActionWrapper extends BasePage {


    public static void clickElement(WebElement element ) {
        try
        {
            if(IsElementDisplayed(element))
            {
                element.click();
            }else
            {
                throw new ElementNotVisibleException("Element not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean IsElementDisplayed(WebElement element ) {
        boolean status = true;
        try
        {
          status = element.isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
            return status;
    }

    public static void Enter(WebElement element, String text ) {
        try
        {
            if(IsElementDisplayed(element))
            {
                element.sendKeys(text);
            }else
            {
                throw new ElementNotVisibleException("Element not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void Clear(WebElement element) {

        try
        {
            if(IsElementDisplayed(element))
            {
                element.clear();
            }else
            {

                throw new ElementNotVisibleException("Element not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static String GetText(WebElement element) {
        String Text = null;
        try
        {
            if(IsElementDisplayed(element))
            {
               Text = element.getText();
            }else
            {
                throw new ElementNotVisibleException("Element not present");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Text;
    }


    public static void MoveToElement(WebDriver driver, WebElement element) {
        try
        {
            Actions action = new Actions(driver);
            action.moveToElement(element).build().perform();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void NavigateToUrl(WebDriver driver, String Url) {
        try
        {
            driver.get(Url);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String GetCurrentUrl(WebDriver driver) {
        String CurrentUrl = null;
        try
        {
            CurrentUrl = driver.getCurrentUrl();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return CurrentUrl;
    }
    public static void Refresh(WebDriver driver) {
        try
        {
            driver.navigate().refresh();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}