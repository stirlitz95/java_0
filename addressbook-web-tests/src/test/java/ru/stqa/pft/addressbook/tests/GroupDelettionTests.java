package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDelettionTests extends TestBase {

  @Test
  public void testGroupDelettion() {
    app.getNavigationHelper().gotoGroupPage();
    //если не существует никакой группы, то сделай ее
    if (!app.getGroupHelper().isThereAGroup()) {
      app.getGroupHelper().createGroup(new GroupData("555", null, "555"));
    }
    //получение размеров списка с помощью метода "getGroupList()" до создания группы
    List<GroupData> before = app.getGroupHelper().getGroupList();
    app.getGroupHelper().selectGroup(before.size() - 1);
    app.getGroupHelper().deleteSelectedGroups();
    app.getGroupHelper().returnToGroupPage();
    //получение размеров списка с помощью метода "getGroupList()" после создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //выполняем проверку, что количество групп уменьшилось на 1
    Assert.assertEquals(after.size(), before.size() - 1);

    //теперь должно получиться два одинаковых списка, поскольку переменная before ссылается не на оригинальный (старый) список
    //а на старый список в котором удален ненужный элемент (удаляем старое по индексу "(before.size() - 1)")
    before.remove(before.size() - 1); //теперь старый список должен содержать то же самое, что и новый
    //теперь сравниваются два списка, новый и тот что переопределили как старый "before.remove(before.size() - 1)"
    Assert.assertEquals(before, after);

  }

}
