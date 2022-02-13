package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {


  NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    //если присутствует элемент "h1"
    if (isElementPresent(By.tagName("h1"))
            // и верно что текст этого заголовка = "Groups"
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            // и присутствует элемент который = "new"
            && isElementPresent(By.name("new"))) {
      //если это условие выполняется, то выходим из этого метода
      return;
    }
    //а если те условия не выполнились то двигаемся дальше и происходит click
    click(By.linkText("groups"));
  }

  public void gotoHome() {
    click(By.linkText("home page"));
  }

  public void gotoAddNew() {
    click(By.linkText("add new"));
  }

  public void gotoContactPage() {
    //если присутствует елемент "maintable"
    if (isElementPresent(By.id("maintable"))){
      //то делать ничего не надо
      return;
    }
    //а если те условия не выполнились то двигаемся дальше и происходит click
    click(By.linkText("home"));
  }
}
