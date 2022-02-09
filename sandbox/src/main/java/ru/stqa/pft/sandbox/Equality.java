package ru.stqa.pft.sandbox;

public class Equality {

  public static void main (String[] args){
    String s1 = "firefox";
    //String s2 = s1; // тут пременая ссылается на старый объект s1
    String s2 = new String(s1); // тут пременая ссылается на новый объект
    //String s2 = "firefox"; // все переменные которые ссылаются на одну и туже литеральную строку, будут ссылаться на один физический объект

    System.out.println(s1 == s2 ); //сравнение ссылок (индентичность объектов), это физическое сравнение
    System.out.println(s1.equals(s2)); // equals сравнивает содержимое объектов, это логическое сравнение
    // " == " это для сравнения чисел , " equals " это для сравнения объектов
  }
}
