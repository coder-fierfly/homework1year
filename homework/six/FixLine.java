package homework.six;

/*
Программа принимает две строки на вход. Первая строка содержит наборы
значений в виде «<строка>:<целое число>», где строка может содержать только
буквы из английского и русского алфавита и пробелы, а числа являются положительными
и уникальными, не повторяются. Каждый набор разделяется символом «;» (точка с запятой).
Вторая строка содержит набор целых чисел, разделённых символом «-» (тире). Необходимо
составить строку, заменив числа из второй строки, сохранив порядок и убрав символы
тире, строками из первой строки, для которых задано соответствующее число.
В случае отсутствия соответствия чисел – наличие числа во второй строке и его отсутствии
в первой – вместо числа подставлять символ «_» (подчёркивание).
Пример
Ввод:
He:42;o:1;l:34; w:7;d:0
42-34-34-1-7-1-5-34-0
Вывод:
Hello wo_ld
*/
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Integer.valueOf;

public class FixLine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        HashMap<Integer, String> lettersByNum = new HashMap<>();
        String[] newLine = line.split(";");
        for (String piece : newLine) {
            String[] finalLine = piece.split(":");
            lettersByNum.put(valueOf(finalLine[1]), finalLine[0]);
        }

        String digits = sc.nextLine();
        String[] digitsLine = digits.split("-");
        for (String digit : digitsLine) {
            System.out.print(lettersByNum.getOrDefault(valueOf(digit), "_"));
        }
    }
}
