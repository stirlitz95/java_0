package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() {
    app.getNavigationHelper().gotoGroupPage();
    //получение размеров списка с помощью метода "getGroupList()" до создания группы
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //создали локальную переменную "group" чтобы не дублировать код
    GroupData group = new GroupData("555", null, "555");
    app.getGroupHelper().createGroup(group);
    //получение размеров списка с помощью метода "getGroupList()" после создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //сравниваем размеры списков, должно быть на 1 больше
    Assert.assertEquals(after.size(), before.size() +1);


    //устанавливаем максиммум на какое-то значение, например 0, а потом сравниваем уже найденный максимум с идентификатором каждого элемента и если идентификатор оказываться больше то значит эту переменную максимум увеличиваем, меняем ее значение на новый найденный максимум
    int max = 0;
    for (GroupData g : after){
      //если индетификатор этой группы больше чем текущий найденный максимальный
      if (g.getId() > max){
        //то делает его равным идентификатору этой группы
        max = g.getId();
      }
    }
    //предсказывает идентификатор
    group.setId(max);
    //добавляем в список группу
    before.add(group);
    //сравнивает неупорядоченные списки (множества) / HashSet - реализация множества
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
