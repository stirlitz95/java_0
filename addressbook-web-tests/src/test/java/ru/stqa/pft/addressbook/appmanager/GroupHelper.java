package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {


  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupFrom(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroup(int index) {
    //находим все элементы по локатору "selected[]" и среди этих элементов выбираем нужный по индексу "(index)", и по нему выполняем click()
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void initGroupModification() {
    click(By.name("edit"));
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  //создание группы (применяется на случай есои где-то нужно создать группу кроме как GroupCreationTests)
  public void create(GroupData group) {
    initGroupCreation();
    fillGroupFrom(group);
    submitGroupCreation();
    returnToGroupPage();
  }

  //действия для модификации группы
  public void modifi(int index, GroupData group) {
    //метод берет последнюю группу по индексу "before.size() - 1" ( "- 1" потому что нумерация начинается с "0")
    selectGroup(index);
    //выбираем группу которую далее будем менять
    initGroupModification();
    fillGroupFrom(group);
    submitGroupModification();
    returnToGroupPage();
  }

  //метод для удаления группы
  public void delete(int index) {
    //метод берет последнюю группу по индексу "before.size() - 1" ( "- 1" потому что нумерация начинается с "0")
   selectGroup(index);
    deleteSelectedGroups();
    returnToGroupPage();
  }

  //выполняется проверка какого-то элемента
  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  //возвращение количества найденных элементов в то место где запрашивают "getGroupCount()"
  public int getGroupCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<GroupData> list() {
    List<GroupData> groups = new ArrayList<GroupData>();
    //получение списка объектов типа "WebElement"/ найти все элементы которые имеют тег "span" и класс "group"
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    //проход по элементам в цикле
    for (WebElement element : elements) {
      String name = element.getText();
      //ищем элемент в нутри другого / этот идентификатор передаем в конструктор, он используется при сравнении
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      //добавляем созданный объект в список
      groups.add(new GroupData().withId(id).withName(name));
    }
    return groups;
  }
}
