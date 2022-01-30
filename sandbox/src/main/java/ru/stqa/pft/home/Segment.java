package ru.stqa.pft.home;

public class Segment {
  public static void main(String[] args) {

    Point p1 = new Point(1, 1);
    Point p2 = new Point(10, 10);
    System.out.println();
    System.out.println("Расстояние между двумя точками " + p1 + " и " + p2 + " = " + Point.distance(p1, p2));
    System.out.println();
    System.out.println("Расстояние между двумя точками " + p1 + " и " + p2 + " = " + p1.distance(p2));
    System.out.println();

    p1.setX(5);
    p1.setY(5);
    p2.setX(15);
    p2.setY(15);
    System.out.println("Расстояние между двумя точками " + p1 + " и " + p2 + " = " + p1.distance(p2));
  }
}
