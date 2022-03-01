package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDelettionTests extends TestBase {

  @BeforeMethod
  //выделили отдельно выполнение предусловий
  public void ensurePreconditions(){
    //переходим на станицу с группами
    app.goTo().groupPage();
    //если список групп пустой то нужно создать группу
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData("555", null, "555"));
    }
  }

  @Test
  public void testGroupDelettion() {
    //получение размеров списка с помощью метода "getGroupList()" до создания группы
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    app.group().delete(index);
    //получение размеров списка с помощью метода "getGroupList()" после создания группы
    List<GroupData> after = app.group().list();
    //выполняем проверку, что количество групп уменьшилось на 1
    Assert.assertEquals(after.size(), before.size() - 1);

    //теперь должно получиться два одинаковых списка, поскольку переменная before ссылается не на оригинальный (старый) список
    //а на старый список в котором удален ненужный элемент (удаляем старое по индексу "(before.size() - 1)")
    before.remove(index); //теперь старый список должен содержать то же самое, что и новый
    //теперь сравниваются два списка, новый и тот что переопределили как старый "before.remove(before.size() - 1)"
    Assert.assertEquals(before, after);

  }



}
