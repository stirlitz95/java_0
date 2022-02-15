package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletion extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    app.getNavigationHelper().gotoContactPage();
    ////если не существует никакого контакта, то сделай его
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
//      app.getNavigationHelper().gotoContactPage();
    }
    //выбор контакта (на удаление)
    app.getContactHelper().initContactSelected();
    //нажатие кнопки Delite ля удаления выбранного контакта
    app.getContactHelper().deleteSelectedContact();
    // закрытие диалогового окна которое появляется при удалении контакта (поп апное окошко)
    app.getContactHelper().approveDeletion();
  }
}
