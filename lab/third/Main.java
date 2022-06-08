package lab.third;

/*
Реализовать интерфейсы: Array, Linked, Map
1) Написать класс, который позволяет через командную строчку создавать на выбор динамическую структуру и заполнять ее.
ARRAY - Array, LINKED - Linked, MAP - Map
2) Далее вывести количество элементов в структуре и спросить у пользователя хочется ли он вывести все элементы.
YES - означает, вывести, NO - не выводить и перейти к следующему шагу. Если пользователь ввел команду YES, то выводится
список элементов, каждый элемент в новой строке (для map вывести ключ -> значение, для остальных просто значение).

3) Далее спросить у пользователя, хочется ли он получить конкретный элемент по индексу или по ключу. YES означает, что
хочет. NO, что не хочет. Если пользователь ввел YES, то необходимо дождаться, что он введет индекс или ключ (в
зависимости от типа данных для map это ключ, для остальных - индекс). Далее вывести полученных элемент, а также
необходимо количество миллисекунд для этого действия. Текущее количество миллисекунд можно получить с помощью метода
java.lang.System.currentTimeMillis()
Необходимо прислать в zip архиве 7 классов:
        1) 3 выданных интерфейса
        2) 3 реализации каждого интерфейса
        3) Main, где будет реализована работа через консоль
*/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int firstChoice = 1;
        final int secondChoice = 2;
        final int thirdChoice = 3;
        int choice = 0;
        String string;
        boolean bool;

        System.out.println("Какую структуру следует создать? (ARRAY/LINKED/MAP)");
        do {
            bool = true;
            string = in.nextLine();
            if (string.equalsIgnoreCase("ARRAY")) {
                choice = firstChoice;
            } else if (string.equalsIgnoreCase("LINKED")) {
                choice = secondChoice;
            } else if (string.equalsIgnoreCase("MAP")) {
                choice = thirdChoice;
            } else {
                System.out.println("Попробуйте ввести снова");
                bool = false;
            }
        } while (!bool);

        System.out.println("Введите элементы структуры: ");
        System.out.println("(После окончания вывода введите \"END\".)");

        switch (choice) {

            case firstChoice:
                OurArray arr = new OurArray();
                string = in.nextLine();
                while (!string.equalsIgnoreCase("END")) {
                    arr.add(string);
                    string = in.nextLine();
                }

                System.out.println("Сейчас в структуре " + arr.size() + " элементов.");

                System.out.println("Хотите ли вы вывести все элементы в консоль? (YES/NO)");
                do {
                    bool = true;
                    string = in.nextLine();
                    if (string.equalsIgnoreCase("YES")) {
                        for (int i = 0; i < arr.size(); i++) {
                            System.out.println(arr.get(i));
                        }
                    } else if (string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели получать элементы.");
                    } else {
                        System.out.println("Попробуйте снова");
                        bool = false;
                    }
                } while (!bool);

                System.out.println("Хотите получить элемент по индексу?(YES/NO)");
                do {
                    bool = true;
                    string = in.nextLine();
                    if (string.equalsIgnoreCase("YES")) {
                        System.out.println("Введите индекс элемента, который хотите получить: ");
                        int digit = 0;
                        do {
                            if (in.hasNextInt()) {
                                digit = in.nextInt();
                                bool = true;
                            } else {
                                System.out.println("Введите число.");
                                in.nextLine();
                                bool = false;
                            }
                        } while (!bool);
                        long start = java.lang.System.currentTimeMillis();
                        System.out.println(arr.get(digit));
                        long fin = java.lang.System.currentTimeMillis();
                        long res = fin - start;
                        System.out.println("Затраченное время: " + res);
                    } else if (string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели получать элемент.");
                    } else {
                        System.out.println("Попробуйте снова.");
                        bool = false;
                    }
                } while (!bool);
                break;

            case secondChoice:
                OurLinked lin = new OurLinked();
                string = in.nextLine();
                while (!string.equalsIgnoreCase("END")) {
                    lin.add(string);
                    string = in.nextLine();
                }

                System.out.println("Сейчас в структуре " + lin.size() + " элементов.");

                System.out.println("Хотите ли вы вывести все элементы в консоль? (YES/NO)");
                do {
                    bool = true;
                    string = in.nextLine();
                    if (string.equalsIgnoreCase("YES")) {
                        for (int i = 0; i < lin.size(); i++) {
                            System.out.println(lin.get(i));
                        }
                    } else if (string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели получать элементы.");
                    } else {
                        System.out.println("Попробуйте снова.");
                        bool = false;
                    }
                } while (!bool);

                System.out.println("Хотите ли вы получить конкретный элемент по индексу?");
                do {
                    string = in.nextLine();
                    bool = true;
                    if (string.equalsIgnoreCase("YES")) {
                        System.out.println("Введите индекс элемента, который хотите получить: ");
                        int digit = 0;
                        do {
                            bool = true;
                            if (in.hasNextInt()) {
                                digit = in.nextInt();
                            } else {
                                System.out.println("Введите число.");
                                bool = false;
                            }
                        } while (!bool);
                        long start = java.lang.System.currentTimeMillis();
                        System.out.println(lin.get(digit));
                        long fin = java.lang.System.currentTimeMillis();
                        long res = fin - start;
                        System.out.println("Затраченное время: " + res);
                    } else if (string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели получать элемент.");
                    } else {
                        System.out.println("Попробуйте снова.");
                        bool = false;
                    }
                } while (!bool);
                break;

            case thirdChoice:
                OurMap map = new OurMap();
                do {
                    int value;
                    string = in.nextLine();
                    if (!string.equalsIgnoreCase("END")) {
                        value = in.nextInt();
                        in.nextLine();
                        map.put(string, value);
                    }
                } while (!string.equalsIgnoreCase("END"));

                System.out.println("Сейчас в структуре " + map.size() + " элементов.");

                System.out.println("Хотите ли вы вывести все элементы в консоль? (YES/NO)");
                do {
                    string = in.nextLine();
                    bool = true;
                    if (string.equalsIgnoreCase("YES")) {
                        map.print();
                    } else if (!string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели выводить элементы.");
                    } else {
                        System.out.println("Попробуйте снова");
                        bool = false;
                    }
                } while (!bool);

                System.out.println("Хотите ли вы получить конкретный элемент по ключу?");
                do {
                    bool = true;
                    string = in.nextLine();
                    if (string.equalsIgnoreCase("YES")) {
                        System.out.println("Введите ключ элемента, который хотите получить: ");
                        String str = in.nextLine();
                        long start = java.lang.System.currentTimeMillis();
                        System.out.println(map.get(str));
                        long fin = java.lang.System.currentTimeMillis();
                        long res = fin - start;
                        System.out.println("Затраченное время: " + res);
                    } else if (string.equalsIgnoreCase("NO")) {
                        System.out.println("Вы не захотели получать элемент.");
                    } else {
                        System.out.println("Попробуйте снова.");
                        bool = false;
                    }
                } while (!bool);
                break;

            default:
                break;
        }
    }
}