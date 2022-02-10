package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModification extends TestBase {

  @Test
  public void testEditContact() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    //выбор контакта на изменение (нажание сразу на значек изменения нужного контакта)
    app.getContactHelper().initContactEdit();
    //внесение изменений в выбранный контакт
    app.getContactHelper().editContact("ИмяНовое", "ОтчeствоНовое", "ФамилияНовое", "880005550000", "yyy.ru");
    //фиксирование изменений нажатием кнопки "update"
    app.getContactHelper().updateContact();
//    app.returnToContactPage(); //без это строчки работает без ошибки
  }

}
