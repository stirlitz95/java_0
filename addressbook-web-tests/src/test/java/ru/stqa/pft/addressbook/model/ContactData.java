package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private String name;
  private String middleName;
  private String lastName;
  private String telephoneHome;
  private String mail;
  private String group;


  public ContactData(int id, String name, String middleName, String lastName, String telephoneHome, String mail, String group) {
    this.id = id;
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneHome = telephoneHome;
    this.mail = mail;
    this.group = group;
  }


  //используется когда мешает id при модификации контакта
  public ContactData(String name, String middleName, String lastName, String telephoneHome, String mail, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneHome = telephoneHome;
    this.mail = mail;
    this.group = group;
  }

  //использовать если тесту мешает отсутствие группы ("String group" в public ContactData)
  public ContactData(String name, String middleName, String lastName, String telephoneHome, String mail) {
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneHome = telephoneHome;
    this.mail = mail;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getTelephoneHome() {
    return telephoneHome;
  }

  public String getMail() {
    return mail;
  }

  public String getGroup() {
    return group;
  }

  public void setId(int max) {
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName);
  }


  @Override
  //метод toString чтобы понимать что написано в ошибке
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }


}
