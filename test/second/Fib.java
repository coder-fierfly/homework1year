package test.second;

/*Серия Фибоначчи - это серия элементов, в которой используются два предыдущих элемента, чтобы получить следующий
элемент, начиная с 0 и 1. В этой задаче необходимо написать функцию, которая будет генерировать ряд Фибоначчи.
Способ реализации любой, главный принцип - чем быстрее тем лучше. Функция которую необходимо написать должна принимать
два значения: начальная позиция последовательности; конечная позиция последовательности.
Возвращать функция должна строку с числами последовательности разделенными пробелами.
        Пример входных параметров
        10
        15
        Ожидается на выходе
        55 89 144 233 377
*/
import java.util.Scanner;

import static java.lang.Math.pow;
import static java.lang.Math.round;
import static java.lang.Math.sqrt;

public class Fib {
    public static void main(String[] args) {

        Scanner cmd = new Scanner(System.in);
        System.out.println("Введите начальный и конечный номера:");
        System.out.println(getFib(cmd.nextInt(), cmd.nextInt()));

    }

    public static String getFib(int start, int end){
        Scanner scan = new Scanner(System.in);
        StringBuilder result = new StringBuilder();

        for (int i = start; i < end; ++i) {
            int number = (int) round(pow((1 + sqrt(5)) / 2, i) / sqrt(5));
            result.append(String.format("%d ", number));
        }

        return result.toString();
    }

    public static int getInt(){
        int a;
        while(true){
            Scanner cmd = new Scanner(System.in);
            try{
                a = cmd.nextInt();
                if(a > 0)
                    return a;
                else
                    System.out.print("Input >0 num: ");
            }catch(Exception exep){
                System.out.print("Try again: ");
            }
        }
    }
}
