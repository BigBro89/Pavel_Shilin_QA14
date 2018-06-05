package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;


public class CreateContactsTest extends TestBase {


    @Test
    public void addingContact(){
        app.getNavigationHelper().goToHomePage();
        int before = app.getContactHelper().getContactCount();
        app.getContactHelper().addContact();
        int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after,before+1);
    }
    @Test
    public void addingContactWithoutEmail(){
        app.getContactHelper().addContact();
    }
    @Test
    public void addingContactWithoutPhone(){
        app.getContactHelper().addContact();
    }

    @Test
    public void createContactWithPhoto(){
        app.getNavigationHelper().goToHomePage();
        app.getContactHelper().initContactCreation();
        File photo = new File("src/System.png");

        app.getContactHelper().fillContactForm(new ContactData().withFName("Oleg")
                                                                .withSurName("Yen").wihtCompany("ABC")
                                                                .phoneNumber("12345").withWorkPhoneNumber("67890")
                                                                .withPhoto(photo));
        app.getContactHelper().submitContactCreation();
    }

}
