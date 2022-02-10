package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeletion extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    //выбор контакта (на удаление)
    app.getContactHelper().initContactSelected();
    //нажатие кнопки Delite ля удаления выбранного контакта
    app.getContactHelper().deleteSelectedContact();
  }
}
