package com.telran.addressbook.appManager;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class ApplicationManager {

    private WebDriver driver;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private NavigationHelper navigationHelper;


    public void init() {
        driver = new ChromeDriver();
//        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        contactHelper = new ContactHelper(driver);
        openAddressbook("http://localhost/addressbook/");
        login("admin", "secret");
    }

    public void terminate() {
            driver.quit();
    }

    public void login(String userName, String pwd) {
      driver.findElement(By.name("user")).click();
      driver.findElement(By.name("user")).clear();
      driver.findElement(By.name("user")).sendKeys(userName);
      driver.findElement(By.name("pass")).clear();
      driver.findElement(By.name("pass")).sendKeys(pwd);
      driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    public void openAddressbook(String url) {
      driver.get(url);
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public ContactHelper getContactHelper() {
        return contactHelper;
    }

}
