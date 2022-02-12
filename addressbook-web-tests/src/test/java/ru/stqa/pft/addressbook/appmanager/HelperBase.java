package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  protected WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  protected void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void type(By locator, String text) {
    click(locator);
    //если текст не равен null то заполняем поле ввода
    if (text != null) {
      //если текст оказался не null тогда извлекаем из поля то значение что в нем хранится
      String existingText = wd.findElement(locator).getAttribute("value");
      // если не верно, что текст совпадает с уже  существующим текстом тогда выполняем какие-то действия с этим полем ввода
      if (!text.equals(existingText)) {
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
      }
    }
  }

  public boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  public boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // закрытие диалогового окна которое появляется при удалении контакта (поп апное окошко)
  public void returnToContactPage() {
    wd.switchTo().alert().accept();
  }
}
