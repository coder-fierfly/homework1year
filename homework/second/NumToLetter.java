package homework.second;
/* В консоли вводятся десять чисел от 0 до 9 включительно.К каждому числу необходимо прибавить
значение 65, затем их необходимо привести к символьному типу и объединить все символы в одну
строку в той же последовательности, как они были введены в консоли. Сформированную строку
вывести в консоль.

Пример:
Ввод:
0
1
2
3
Вывод:
ABCD
 */
import java.util.Scanner;

public class NumToLetter {
    public static void main(String[] args) {

        final int a = 10;
        final int b = 65;

        System.out.println("Enter the values(0-9): ");
        Scanner num = new Scanner(System.in);
        StringBuilder massif = new StringBuilder();

        for (int i = 0; i < a; ++i) {
            int[] line = new int[a];
            line[i] = num.nextInt();
            do {
                if (line[i] >= 0 && line[i] < a) {
                    line[i] += b;
                    char letter = (char) line[i];
                    massif.append(letter);
                } else {
                    System.out.println("The variable must be between 0 and 9. Try again.");
                }
            } while (line[i] >= 0 && line[i] < a);
        }
        num.close();
        System.out.println(massif);
    }
}
