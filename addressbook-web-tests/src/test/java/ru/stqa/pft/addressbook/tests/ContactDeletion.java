package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletion extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //если не существует никакого контакта, то сделай его
    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
    }
    //проверяем кол-во контактов до удаления
    int before = app.getContactHelper().getContactCount();
    //выбор контакта (на удаление)
    app.getContactHelper().initContactSelected(before - 1);
    //нажатие кнопки Delite ля удаления выбранного контакта
    app.getContactHelper().deleteSelectedContact();
    // закрытие диалогового окна которое появляется при удалении контакта (поп апное окошко)
    app.getContactHelper().approveDeletion();
    //переходим на станицу с контактами
    app.getNavigationHelper().gotoContactPage();
    //проверяем кол-во контактов после удаления
    int after = app.getContactHelper().getContactCount();
    //сравниваем кол-во контактов до и после удаления
    Assert.assertEquals(after, before - 1);
  }
}
