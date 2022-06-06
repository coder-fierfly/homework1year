package homework.six;

/* Программа считывает целочисленные значения с консоли в три независимых коллекции.
В начале работы программа ожидает ввод числа в первую коллекцию. Переключение между
коллекциями осуществляется вводом в консоль команды «STREAM 1», «STREAM 2» и «STREAM 3».
Ввод чисел и переключение между коллекциями в программе должно продолжаться до тех пор, пока в
консоль не будет введена команда конца ввода – «END». После окончания ввода программа должна
сформировать новую коллекцию чисел, каждое число в котором является суммой чисел из одной и той же
позиции из каждой коллекции. При этом, если в одной коллекции отсутствует число по заданной
позиции, то есть числа в нём закончились, то необходимо найти сумму чисел из двух других коллекций.
Если чисел по заданной позиции нет уже в двух коллекциях – итоговый поток просто дозаполняется
числами из той коллекции, где они остались. Итоговую коллекцию чисел вывести на печать в одну
строку. Также, в ходе работы программы допускается случаи, когда любая коллекция не будет содержать
числа. Если же все коллекции пустые, вывести сообщение, что итоговая коллекция пуста.
Пример.
Ввод:
1
2
3
4
STREAM 3
10
20
STREAM 2
4
0
-7
STREAM 1
99
END
Вывод:
15 22 -4 4 99
 */
import java.util.ArrayList;
import java.util.Scanner;

public class ThreadMerging {

    public static void main(String[] args) {

        final int firstChoice = 1;
        final int secondChoice = 2;
        final int thirdChoice = 3;
        boolean end = false;
        boolean ended;
        String str;
        Scanner sc = new Scanner(System.in);
        boolean finalEnd = false;

        ArrayList<Integer> stream1 = new ArrayList<>();
        ArrayList<Integer> stream2 = new ArrayList<>();
        ArrayList<Integer> stream3 = new ArrayList<>();

        int choice = firstChoice; // для добавления с 1 кейса

        do {
            switch (choice) {

                case firstChoice:
                    do {
                        if (sc.hasNextInt()) {
                            do {
                                int num = sc.nextInt();
                                sc.nextLine();
                                stream1.add(num);
                                ended = false;
                            } while (sc.hasNextInt());
                        } else {
                            str = sc.nextLine();
                            if (str.equals("STREAM 2")) {
                                choice = secondChoice;
                                ended = true;
                            } else if (str.equals("STREAM 3")) {
                                choice = thirdChoice;
                                ended = true;
                            } else if (str.equals("END")) {
                                end = true;
                                ended = true;
                            } else {
                                ended = false;
                            }
                        }
                    } while (!ended);
                    break;

                case secondChoice:
                    do {
                        if (sc.hasNextInt()) {
                            int num = sc.nextInt();
                            sc.nextLine();
                            stream2.add(num);
                            ended = false;
                        } else {
                            str = sc.nextLine();
                            if (str.equals("STREAM 1")) {
                                choice = firstChoice;
                                ended = true;
                            } else if (str.equals("STREAM 3")) {
                                choice = thirdChoice;
                                ended = true;
                            } else if (str.equals("END")) {
                                end = true;
                                ended = true;
                            } else {
                                ended = false;
                            }
                        }
                    } while (!ended);
                    break;

                case thirdChoice:
                    do {
                        if (sc.hasNextInt()) {
                            int num = sc.nextInt();
                            sc.nextLine();
                            stream3.add(num);
                            ended = false;
                        } else {
                            str = sc.nextLine();
                            if (str.equals("STREAM 1")) {
                                choice = firstChoice;
                                ended = true;
                            } else if (str.equals("STREAM 2")) {
                                choice = secondChoice;
                                ended = true;
                            } else if (str.equals("END")) {
                                end = true;
                                ended = true;
                            } else {
                                ended = false;
                            }
                        }
                    } while (!ended);
                    break;
                default:
                    break;
            }
        } while (!end);

        if (stream1.isEmpty() && stream2.isEmpty() && stream3.isEmpty()) {
            System.out.println("All group is empty");
        } else {
            int cellNum = 0;
            do {
                if (cellNum < stream1.size() && cellNum < stream2.size() && cellNum < stream3.size()) {
                    System.out.print(stream1.get(cellNum) + stream2.get(cellNum) + stream3.get(cellNum));
                } else if (cellNum >= stream1.size() && cellNum >= stream2.size() && cellNum < stream3.size()) {
                    System.out.print(stream3.get(cellNum));
                } else if (cellNum >= stream1.size() && cellNum < stream2.size() && cellNum >= stream3.size()) {
                    System.out.print(stream2.get(cellNum));
                } else if (cellNum < stream1.size() && cellNum >= stream2.size() && cellNum >= stream3.size()) {
                    System.out.print(stream1.get(cellNum));
                } else if (cellNum >= stream1.size() && cellNum < stream2.size() && cellNum < stream3.size()) {
                    System.out.print(stream2.get(cellNum) + stream3.get(cellNum));
                } else if (cellNum < stream1.size() && cellNum >= stream2.size() && cellNum < stream3.size()) {
                    System.out.print(stream1.get(cellNum) + stream3.get(cellNum));
                } else if (cellNum < stream1.size() && cellNum < stream2.size() && cellNum >= stream3.size()) {
                    System.out.print(stream1.get(cellNum) + stream2.get(cellNum));
                } else {
                    finalEnd = true;
                }
                System.out.print(" ");
                ++cellNum;
            } while (!finalEnd);
        }
    }
}


