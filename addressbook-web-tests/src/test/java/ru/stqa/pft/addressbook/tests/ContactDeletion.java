package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    app.gotoContactPage();
    //выбор контакта (на удаление)
    app.initContactSelected();
    //нажатие кнопки Delite ля удаления выбранного контакта
    app.deleteSelectedContact();
    //закрытие диалогового окна которое появляется при удалении контакта
    app.returnToContactPage();
  }


}
