package homework.five;

/*
В консоли вводятся количество чисел – N, и N чисел соответственно. Числа могут быть целыми или вещественными. В случае
некорректного ввода, просить пользователя ввести число ещё раз. Необходимо вычислить и напечатать среднеквадратическое
отклонение из введённых чисел. Округлить полученное значение до трёх знаков после запятой.
        Пример
        Ввод:
        5
        4
        5.2
        1.2
        -6
        0
        Вывод:
        3.914
*/

import java.util.Scanner;

public class Deviation {

    public static void main(String[] args) {

        int amount;
        float up = 0;
        float sum = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount");

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer.");
                sc.nextLine();
            }
            amount = sc.nextInt();
            sc.nextLine();
            if (amount < 2) {
                System.out.println("The number must be greater than 2.");
            }
        } while (amount < 2);

        float[] digit = new float[amount];
        for (int i = 0; i < amount; i++) {
            System.out.println("Enter the digit");
            do {
                if (!sc.hasNextFloat()) {
                    sc.next();
                    System.out.println("Please enter a number.");
                }
            } while (!sc.hasNextFloat());
            digit[i] = sc.nextFloat();
        }

        for (int i = 0; i < amount; i++) {
            sum += digit[i];
        }

        float ourSum = sum / amount;

        for (int i = 0; i < amount; i++) {
            up += Math.pow((digit[i] - ourSum), 2);
        }

        float deviation = (float) Math.sqrt(up / amount);
        System.out.printf("%.3f", deviation);
    }
}
