package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertTrue;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver driver){
        super(driver);
    }

    private boolean acceptNextAlert = true;

    public void addContact(ContactData contactData){
        click(By.linkText("add new"));
        //driver.findElement(By.linkText("add new")).click();
        type(By.name("firstname"),contactData.getFirstName());
//        driver.findElement(By.name("firstname")).click();
//        driver.findElement(By.name("firstname")).clear();
//        driver.findElement(By.name("firstname")).sendKeys(contactData.getFirstName());
        type(By.name("lastname"),contactData.getSurName());
//        driver.findElement(By.name("lastname")).click();
//        driver.findElement(By.name("lastname")).clear();
//        driver.findElement(By.name("lastname")).sendKeys(contactData.getSurName());
        type(By.name("company"),contactData.getCompany());
//        driver.findElement(By.name("country")).click();
//        driver.findElement(By.name("country")).clear();
//        driver.findElement(By.name("country")).sendKeys(contactData.getCountry());
        type(By.name("mobile"),contactData.getPhoneNumber());
//        driver.findElement(By.name("mobile")).click();
//        driver.findElement(By.name("mobile")).clear();
//        driver.findElement(By.name("mobile")).sendKeys(contactData.getPhoneNumber());
        type(By.name("work"),contactData.getWorkPhoneNumber());
//        driver.findElement(By.name("work")).click();
//        driver.findElement(By.name("work")).clear();
//        driver.findElement(By.name("work")).sendKeys(contactData.getWorkPhoneNumber());
        type(By.name("work"),contactData.getEmail());
//        driver.findElement(By.name("email")).click();
//        driver.findElement(By.name("email")).clear();
//        driver.findElement(By.name("email")).sendKeys(contactData.getEmail());
        click(By.xpath("(//input[@name='submit'])[2]"));
//        driver.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void selectContact(){
        driver.findElement(By.name("selected[]")).click();
    }

    public void deleteContact() throws InterruptedException {
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        acceptNextAlert = true;
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));
        TimeUnit.SECONDS.sleep(5);

    }
    public int getContactCount() {
        return driver.findElements(By.name("selected[]")).size();
    }

    public void deleteAllContacts() {
        driver.findElement(By.id("MassCB")).click();
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        acceptNextAlert = true;
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));

    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
    public void initContactModification(){
       // driver.findElement(By.xpath("//*[@id="maintable"]/tbody/tr[2]/td[8]/a"))
    }
}
