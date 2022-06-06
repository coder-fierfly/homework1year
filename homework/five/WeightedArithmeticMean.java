package homework.five;

/*
В консоли вводятся количество значений – N, и N значений соответственно в одном из форматов (для примера значения 3 с
весом 2): «x: 3; p: 2», «p: 2; x: 3» или «x: 3» (вес по умолчанию равен значению 1, т.е. эквивалентно записям «x: 3; p:
1» и «p: 1; x: 3»). Оба значения могут быть как целыми числами, так и вещественными. В случае несоответствия формату,
просить пользователя ввести число ещё раз. Необходимо вычислить и напечатать среднее арифметическое взвешенное из
введённых чисел. Округлить полученное значение до трёх знаков после запятой.
        Пример
        Ввод:
        5
        x: 4; p: 3
        x: 5.2; p: 2
        p: 1.2; x: 3
        x: -6
        x: 0
        Вывод:
        2.439
*/
import java.util.Scanner;

public class WeightedArithmeticMean {

    public static void main(String[] args) {

        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount");

        do {
            while (!sc.hasNextInt()) {
                System.out.println("Please enter an integer.");
                sc.nextLine();
            }
            num = sc.nextInt();
            sc.nextLine();
            if (num < 2) {
                System.out.println("The number must be greater than 2.");
            }
        } while (num < 2);

        double[][] newArray = new double[num][2];

        for (int i = 0; i < num; ++i) {
            boolean isBadInput;
            System.out.println("Enter the value and its weight.");
            do {
                String line;
                line = sc.nextLine();
                isBadInput = false;
                if (line.matches("^(x:\\s-?((\\d|[1-9]\\d+)|((\\d|[1-9]\\d+)\\.\\d+));"
                        + "\\sp:\\s-?((\\d|[1-9]\\d+)|((\\d|[1-9]\\d+)\\.\\d+)))$")) {
                    String[] array = line.replaceAll("[xp: ]", "").split(";");
                    newArray[i][0] = Double.parseDouble(array[0]);
                    newArray[i][1] = Double.parseDouble(array[1]);
                } else if (line.matches("^(p:\\s-?((\\d|[1-9]\\d+)|((\\d|[1-9]\\d+)\\.\\d+));\\sx:\\s-?"
                        + "((\\d|[1-9]\\d+)|((\\d|[1-9]\\d+)\\.\\d+)))$")) {
                    String[] array = line.replaceAll("[xp: ]", "").split(";");
                    newArray[i][0] = Double.parseDouble(array[1]);
                    newArray[i][1] = Double.parseDouble(array[0]);
                } else if (line.matches("^(x:\\s-?((\\d|[1-9]\\d+)|((\\d|[1-9]\\d+)\\.\\d+)))$")) {
                    String helper = line.replaceAll("[x: ]", "");
                    newArray[i][0] = Double.parseDouble(helper);
                    newArray[i][1] = Double.parseDouble("1");
                } else {
                    isBadInput = true;
                }
            } while (isBadInput);
        }

        double up = 0;
        double under = 0;
        double result;

        for (int i = 0; i < num; i++) {
            up += newArray[i][0] * newArray[i][1];
            under += newArray[i][1];
        }

        result = up / under;
        System.out.printf("%.3f", result);
    }
}
