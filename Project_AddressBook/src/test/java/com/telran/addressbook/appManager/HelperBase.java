package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
    protected WebDriver driver;

    public HelperBase(WebDriver driver) {
        this.driver = driver;
    }

    protected void type(By locator, String text) {
        if(text!=null){
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }
    protected void attach(By locator, File file) {
        if(file!=null){
            driver.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    protected void click(By locator) {
        driver.findElement(locator).click();
    }

    public boolean isElementPresent(By by){
        try{
            driver.findElement(by);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

}
