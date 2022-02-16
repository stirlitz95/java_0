package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {
  public static void main(String[] args) {

    String[] langs = {"Java", "C#", "Python", "PHP"};

    //или можно так
//    String[] langs = new String[4];
//    langs[0] = "Java";
//    langs[1] = "C#";
//    langs[2] = "Python";
//    langs[3] = "PHP";

    //можно считать что это аналог инициализации массива с помощью фигурных скобок; в " < > " указывается тип которые входят в этот список
    List<String > languages = Arrays.asList("Java", "C#", "Python", "PHP");

    //или можно так
//    List<String > languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");

    //итерация по элементам; "langs.length" получение длины массива
    for (String l : languages){
      System.out.println("Я хочу выучить " + l);
    }
  }
}
