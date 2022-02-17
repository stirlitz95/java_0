package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    app.getNavigationHelper().gotoGroupPage();
    //получаем список групп до модификации
    int before = app.getGroupHelper().getGroupCount();
    //если не существует никакой группы, то сделай ее
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("555", null, "555"));
    }
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().initGroupModification();
    app.getGroupHelper().fillGroupFrom(new GroupData("666", "666", "666"));
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    ////получаем список групп после модификации
    int after = app.getGroupHelper().getGroupCount();
    //выполняем проверку, что количество групп должно совпадать с начальным количеством
    Assert.assertEquals(after, before);

  }
}
