package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDelettionTests extends TestBase{

  @Test
  public void testGroupDelettion() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
  }

}
