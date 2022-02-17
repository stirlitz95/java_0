package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @Test
  public void testGroupModification () {
    app.getNavigationHelper().gotoGroupPage();
    //если не существует никакой группы, то сделай ее
    if (! app.getGroupHelper().isThereAGroup()){
      app.getGroupHelper().createGroup(new GroupData("555", null, "555"));
    }
    //получение размеров списка с помощью метода "getGroupList()" до создания группы
    List<GroupData> before = app.getGroupHelper().getGroupList();
    //метод берет последнюю группу по индексу "before.size() - 1" ( "- 1" потому что нумерация начинается с "0")
    app.getGroupHelper().selectGroup(before.size() - 1);
    //выбираем группу которую далее будем менять
    app.getGroupHelper().initGroupModification();
    //создали локальную переменную "group" чтобы не дублировать код / при модификации гуппы мы указываем новые имя, хедер, футер, а индентификатор "before.get(before.size() - 1).getId()" оставляем старый
    GroupData group = new GroupData(before.get(before.size() - 1).getId(),"666", "666", "666");
    app.getGroupHelper().fillGroupFrom(group);
    app.getGroupHelper().submitGroupModification();
    app.getGroupHelper().returnToGroupPage();
    //получение размеров списка с помощью метода "getGroupList()" после создания группы
    List<GroupData> after = app.getGroupHelper().getGroupList();
    //выполняем проверку, что количество групп должно совпадать с начальным количеством
    Assert.assertEquals(after.size(), before.size());

    //удаляем старый элемент
    before.remove(before.size() - 1);
    //добавляем новый элемент который должен появится появиться после модификации "group"
    before.add(group);
    //пишем лямбда выражение, это будет анонимная функция которая принимает на вход два параметра (две группы которые буде сравнивать) (g1, g2), и выполняем сравнение идентификаторов "-> Integer.compare(g1.getId(), g2.getId())" - это будет возвращаемый результат функции
    Comparator<? super GroupData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //первый список
    before.sort(byId);
    //второй список
    after.sort(byId);
    //сравнивает два списка упорядоченные по нашим правилам (и упорядочены одинаково)
    Assert.assertEquals(before, after);
  }
}
