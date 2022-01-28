package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.home.Point;

public class PointTests {

  @Test
  public void testPoint(){
    Point p1 = new Point(1,1);
    Point p2 = new Point(10,10);
    Assert.assertEquals(Point.distance(p1,p2), 12.727922061357855);

  }
}
