package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDelettionTests extends TestBase {

  @Test
  public void testGroupDelettion() {
    app.getNavigationHelper().gotoGroupPage();
    //получаем список групп до удаления
    int before = app.getGroupHelper().getGroupCount();
    //если не существует никакой группы, то сделай ее
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("555", null, "555"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    ////получаем список групп после удаления
    int after = app.getGroupHelper().getGroupCount();
    //выполняем проверку, что количество групп уменьшилось на 1
    Assert.assertEquals(after, before - 1);
  }

}
