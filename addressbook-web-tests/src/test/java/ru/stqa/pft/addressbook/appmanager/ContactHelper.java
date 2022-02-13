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

  public void updateContact() {
    click(By.name("update"));
  }

  public void deleteSelectedContact() {
    click(By.xpath("//input[@value='Delete']"));
  }

  public void initContactSelected() {
    click(By.name("selected[]"));
  }

  //временно отключаю и использую повторно в ContactModification метод fillContact
//  public void editContact(String name, String middleName, String lastName, String telephoneHome, String email) {
//    type(By.name("firstname"), name);
//    type(By.name("middlename"), middleName);
//    type(By.name("lastname"), lastName);
//    type(By.name("home"), telephoneHome);
//    type(By.name("email"), email);
//  }

  public void initContactEdit() {
    click(By.xpath("//img[@alt='Edit']"));
  }

}
