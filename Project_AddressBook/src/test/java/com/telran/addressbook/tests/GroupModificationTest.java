package com.telran.addressbook.tests;

import com.telran.addressbook.model.GroupData;
import org.testng.annotations.Test;

public class GroupModificationTest extends TestBase {

    @Test
    public void testGroupModification(){
        app.getNavigationHelper().goToGroupsPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().initGroupModification();
        app.getGroupHelper().fillGroupForm(new GroupData(null,"NotNew","smth"));
        app.getGroupHelper().confirmGroupModification();
        app.getNavigationHelper().goToGroupsPage();
    }
}
