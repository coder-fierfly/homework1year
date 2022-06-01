package lab.second;

/*
Написать регулярное выражение, определяющее является ли данная строка строкой "abcdefghijklmnopqrstuv18340" или нет.
        – пример правильных выражений: abcdefghijklmnopqrstuv18340.
        – пример неправильных выражений: abcdefghijklmnoasdfasdpqrstuv18340.
*/
import java.util.Scanner;

public class Str {
    public static void main(java.lang.String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the line (abcdefghijklmnopqrstuv18340): ");
        String text = in.nextLine();
        System.out.println(text.matches("^abcdefghijklmnopqrstuv18340$"));
    }
}
