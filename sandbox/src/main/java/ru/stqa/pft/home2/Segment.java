package ru.stqa.pft.home2;

public class Segment {
  public static void main(String[] args){

    Point d = new Point(1,1,5,5);
    System.out.println("Расстояние между двумя точками " + d.x1 + " : " + d.y1 + " и " + d.x2 + " : " + d.y2 + " = " + d.area ());
  }
}
