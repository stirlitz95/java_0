package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {


  @Test
  public void testGroupCreation() throws Exception {
    gotoGroupPage();
    initGroupCreation();
    fillGroupFrom(new GroupData("555", "555", "555"));
    submitGroupCreation();
    returnToGroupPage();
  }

}
