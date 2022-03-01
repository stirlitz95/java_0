package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreation extends TestBase {

  @Test
  public void testNewContact() throws Exception {
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNew();
    ContactData contact = new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru", "555");
    app.getContactHelper().fillContact((contact), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    //проверка:размер списка после добавления равен размер списка +1
    Assert.assertEquals(after.size(), before.size() + 1);
    app.gotoLogout();

    //предсказывает идентификатор
    contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
    //добавляем в список группу
    before.add(contact);
    //функция для сравнения объектов по идентификатору
    Comparator<? super ContactData> byId=  (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    //сортируем старый список
    before.sort(byId);
    //сортируем новый список
    after.sort(byId);
    //сравнивает два списка упорядоченные по нашим правилам (и упорядочены одинаково)
    Assert.assertEquals(before, after);
  }
}
