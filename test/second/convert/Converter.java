package test.second.convert;

/*
Реализуйте интерфейс Converter из градусов по Цельсию в Кельвины (K)​, ​Фаренгейты​(F) и Ньютона(N).
Для каждой шкалы свой класс. Напишите главный класс, в котором main будет принимать 2 входных параметра: В какой
градус конвертировать (K, F, N) и сколько градусов по Цельсию.
        Пример:
        К 0
        Вывести температуру (если нужно округление, то округлить до сотых). Например:
        273.15
        Для конвертации температур можно использовать https://2mb.ru/konverter/temperatura/
        PS
        Прислать должны 5 классов: Интерфейс, 3 реализации и главный класс.
  */
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final double nine = 9;
        final double five = 5;
        final double thirtyTwo = 32;
        final double thirtyThree = 33;
        final double hundred = 100;
        String line = sc.nextLine();
        String[] newLine = line.split(" ");
        String choice = newLine[0];
        double digit = Integer.parseInt(newLine[1]);

        switch (choice) {
            case "K":
System.out.println(String.format("%.2f", Kelvin.convert(digit)));
                break;
            case "F":
                System.out.println(String.format("%.2f", Fahrenheit.convert(digit)));
                break;
            case "N":
                System.out.println(String.format("%.2f", Newton.convert(digit)));
                break;
            default:
                break;
        }
    }
}

