package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().fillContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru", "555"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().gotoHome();
    app.gotoLogout();
  }

}
