package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{
  public WebDriver wd;

  public ContactHelper(WebDriver wd) {
    super(wd);
      }

  public void submitContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

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
//    wd.switchTo().alert().accept();
  }

  public void initContactSelected() {
    click(By.name("selected[]"));
  }

  public void editContact(String name, String middleName, String lastName, String telephoneHome, String email) {
    type(By.name("firstname"), name);
    type(By.name("middlename"), middleName);
    type(By.name("lastname"), lastName);
    type(By.name("home"), telephoneHome);
    type(By.name("email"), email);
  }

  public void initContactEdit() {
    click(By.xpath("//img[@alt='Edit']"));
  }

}
