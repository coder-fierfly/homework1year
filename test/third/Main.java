package test.third;

/*
На вход программе подаются строки, содержащие телефонные номера. Выведите "Correct", если номер в строке проходит по
формату, затем в этой же строке выведите преобразованный номер в международном формате, например "+79035553399"
Если номера нет или он не в правильном формате, выведите "No"
Правильными считаются номера, в которых присутствует 10 цифр(возможно, с разделителями), и, опционально, 8, +7 или 7.
        Пример:
        Ввод:
        Вася, позвони Пете, его номер 8903 1234567.
        Петя, привет, нет, 903 500 01 11 - не его номер.:(
        А какой?
        Вроде 123 в конце.
        Не знаю, попробуй 79991112233
        Вывод:
        Correct:+79031234567
        Correct:+79035000111
        No
        No
        Correct:+79991112233
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        StringBuilder buffer = new StringBuilder();
        do {
            list.add(sc.nextLine());
            if ((list.get(list.size() - 1).equals(""))) {
                break;
            }
        } while (true);
        for (String o : list) {
            if (!o.equals("")) {
                String line = o.replaceAll("[^0-9+]", "");
                if (line.matches("^(((8|\\+?7))?([\\d]){10})$")) {
                    line = line.replaceAll("^(8|7)", "+7");
                    line = line.replaceAll("^(9)", "+79");
                    buffer.append("Correct:" + line);
                } else {
                    buffer.append("No");
                }
                buffer.append("\n");
            }
        }
        System.out.println(buffer.toString());
    }
}
