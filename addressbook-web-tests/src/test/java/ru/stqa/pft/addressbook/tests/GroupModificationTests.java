package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;

public class GroupModificationTests extends TestBase {

  @BeforeMethod
  //выделили отдельно выполнение предусловий
  public void ensurePreconditions() {
    //переходим на станицу с группами
    app.goTo().groupPage();
    //если список групп пустой то нужно создать группу
    if (app.group().list().size() == 0) {
      app.group().create(new GroupData().withName("555"));
    }
  }

  @Test
  public void testGroupModification() {

    //получение размеров списка с помощью метода "getGroupList()" до создания группы
    List<GroupData> before = app.group().list();
    int index = before.size() - 1;
    //создали локальную переменную "group" чтобы не дублировать код / при модификации гуппы мы указываем новые имя, хедер, футер, а индентификатор "before.get(before.size() - 1).getId()" оставляем старый
    GroupData group = new GroupData().withId(before.get(index).getId()).withName("666").withHeader("666").withFooter("666");
    app.group().modifi(index, group);
    //получение размеров списка с помощью метода "getGroupList()" после создания группы
    List<GroupData> after = app.group().list();
    //выполняем проверку, что количество групп должно совпадать с начальным количеством
    Assert.assertEquals(after.size(), before.size());

    //удаляем старый элемент
    before.remove(index);
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
