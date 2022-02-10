package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.gotoAddNew();
    app.fillContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
    app.submitContact();
    app.gotoHome();
    app.gotoLogout();
  }

}
