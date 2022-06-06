package homework.six;
/*
Программа считывает пары строк, разделённых двоеточием, то есть в формате «<строка>:<строка>».
Каждая строка представляет собой адрес электронной почты. Левая часть пары обозначает
отправителя письма, а правая получателя. Известно, что каждая почта может присутствовать
только один раз в левой части любой пары, и только один раз в правой части любой пары. Также
известно, что почта не может быть указана одновременно в левой и правой частях одной пары, и
не будет введено такие две пары, где одни и те же почты выступают в роли отправителя и
получателя и наоборот (если с почты test1@mail.ru было отправлено письмо на почту test2@mail.ru,
то не будет случая, когда с почты test2@mail.ru было отправлено письмо на почту test1@mail.ru).
Ввод заканчивается при введении строки «END». Программа должна составить и вывести цепочки всех
пересылок с почту на почту, причём цепочки должны начинаться только с тех почт, что не являлись
посредниками в пересылке письма, то есть являлись только отправителями, но не являлись
получателями. Формат печати цепочки в примере.
Пример
Ввод:
alex@mail.ru:nick@mail.ru
victor@mail.ru:maria@mail.ru
nick@mail.ru:andrew@mail.ru
maria@mail.ru:kate@mail.ru
andrew@mail.ru:petr@mail.ru
END
Вывод:
alex@mail.ru > nick@mail.ru > andrew@mail.ru > petr@mail.ru
victor@mail.ru > maria@mail.ru > kate@mail.ru
*/

import java.util.LinkedHashMap;
import java.util.Scanner;

public class ForwardingChain {

    public static void main(String[] args) {

        LinkedHashMap<String, String> participants = new LinkedHashMap<>();
        Scanner sc = new Scanner(System.in);
        boolean end;

        // идет получение строк
        do {
            String line = sc.nextLine();
            if (line.equals("END")) {
                end = true;
            } else if (line.matches(".+[:].+")) {
                String[] newLine = line.split(":");
                participants.put(newLine[0], newLine[1]);
                end = false;
            } else {
                System.out.println("Please try again.");
                sc.nextLine();
                end = false;
            }
        } while (!end);

        // ищем изначальных отправителей
        for (String key1 : participants.keySet()) {
            if (!participants.containsValue(key1)) {
                System.out.print(key1);
                while (participants.containsKey(key1)) {
                    key1 = participants.get(key1);
                    System.out.print(" > ");
                    System.out.print(key1);
                }
                System.out.println();
            }
        }
    }
}


