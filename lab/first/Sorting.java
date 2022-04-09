package lab.first;
/*
Ввести n строк с консоли. Упорядочить и вывести строки в порядке возрастания их длин, а также (второй приоритет)
значений этих их длин.
*/
import java.util.Arrays;
import java.util.Scanner;

public class Sorting {
    public static void main(String[] args) {

        int num = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of strings: ");
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("This character is not a number.");
            scanner.close();
        }

        System.out.println("Enter the strings to be ordered.");
        String[] str = new String[num];
        Integer[] line = new Integer[num];
        for (int i = 0; i < num; ++i) {
            System.out.println("Enter " + (i + 1) + " string: ");
            str[i] = scanner.next();
            line[i] = str[i].length();
        }
        scanner.close();
        Arrays.sort(str);

        for (int i = 0; i < num; ++i) {
            line[i] = str[i].length();
        }
        for (int i = num - 1; i > 0; --i) {
            for (int j = 0; j < i; j++) {
                if (line[j] > line[j + 1]) {
                    int buff = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = buff;
                    String a = str[j];
                    str[j] = str[j + 1];
                    str[j + 1] = a;
                }
            }
        }
        for (int i = 0; i < num; i++) {
            System.out.println(str[i] + " (Length is " + str[i].length() + ")");
        }
    }
}