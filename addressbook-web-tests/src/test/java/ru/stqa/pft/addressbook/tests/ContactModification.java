package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModification extends TestBase {

  @Test
  public void testEditContact() throws Exception {
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //если не существует никакого контакта, то сделай его
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
    }
    //проверяем кол-во контактов до модификации
    int before = app.getContactHelper().getContactCount();
    //выбор контакта на изменение (нажание сразу на значек изменения нужного контакта)
    app.getContactHelper().initContactEdit();
    //внесение изменений в выбранный контакт
    app.getContactHelper().fillContact(new ContactData("ИмяНовое", "ОтчeствоНовое", "ФамилияНовое", "880005550000", "yyy.ru", null), false);
    //фиксирование изменений нажатием кнопки "update"
    app.getContactHelper().updateContact();
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //проверяем кол-во контактов после после модификации
    int after = app.getContactHelper().getContactCount();
    //сравниваем кол-во контактов до и после модификации
    Assert.assertEquals(after, before);
  }

}
