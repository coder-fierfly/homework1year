package lab.first;
/*
Из небольшого текста удалить все символы, кроме пробелов, не являющиеся буквами. Между последовательностями
подряд идущих букв оставить хотя бы один пробел.
*/
import java.util.Scanner;

public class Deletion {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String reg = "[^a-zA-Zа-яА-ЯёЁ\\s]+";
        System.out.println("Enter text: ");
        String str = in.nextLine();
        String result = str.replaceAll(reg, "");
        System.out.println("Result: ");
        System.out.println(result);
        in.close();
    }
}

