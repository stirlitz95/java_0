package ru.stqa.pft.sandbox;

public class Test {

    public static void main(String[] args) {
        chek("настройки окружения");
        chek("сборки");
        chek("работоспособности");

        Square s = new Square(5);
        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Rectangle r = new Rectangle (4, 6);
        System.out.println("Площадь прямоугольника " + r.a + " и " + r.b + " = " + r.area());
    }

    public static void chek (String somebody) {
        System.out.println("Проверка " + somebody);
    }


}