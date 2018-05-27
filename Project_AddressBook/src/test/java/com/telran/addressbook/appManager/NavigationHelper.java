package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.jvm.hotspot.interpreter.BytecodeJsr;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupsPage() {
        if(isElementPresent(By.tagName("h1"))
                && driver.findElement(By.tagName("h1")).getText().equalsIgnoreCase("Groups")
                && isElementPresent(By.name("edit"))){
            return;
        }
        click(By.linkText("groups")); }

    public void goToHomePage(){
        driver.findElement(By.cssSelector("#nav > ul > li:nth-child(1) > a"));
    }


}
