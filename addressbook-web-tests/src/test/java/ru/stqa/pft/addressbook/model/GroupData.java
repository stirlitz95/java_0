package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  //тут атрибуты
  private int id = Integer.MAX_VALUE;
  private String name;
  private String header;
  private String footer;

/*
  //это конструктор без индентификатора в качестве параметра (присваиваем null в качестве идентификатора)
  public GroupData(String name, String header, String footer) {
    //далее идет присваивание значения параметра в атрибут в поле обекта
    this.id = Integer.MAX_VALUE; // эта переменная не прочитана из веб интерфейса, а создана искусственно
    this.name = name;
    this.header = header;
    this.footer = footer;
  }

  //это конструктор
  public GroupData(int id, String name, String header, String footer) {
    //далее идет присваивание значения параметра в атрибут в поле обекта
    this.id = id;
    this.name = name;
    this.header = header;
    this.footer = footer;
  }
*/

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public GroupData withId(int id) {
    this.id = id;
    return this;
  }

  public GroupData withName(String name) {
    this.name = name;
    return this;
  }

  public GroupData withHeader(String header) {
    this.header = header;
    return this;
  }

  public GroupData withFooter(String footer) {
    this.footer = footer;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }


  @Override
  //это создано для текстового представления элемента (когда это будет касаться ошибки связанной с name и id)
  public String toString() {
    return "GroupData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
  }

}
