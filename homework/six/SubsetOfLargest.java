package homework.six;
/*
Программа считывает и сохраняет в коллекцию положительные числа (целые и вещественные) до
тех пор, пока пользователь не введёт число 0. Ноль при этом никуда не сохраняется и не
используется для дальнейших вычислений. Необходимо найти среднее значение из всех введённых
чисел и вывести все числа, что больше найденному среднему значению, в порядке возрастания
без повторов одинаковых чисел.
Пример 7/n 2/n 2/n 3/n 0/n Вывод 7
*/

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class SubsetOfLargest {

    public static void main(String[] args) {

        boolean zero;
        ArrayList<Double> getDigit = new ArrayList<>();

        System.out.println("Enter a digit.");
        Scanner sc = new Scanner(System.in);

        do {
            if (sc.hasNextDouble()) {
                double num = sc.nextDouble();
                if (num > 0) {
                    zero = false;
                    getDigit.add(num);
                } else if (num < 0) {
                    zero = false;
                    System.out.println("Enter a number greater than 0.");
                    sc.nextLine();
                } else {
                    zero = true;
                }
            } else {
                System.out.println("Please enter digit.");
                sc.nextLine();
                sc.nextLine();
                zero = false;
            }
        } while (!zero);

        if (getDigit.size() == 0) {
            System.out.println("You entered nothing.");
        } else {
            double sum = 0;
            for (Double digit : getDigit) {
                sum += digit;
            }
            double middle = (sum / getDigit.size());
            TreeSet<Double> newGetDigit = new TreeSet<>(getDigit);
            newGetDigit = (TreeSet<Double>) newGetDigit.tailSet(middle, false);
            for (Double object : newGetDigit) {
                System.out.println(object + " ");
            }
        }
    }
}