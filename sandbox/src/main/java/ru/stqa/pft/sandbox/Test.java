package ru.stqa.pft.sandbox;

public class Test {

    public static void main(String[] args) {
        chek("настройки окружения");
        chek("сборки");
        chek("работоспособности");

        double l = 5;
        System.out.println("Площадь квадрата со стороной " + l + " = " + area(l));

        double a = 4;
        double b = 6;
        System.out.println("Площадь прямоугольника " + a + " и " + b + " = " + area(a, b));
    }

    public static void chek (String somebody) {
        System.out.println("Проверка " + somebody);
    }

    public static double area (double len) {
        return len * len;
    }

    public static double area (double a, double b) {
        return a * b;
    }

}