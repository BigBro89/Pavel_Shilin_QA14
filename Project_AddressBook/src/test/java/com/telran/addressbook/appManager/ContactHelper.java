package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("lastname"),contactData.getSurName());
        type(By.name("company"),contactData.getCompany());
        type(By.name("mobile"),contactData.getPhoneNumber());
        type(By.name("work"),contactData.getWorkPhoneNumber());
        type(By.name("work"),contactData.getEmail());
        click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void selectContact(){ click(By.name("selected[]")); }

    public void deleteContact() throws InterruptedException {
        click(By.xpath("//input[@value='Delete']"));
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
