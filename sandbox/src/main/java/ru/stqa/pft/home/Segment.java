package ru.stqa.pft.home;

public class Segment {
  public static void main(String[] args){

    Point p1 = new Point(1,1);
    Point p2 = new Point(10,10);
    System.out.println();
    System.out.println("Расстояние между двумя точками " + p1.x + " : " + p1.y + " и " + p2.x + " : " + p2.y + " = " + Point.distance(p1, p2));
  }
}
