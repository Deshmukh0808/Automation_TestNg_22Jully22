package com.qa.App.utils;


import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {


    public static void untilElement(WebDriver webDriver, WebElement wb, long timeOutInSeconds, String type) {

        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        switch (type) {
            case "CLICKABLE":
                wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(wb));
            case "VISIBLE":
                wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(wb));
            default:
                wait.ignoring(StaleElementReferenceException.class).until(ExpectedConditions.visibilityOf(wb));
        }

    }
}