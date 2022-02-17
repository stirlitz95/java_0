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


    //список превращаем в поток "after.stream()", по этому потоку пробегается функция сравниватель и находит максимальный элемент "max((o1, o2) -> Integer.compare(o1.getId(), o2.getId()))", на выходе этой функции будет группа с максимальным идентификатором, остается тольво взять ее идентификатор "get().getId()"
    //int max1 = after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId(); // удалил за ненадобностью, оставил для нашлядности

    //предсказывает идентификатор
    group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    //добавляем в список группу
    before.add(group);
    //сравнивает неупорядоченные списки (множества) / HashSet - реализация множества
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }
}
