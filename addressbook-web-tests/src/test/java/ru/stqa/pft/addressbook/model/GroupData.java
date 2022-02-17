package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupData {
  private final String name;
  private final String header;
  private final String footer;

  public GroupData(String name, String header, String footer) {
    this.name = name;
    this.header = header;
    this.footer = footer;
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

  @Override
  //это создано для текстового представления элемента (когда это будет касаться ошибки связанной с name
  public String toString() {
    return "GroupData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  //это метод equals, при сравнении объектов он будет сравнивать их атрибуты (тут в частности это name) //но все работало и без этого
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupData groupData = (GroupData) o;
    return Objects.equals(name, groupData.name);
  }

  @Override
  //создалось вместе с "public boolean equals(Object o)"
  public int hashCode() {
    return Objects.hash(name);
  }
}
