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

  @Override
  //метод toString чтобы понимать что написано в ошибке
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  @Override
  //мотод иквелс при сравнении объектов будет сравнивать их атрибуты
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (name != null ? !name.equals(that.name) : that.name != null) return false;
    return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
  }

  @Override
  public int hashCode() {
    int result = name != null ? name.hashCode() : 0;
    result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
    return result;
  }
}
