package lab.second;

// Написать регулярное выражение, определяющее является ли заданная строка правильным IPv6-адресом
import java.util.Scanner;

public class IpvSix {

    public static void main(String[] args) {

        Scanner ck = new Scanner(System.in);
        System.out.println("Enter IPv6");
        String address = ck.nextLine();
        System.out.println(address.matches("^((\\d|[a-fA-F]){0,4}:){2,7}"
                + "((\\d|[a-fA-F]){0,4})$"));
    }
}
