package com.telran.addressbook.appManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver driver) {
        super(driver);
    }

    public void goToGroupsPage() { click(By.linkText("groups")); }

    public void returnToGroupsPage() { click(By.linkText("group page")); }

}
