package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HelperBase {
  public WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }


  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
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

  public boolean isElementPresent(By locator) {
    try {
      wd.findElement(locator);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  //метод позволяет проверить наличие диалового окна, если оно есть, то ты на нег переключишься, а если его нет появляется ошибка "NoAlertPresentException"
  public boolean isAlertPresent() {
    //попытаться перехватить
    try {
      wd.switchTo().alert();
      return true;
    //а если не получилось, то перехвать исключение (в скобках тип исключения которое собираешься перехватывать (а если оно будет другого типа, то она перехвачено не будет))
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  // закрытие диалогового окна которое появляется при удалении контакта (поп апное окошко)
  public void approveDeletion() {
    wd.switchTo().alert().accept();
  }
}
