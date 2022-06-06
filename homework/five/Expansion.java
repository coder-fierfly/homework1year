package homework.five;

/*
В консоль вводится целое число k. В случае некорректного ввода, просить пользователя ввести число ещё раз. Необходимо
определить, существует ли такое число n, что 1+2+3+...+n=k. В качестве ответа вывести значение true / false. Также, в
случае если число n существует, вывести значение числа n.
        Пример
        Ввод:
        28
        Вывод:
        true
        7
*/
import java.util.Scanner;

public class Expansion {

    public static void main(String[] args) {

        int a = 0;
        int b = 0;

        Scanner sc = new Scanner(System.in);

        while (!sc.hasNextInt()) {
            System.out.println("Enter digit");
            sc.next();
        }

        int ourNum = sc.nextInt();

        do {
            a++;
            b += a;
        } while (b < ourNum);

        if (b == ourNum) {
            System.out.println(true);
            System.out.println(a);
        } else {
            System.out.println(false);
        }
    }
}
