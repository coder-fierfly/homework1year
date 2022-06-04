package homework.second;
/* Вводится строка из произвольных символов. Необходимо вывести на консоль среднюю
кодовых значений всех символов строки (сумма всех кодовых значений символов / кол-во символов).

        Пример:
        Ввод:
        Apple
        Вывод:
        99.6
*/
import java.util.Scanner;

public class CodeValueLength {

    public static void main(String[] args) {

        double sum = 0;

        System.out.println("Enter a string of letters: ");
        Scanner sk = new Scanner(System.in);
        String originalLine = sk.nextLine();

        for (double symbol : originalLine.toCharArray()) {
            sum += symbol;
        }

        System.out.printf("Average line code values %f.", sum / originalLine.length());
    }
}
