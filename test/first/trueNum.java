package test.first;

import java.util.Scanner;
/*
Вывести является заданная последовательность числом (допустима десятичная запятая или точка):
        Пример:
        на вход: 1234567890.0987654321
        на выходе: true

        на вход: 01
        на выходе: false

        на вход: 111A
        на выходе: false
*/
public class trueNum {

    public static void main(String[] args) {
        System.out.println("enter digit:");
        Scanner ck = new Scanner(System.in);
        String line = ck.nextLine();
        System.out.println(line.matches("^(([1-9]\\d{0,}"
                + "(,|\\.){1}\\d{1,})|[1-9]\\d{0,})$"));
    }
}
