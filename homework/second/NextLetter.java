package homework.second;
/* В консоль вводится строка, состоящая только их букв латинского алфавита верхнего и
 нижнего регистра и пробелов. Необходимо сформировать новую строку, где каждая буква
 заменена на следующую букву в алфавите с сохранением регистра (а->b, C->D). При этом
 последняя буква заменяется на первую, также с сохранением регистра.

Пример:
Ввод:
Apple
Вывод:
Bqqmf
*/

import java.util.Scanner;

public class NextLetter {

    public static void main(String[] args) {

        String str;
        StringBuilder massif = new StringBuilder();

        do {
            System.out.print("Enter a string of letters: ");
            Scanner sk = new Scanner(System.in);
            str = sk.nextLine();
        } while (str.matches("(.*)[^a-zA-Z| ](.*)"));

        for (char letter : str.toCharArray()) {
            if ('Z' == letter) {
                letter = 'A';
            } else if ('z' == letter) {
                letter = 'a';
            } else if (' ' != letter) {
                ++letter;
            }
            massif.append(letter);
        }
        System.out.println("Your code: " + massif);
    }
}
