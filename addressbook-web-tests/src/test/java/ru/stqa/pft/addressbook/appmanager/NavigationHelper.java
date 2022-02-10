package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase{

  public WebDriver wd;

  NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void gotoHome() {
    click(By.linkText("home page"));
  }

  public void gotoAddNew() {
    click(By.linkText("add new"));
  }

  public void gotoContactPage() {
    click(By.linkText("home"));  }
}
