package test.first;

/*
В кириллическом тексте каждую букву заменить ее номером в алфавите (для верхнего регистра смещение +33).
Числа выделить в квадратных скобках.
        Пример:
        Ввод: Привет! Как дела?
        Вывод: [50][18][10][3][6][20]! [45][1][12] [5][6][13][1]?
*/
import java.util.Scanner;

public class LetToNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String string = in.nextLine();
        String let = "абвгдеёжзийклмнопрстуфхцчшщъыбэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫБЭЮЯ";

        char[] sts = new char[string.length()];
        int k;
        sts = string.toCharArray();

        for (int i = 0; i < string.length(); i++) {
            if (Character.isLetter(sts[i])) {
                k = let.lastIndexOf(sts[i]);
                System.out.print("[" + (k + 1) + "]");
            } else {
                System.out.print(sts[i]);
            }
        }
    }
}
