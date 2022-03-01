package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModification extends TestBase {

  @Test
  public void testEditContact() throws Exception {
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //если не существует никакого контакта, то сделай его
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
    }
    //проверяем кол-во контактов до модификации
    List<ContactData> before = app.getContactHelper().getContactList();
    //выбор контакта на изменение (нажание сразу на значек изменения нужного контакта)
    app.getContactHelper().initContactEdit();
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "ИмяНовое", null, "ФамилияНовая", null, null, null);
    //внесение изменений в выбранный контакт
    app.getContactHelper().fillContact((contact), false);
    //фиксирование изменений нажатием кнопки "update"
    app.getContactHelper().updateContact();
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //проверяем кол-во контактов после после модификации
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравниваем кол-во контактов до и после модификации
    Assert.assertEquals(after.size(), before.size());

    //пишем лямбда выражение, это будет анонимная функция которая принимает на вход два параметра (два контакта которые буде сравнивать) (g1, g2), и выполняем сравнение идентификаторов "-> Integer.compare(g1.getId(), g2.getId())" - это будет возвращаемый результат функции
    Comparator<? super ContactData> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //первый список
    before.sort(byId);
    //второй список
    after.sort(byId);
    //сравнивает два списка упорядоченные по нашим правилам (и упорядочены одинаково)
    Assert.assertEquals(before, after);
  }

}
