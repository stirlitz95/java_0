package ru.stqa.pft.addressbook.delegationSample;

public class Bbb {


  private Aaa aaa = new Aaa();

  public void print(String s) {
    aaa.print(s);
  }
}
