package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class GroupDelettionTests extends TestBase{



  @Test
  public void testGroupDelettion() throws Exception {
    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupPage();
  }

}
