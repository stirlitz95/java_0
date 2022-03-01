package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
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
    ContactData contact = new ContactData( before.get(before.size() -1).getId(), "ИмяНовое", null, "ФамилияНовая", null, null, null);
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

//    before.remove(before.size() - 1); // с этой строчкой не работает
//    before.add(contact); //с этой строчкой не работает
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
