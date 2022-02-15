package ru.stqa.pft.addressbook.model;

public class ContactData {
  private String name;
  private String middleName;
  private String lastName;
  private String telephoneHome;
  private String mail;
  private String group;

  public ContactData(String name, String middleName, String lastName, String telephoneHome, String mail, String group) {
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
}
