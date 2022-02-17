package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //получаем список групп до создания
    int before = app.getGroupHelper().getGroupCount();
    app.getGroupHelper().createGroup(new GroupData("555", null, "555"));
    //получаем список групп после создания
    int after = app.getGroupHelper().getGroupCount();
    //выполняем проверку, что количество групп увеличилось на 1
    Assert.assertEquals(after, before +1);
  }
}
