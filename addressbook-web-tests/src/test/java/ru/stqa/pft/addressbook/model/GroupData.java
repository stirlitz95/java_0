package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  //тут атрибуты
  private int id;
  private final String name;
  private final String header;
  private final String footer;

  //это конструктор без индентификатора в качестве параметра (присваиваем null в качестве идентификатора)
  public GroupData( String name, String header, String footer) {
    //далее идет присваивание значения параметра в атрибут в поле обекта
    this.id = 0; // эта переменная не прочитана из веб интерфейса, а создана искусственно
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

  public int getId() { return id; }

  public String getName() {
    return name;
  }

  public String getHeader() {
    return header;
  }

  public String getFooter() {
    return footer;
  }

  public void setId(int id) { this.id = id; }

  @Override
  //это метод equals, при сравнении объектов он будет сравнивать их атрибуты (тут в частности это name и id) //но все работало и без этого
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(id, groupData.id) && Objects.equals(name, groupData.name);
  }

  @Override
  //создалось вместе с "public boolean equals(Object o)"
  public int hashCode() {
    return Objects.hash(id, name);
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
