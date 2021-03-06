package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletion extends TestBase {


  @Test
  public void testContactDeletion() throws Exception {
    //переходим на станицу с контактами
    app.goTo().gotoContactPage();
    //если не существует никакого контакта, то сделай его
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Имя", "Отчeство", "Фамилия", "880005553535", "xxx.ru"));
    }
    //проверяем кол-во контактов до удаления
    List<ContactData> before = app.getContactHelper().getContactList();
    //выбор контакта (на удаление)
    app.getContactHelper().initContactSelected(before.size() - 1);
    //нажатие кнопки Delite ля удаления выбранного контакта
    app.getContactHelper().deleteSelectedContact();
    // закрытие диалогового окна которое появляется при удалении контакта (поп апное окошко)
    app.getContactHelper().approveDeletion();
    //переходим на станицу с контактами
    app.goTo().gotoContactPage();
    //проверяем кол-во контактов после удаления
    List<ContactData> after = app.getContactHelper().getContactList();
    //сравниваем кол-во контактов до и после удаления
    Assert.assertEquals(after.size(), before.size() - 1);

    //заставляем считать старый список за новый
    before.remove(before.size() - 1);
    //и теперь сравниваем два списка (благодаря предыдущей строчке они должны быть одинаковы)
    Assert.assertEquals(before, after);

  }
}
