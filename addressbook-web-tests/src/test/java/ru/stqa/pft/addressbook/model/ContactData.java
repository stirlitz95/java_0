package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String name;
  private final String middleName;
  private final String lastName;
  private final String telephoneHome;
  private final String mail;
  private String group;

  public ContactData(String name, String middleName, String lastName, String telephoneHome, String mail, String group) {
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.telephoneHome = telephoneHome;
    this.mail = mail;
    this.group = group;
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
}
