package lab.second;

// Написать регулярное выражение для Формата ISO 8601
import java.util.Scanner;

public class Time {

    public static void main(Str[] args) {

        String data;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter date and time in ISO 8601 format.");
        data = sc.nextLine();
        System.out.println(data.matches("^((\\d{4})-(0[1-9]|1[0-2])"
                + "-([1-2]\\d|3[0-1]|0[1-9])(T)([0-1]\\d|2[0-3])(:[0-5]\\d){2}"
                + "(Z)|(\\d{4})-(0[1-9]|1[0-2])-([1-2]\\d|3[0-1]|0[1-9])\\s([0-1]\\d|"
                + "2[0-3])(:[0-5]\\d){2}(\\+|\\-)(([0-1]\\d|2[0-3])(|((:|)[0-5]\\d)|"
                + "[0-5]\\d)))$"));
    }
}
