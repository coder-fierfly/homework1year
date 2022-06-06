package homework.five;

/*
В консоли вводятся изначальная цена товара на начало месяца с учетом изначального процента инфляции (целое или
вещественное число), изначальный процент инфляции (целое или вещественное число), количество месяцев – N (целое
число), и N чисел соответственно, каждое из которых является разницей между процентом инфляции k-го месяца и предыдущего
(k-1) месяца. Инфляция может быть отрицательной – программа должна учитывать дефляцию (снижение цены на товар).
Следует учитывать, что цена товара не может быть ниже или быть равной нулю – в этом случае следует вывести сообщение об
обвале экономики и завершить программу. В случае некорректного ввода, просить пользователя ввести значение ещё раз.
Необходимо рассчитать и напечатать стоимость товара по истечению всех месяцев. Округлить полученное значение до двух
знаков после запятой.
        Пример
        Ввод:
        129.99
        10
        3
        5
        -7
        0
        Вывод:
        174,36
        Ход решения для пояснения:
        Изначальная цена 129.99, инфляция 10%
        Первый месяц: инфляция 10+5 = 15%, цена товара 129.99 * (100% + 15 ) = 149,4885
        Второй месяц: инфляция 15+(-7) = 8, цена товара 149,4885 * (100% + 8%) = 161,44758
        Третий месяц: инфляция 8+0 = 8%, цена товара 161,44758 * (100% + 8%) = 174,3633864
*/

import java.util.Scanner;

public class Inflation {

    public static void main(String[] args) {

        int num;
        String line;

        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter the prise");
            line = sc.nextLine();
        } while (!line.matches("^(([1-9]\\d*)|([1-9]\\d*\\.\\d+)|(0\\.\\d+))$"));
        float ourPrice = Float.parseFloat(line);

        System.out.println("Enter the percent");
        while (!sc.hasNextFloat()) {
            System.out.println("Enter the digit");
            sc.next();
        }
        float inflation = sc.nextFloat();

        do {
            System.out.println("Enter the number of months:");
            while (!sc.hasNextInt()) {
                System.out.println("Try again!");
                sc.next();
            }
            num = sc.nextInt();
        } while (num <= 0);

        float[] percent = new float[num];

        for (int i = 0; i < num; i++) {
            System.out.println("Enter the percent");
            while (!sc.hasNextFloat()) {
                System.out.println("Enter the digit");
                sc.next();
            }
            percent[i] = sc.nextFloat();
        }

        ourPrice = getInflarion(inflation, ourPrice, percent, num);
        if (ourPrice > 0) {
            System.out.printf("%.2f", ourPrice);
        } else {
            System.out.println("Crash system.");
        }
    }

    public static float getInflarion(float inflation, float ourPrice, float[] percent, int num) {

        final float oneHundred = 100;
        percent[0] = percent[0] + inflation;
        ourPrice = ((ourPrice) * ((oneHundred + percent[0]) / oneHundred));
        if (ourPrice <= 0) {
            return ourPrice;
        }
        for (int i = 1; i < num; ++i) {
            percent[i] += percent[i - 1];
            ourPrice = (ourPrice / oneHundred) * (oneHundred + percent[i]);
            if (ourPrice <= 0) {
                break;
            }
        }
        return ourPrice;
    }
}
