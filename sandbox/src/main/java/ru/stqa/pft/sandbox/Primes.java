package ru.stqa.pft.sandbox;

public class Primes {

  public static boolean isPrime(int n) {
    // инициализация переменной/где должен остановиться счетчик/что происходит с переменной счетчика на каждой переменной цикла
    for (int i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPrimeFast(int n) {
    //"(int)" приведение к целому числу, "Math.sqrt(n)" извлечение корня из n
    int m = (int) Math.sqrt(n);
    for (int i = 2; i < m ; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }


  public static boolean isPrimesWhile(int n) {
    int i = 2;
    while (i < n && n % i != 0) {
      i++;
    }
    return i == n;
  }

  public static boolean isPrime(long n) {
    // инициализация переменной/где должен остановиться счетчик/что происходит с переменной счетчика на каждой переменной цикла
    for (long i = 2; i < n; i++) {
      if (n % i == 0) {
        return false;
      }
    }
    return true;
  }
}
