package homework.second;/* В консоль вводятся три числа с обязательной дробной частью. Необходимо найти и
вывести на консоль в следующем порядке:
1) Сумму введённых чисел
2) Сумму введённых чисел без учёта дробной части
3) Разницу первой и второй найденных сумм

Пример:
Ввод:
1.5
3.6
2.3
Вывод:
7.4
6.0
1.4
 */

import java.util.Scanner;

public class SimpleCalc {

    public static void main(String[] args) {

        float a = 0;
        float b = 0;
        float c = 0;
        boolean verity;

        Scanner in = new Scanner(System.in);
        System.out.println("Enter the first value: ");
        do {
            if (in.hasNextFloat()) {
                a = in.nextFloat();
                verity = true;
            } else {
                System.out.println("The data must be of float type. Try it again.");
                in.nextLine();
                verity = false;
            }
        } while (!verity);

        System.out.println("Enter the second value: ");
        do {
            if (in.hasNextFloat()) {
                b = in.nextFloat();
                verity = true;
            } else {
                System.out.println("The data must be of float type. Try it again.");
                in.nextLine();
                verity = false;
            }
        } while (!verity);

        System.out.println("Enter the third value: ");
        do {
            if (in.hasNextFloat()) {
                c = in.nextFloat();
                verity = true;
            } else {
                System.out.println("The data must be of float type. Try it again.");
                in.nextLine();
                verity = false;
            }
        } while (!verity);
        in.close();

        float sum1 = a + b + c;
        int sum2 = (int) (a + b + c);
        System.out.printf("Sum of entered numbers: %f\n", sum1);
        System.out.printf("The sum of the fractional part disregarded: %d\n", sum2);
        System.out.printf("Difference between first and second sum: %f", sum1 - sum2);
    }
}
