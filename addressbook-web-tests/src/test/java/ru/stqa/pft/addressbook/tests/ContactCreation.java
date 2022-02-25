package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactCreation extends TestBase{

  @Test
  public void testNewContact() throws Exception {
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().gotoAddNew();
    app.getContactHelper().fillContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru", "555"), true);
    app.getContactHelper().submitContact();
    app.getNavigationHelper().gotoContactPage();
    List<ContactData> after = app.getContactHelper().getContactList();
    //проверка:размер списка после добавления равен размер списка +1
    Assert.assertEquals(after.size(), before.size() +1 );
    app.gotoLogout();
  }
}
