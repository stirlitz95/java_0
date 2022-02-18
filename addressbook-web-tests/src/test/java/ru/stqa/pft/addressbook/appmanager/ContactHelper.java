package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void submitContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContact(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("email"), contactData.getMail());

    //если это элемент создания, то элемент "new_group" должен быть
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      //в если этого нето, значит это изменение и этого элемента быть не должно
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  //используется в public void createContact чтобы не использовать условие выбора (boolean) в "public void fillContact(ContactData contactData, boolean creation)"
  public void fillContact(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("middlename"), contactData.getMiddleName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("home"), contactData.getTelephoneHome());
    type(By.name("email"), contactData.getMail());
  }

  public void updateContact() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactSelected() {
    click(By.name("selected[]"));
  }


  public void initContactEdit() {
    click(By.xpath("//img[@alt='Edit']"));
  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  //вызвал NavigationHelper чтобы заработала строчка gotoA.gotoAddNew();
  NavigationHelper gotoA = new NavigationHelper(wd);

  //создаю новый контакт в случае выполнения теста на удаление контакта "ContactDeletion", а удалять нечего (так же учитывая отсутствие группы, поскольку группы тоже могут быть не созданы)
  //создаю новый контакт в случае выполнения теста на модификацию контакта "ContactModification", а модифицировать нечего (так же учитывая отсутствие группы, поскольку группы тоже могут быть не созданы)
  public void createContact(ContactData contactData) {
    gotoA.gotoAddNew();
    fillContact(contactData);
    submitContact();
    gotoA.gotoHome();
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }
}
