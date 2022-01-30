package ru.stqa.pft.home;

import static java.lang.Math.*;


public class Point {

  private double x;
  private double y;


  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public String toString(){
    return "{" + x + ";" + y + "}";
  }

  public static double distance(Point p1, Point p2) {
    return sqrt(pow((p2.x - p1.x), 2.0) + pow((p2.y - p1.y), 2.0));
  }


  public double distance(Point p) {
    return sqrt(pow((p.x - x), 2.0) + pow((p.y - y), 2.0));
  }

  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }
}

