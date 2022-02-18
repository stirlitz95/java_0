package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreation extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().fillContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru", "555"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().gotoHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
    app.gotoLogout();
  }

}
