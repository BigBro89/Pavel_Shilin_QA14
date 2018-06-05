package com.telran.addressbook.tests;

import com.telran.addressbook.model.ContactData;
import org.testng.annotations.Test;

public class ContactModificationTest extends TestBase {

      @Test
      public void testContactModification(){
         app.getNavigationHelper().goToHomePage();
         if(!app.getContactHelper().isThereAContact()){
            app.getContactHelper().addContact();
         }
         app.getContactHelper().initContactModification();
         app.getContactHelper().fillContactForm(new ContactData(null,"Abrvalg","CDE",
                 "09876543","456789","123@box.com"));
         app.getContactHelper().updateContactForm();
         app.getNavigationHelper().goToHomePage();
      }

}
