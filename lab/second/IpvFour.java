package lab.second;

// Написать регулярное выражение, определяющее является ли заданная строка правильным IPv4-адресом
import java.util.Scanner;

public class IpvFour {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter IPv4");
        String str = sc.nextLine();
        // str matches from 0.0.0.0 to 255.255.255.255
        System.out.println(str.matches("^((\\d\\.|[1-9]\\d\\.|1\\d{2}\\.|2[1-4]\\d\\.|"
                + "25[0-5]\\.){3}(\\d|[1-9]\\d|1\\d{2}|2[1-4]\\d|25[0-5]))$"));
    }
}
