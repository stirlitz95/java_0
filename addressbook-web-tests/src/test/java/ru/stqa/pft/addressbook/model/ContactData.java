package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private String id;
  private String name;
  private String middleName;
  private String lastName;
  private String telephoneHome;
  private String mail;
  private String group;



  public ContactData(String id, String name, String middleName, String lastName, String telephoneHome, String mail, String group) {
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
//    this.id = null; - эта строчка не влияет на модификацию, проверить на создании и удалении
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

  public String getId() { return id; }

  public String getName() { return name; }

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


  @Override
  //метод toString чтобы понимать что написано в ошибке
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
//мотод иквелс при сравнении объектов будет сравнивать их атрибуты
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, lastName);
  }



}
