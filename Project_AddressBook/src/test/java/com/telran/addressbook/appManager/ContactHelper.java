package com.telran.addressbook.appManager;

import com.telran.addressbook.model.ContactData;
import com.telran.addressbook.model.GroupData;
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

    public void addContact(){
        initContactCreation();
        fillContactForm(new ContactData("Andrey","Vasiliev","ABS",
                        "321645","123456","a@asd.com"));
        submitContactCreation();
        returnToContactsPage();


    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"),contactData.getFirstName());
        type(By.name("lastname"),contactData.getSurName());
        type(By.name("company"),contactData.getCompany());
        type(By.name("mobile"),contactData.getPhoneNumber());
        type(By.name("work"),contactData.getWorkPhoneNumber());
        type(By.name("email"),contactData.getEmail());
        attach(By.name("photo"),contactData.getPhoto());
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
        click(By.id("MassCB"));
        driver.findElement(By.xpath("//input[@value='Delete']")).click();
        acceptNextAlert = true;
        assertTrue(closeAlertAndGetItsText().matches("^Delete 1 addresses[\\s\\S]$"));

    }

    public void initContactCreation(){ click(By.linkText("add new")); }

    public void submitContactCreation(){ click(By.name("submit")); }

    public void initContactModification(){ click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a/img")); }

    public void updateContactForm(){ click(By.name("update")); }

    public boolean isThereAContact(){ return isElementPresent(By.name("selected[]")); }

    private void returnToContactsPage() { click(By.xpath("//*[contains(text(), 'home')]")); }

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

}
